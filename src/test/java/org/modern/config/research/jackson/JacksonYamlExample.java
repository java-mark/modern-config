package org.modern.config.research.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
public class JacksonYamlExample {
    JacksonYamlExample() {

    }

    void parse() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        JsonNode res = mapper.readTree(new File("src/test/resources/research/jackson.yaml"));
        Order order = mapper.treeToValue(res, Order.class);
        log.info("order content={}", order);
    }

    @Data
    public static class Order {
        private String orderNo;
        private LocalDate date;
        private String customerName;
        private List<OrderLine> orderLines;
    }

    @Data
    public static class OrderLine {
        private String item;
        private int quantity;
        private BigDecimal unitPrice;
    }

    public static void main(String[] args) throws IOException {
        JacksonYamlExample jacksonYamlExample = new JacksonYamlExample();
        jacksonYamlExample.parse();
    }
}
