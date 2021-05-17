package org.modern.config.research.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
public class JacksonJsonExample {
    JacksonJsonExample() {

    }

    void read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        File jacksonFile = new File("src/test/resources/research/jackson.json");
        JacksonYamlExample.Order order = mapper.readValue(jacksonFile,
            JacksonYamlExample.Order.class);
        log.info("order content={}", order);
    }

    <T> T parsePointPath(String path, Class<T> tClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        File jacksonFile = new File("src/test/resources/research/jackson.json");
        JsonNode jsonNode = objectMapper.readTree(jacksonFile);
        String[] segments = path.split("\\.");
        JsonNode parent = jsonNode;
        try {
            for (String segment : segments) {
                parent = parent.get(segment);
            }
            log.info("final node content={}", parent);
            return objectMapper.treeToValue(parent, tClass);
        } catch (Exception e) {
            log.warn("meet error");
            return null;
        }
    }


    @Data
    public static class Order {
        private String orderNo;
        private LocalDate date;
        private String customerName;
        private List<JacksonYamlExample.OrderLine> orderLines;
    }

    @Data
    public static class OrderLine {
        private String item;
        private int quantity;
        private BigDecimal unitPrice;
    }


    public static void main(String[] args) throws IOException {
        JacksonJsonExample jacksonJsonExample = new JacksonJsonExample();
//        jacksonJsonExample.read();
        log.info(jacksonJsonExample.parsePointPath("testObject.data", String.class));
    }
}
