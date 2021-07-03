package org.mark.config.source.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import org.mark.config.source.ConfigNode;

import java.io.File;
import java.io.IOException;

public class YamlFileConfigSource extends FileConfigSource {

    private final static ObjectMapper jsonObjectMapper = new ObjectMapper(new YAMLFactory());

    static {
        jsonObjectMapper.findAndRegisterModules();
    }

    private final ConfigNode configNode;

    public YamlFileConfigSource(String fileName) throws IOException {
        super(fileName);
        configNode = new ConfigNode(jsonObjectMapper.readTree(file));
    }

    public YamlFileConfigSource(File file) throws IOException {
        super(file);
        configNode = new ConfigNode(jsonObjectMapper.readTree(file));
    }

    @SneakyThrows
    @Override
    public ConfigNode getRoot() {
        return configNode;
    }
}
