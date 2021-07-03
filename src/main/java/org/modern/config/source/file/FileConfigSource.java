package org.modern.config.source.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modern.config.source.ConfigSource;

import java.io.File;
import java.io.IOException;

public abstract class FileConfigSource implements ConfigSource {

    protected final File file;

    public FileConfigSource(String fileName) throws IOException {
        this.file = new File(fileName);
    }

    public FileConfigSource(File file) throws IOException {
        this.file = file;
    }
}
