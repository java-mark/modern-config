package org.modern.config;

import static org.junit.jupiter.api.Assertions.*;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modern.config.provider.SimpleConfigProvider;
import org.modern.config.source.file.YamlFileConfigSource;

import java.io.IOException;

@Slf4j
class SimpleConfigProviderTest {

    @Data
    @ToString
    static class Foo {
        private String name;
    }

    @Test
    void testBind() throws IOException, IllegalAccessException {
        YamlFileConfigSource yamlFileConfigSource = new YamlFileConfigSource(
            "src/test/resources/research/jackson.yaml");
        SimpleConfigProvider provider = new SimpleConfigProvider(yamlFileConfigSource);
        Foo res = provider.bind("foo", Foo.class);
        log.info("res={}", res);
    }
}