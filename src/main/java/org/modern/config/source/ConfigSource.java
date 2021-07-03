package org.modern.config.source;

import java.io.IOException;

public interface ConfigSource {
    /**
     * get root node of config
     *
     * @return root config node
     * @throws IllegalStateException if cannot read root node from config
     */
    public ConfigNode getRoot();
}
