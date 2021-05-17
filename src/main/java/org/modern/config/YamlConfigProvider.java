package org.modern.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.modern.config.exception.BindException;
import org.modern.config.utils.JsonNodeUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author pengjian05
 */
public class YamlConfigProvider implements ConfigProvider {

    private final static ObjectMapper yamlObjectMapper = new ObjectMapper(new YAMLFactory());

    static {
        yamlObjectMapper.findAndRegisterModules();
    }

    private File file;

    private JsonNode root;

    public YamlConfigProvider(File file) throws IOException {
        this.file = file;
        root = yamlObjectMapper.readTree(file);
    }

    @Override
    public <T> T bind(String pointPath, Class<T> tClass) {
        try {
            JsonNode childNode = JsonNodeUtils.readPointPathValue(pointPath, root);
            return yamlObjectMapper.treeToValue(childNode, tClass);
        } catch (IOException e) {
            throw new BindException(e.getCause());
        }
    }

}
