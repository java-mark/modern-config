package org.modern.config.source.file;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.modern.config.source.ConfigNode;

import java.io.File;
import java.io.IOException;

public class JsonFileConfigSource extends FileConfigSource {

    private final static ObjectMapper jsonObjectMapper = new ObjectMapper(new JsonFactory());

    static {
        jsonObjectMapper.findAndRegisterModules();
    }

    private final ConfigNode configNode;

    public JsonFileConfigSource(String fileName) throws IOException {
        super(fileName);
        configNode = new ConfigNode(jsonObjectMapper.readTree(file));
    }

    public JsonFileConfigSource(File file) throws IOException {
        super(file);
        configNode = new ConfigNode(jsonObjectMapper.readTree(file));
    }

    @SneakyThrows
    @Override
    public ConfigNode getRoot() {
        return configNode;
    }
}
