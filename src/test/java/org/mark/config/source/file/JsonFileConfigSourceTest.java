package org.mark.config.source.file;

import org.junit.jupiter.api.Test;
import org.mark.config.source.ConfigNode;

import java.io.IOException;

class JsonFileConfigSourceTest {
    @Test
    void testConstruct() throws IOException {
        JsonFileConfigSource jsonFileConfigSource = new JsonFileConfigSource(
            "src/test/resources/research/jackson.json");
        ConfigNode node = jsonFileConfigSource.getRoot();
    }
}