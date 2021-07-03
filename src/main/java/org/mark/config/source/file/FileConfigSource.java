package org.mark.config.source.file;

import org.mark.config.source.ConfigSource;

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
