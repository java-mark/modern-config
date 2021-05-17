package org.modern.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modern.config.exception.BindException;
import org.modern.config.utils.JsonNodeUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author pengjian05
 */
public class JsonConfigProvider implements ConfigProvider {
    private final static ObjectMapper jsonObjectMapper = new ObjectMapper();

    static {
        jsonObjectMapper.findAndRegisterModules();
    }

    private File file;

    private JsonNode root;

    public JsonConfigProvider(File file) throws IOException {
        this.file = file;
        root = jsonObjectMapper.readTree(file);
    }

    @Override
    public <T> T bind(String pointPath, Class<T> tClass) {
        try {
            JsonNode childNode = JsonNodeUtils.readPointPathValue(pointPath, root);
            return jsonObjectMapper.treeToValue(childNode, tClass);
        } catch (IOException e) {
            throw new BindException(e.getCause());
        }
    }
}
