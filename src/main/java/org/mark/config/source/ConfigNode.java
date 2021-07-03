package org.mark.config.source;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Slf4j
public class ConfigNode {
    private final static ObjectMapper jsonObjectMapper = new ObjectMapper();

    static {
        jsonObjectMapper.findAndRegisterModules();
    }

    private final JsonNode jsonNode;

    public ConfigNode(JsonNode jsonNode) {
        this.jsonNode = requireNonNull(jsonNode);
    }

    public Optional<ConfigNode> getChild(String name) {
        JsonNode node = jsonNode.get(name);
        if (Objects.isNull(node)) {
            return Optional.empty();
        } else {
            return Optional.of(new ConfigNode(node));
        }
    }

    public <T> T treeToValue(Class<T> tClass) throws JsonProcessingException {
        return jsonObjectMapper.treeToValue(jsonNode, tClass);
    }

    /**
     * read point path
     *
     * @param pointPath
     * @return config node which want to access
     */
    public ConfigNode readPointPathValue(String pointPath) throws IllegalAccessException {
        String[] segments = pointPath.split("\\.");
        log.debug("Segment result={}", Arrays.toString(segments));

        ConfigNode parent = this;
        for (String segment : segments) {
            Optional<ConfigNode> child = parent.getChild(segment);
            if (child.isPresent()) {
                parent = child.get();
            } else {
                throw new IllegalAccessException("Cannot access segment=" + segment + "in full path=" + pointPath);
            }
        }
        return parent;
    }
}
