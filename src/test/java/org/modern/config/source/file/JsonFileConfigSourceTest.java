package org.modern.config.source.file;

import org.junit.jupiter.api.Test;
import org.modern.config.source.ConfigNode;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileConfigSourceTest {
    @Test
    void testConstruct() throws IOException {
        JsonFileConfigSource jsonFileConfigSource = new JsonFileConfigSource(
            "src/test/resources/research/jackson.json");
        ConfigNode node = jsonFileConfigSource.getRoot();
    }
}