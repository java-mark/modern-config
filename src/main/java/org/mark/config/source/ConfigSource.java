package org.mark.config.source;

public interface ConfigSource {
    /**
     * get root node of config
     *
     * @return root config node
     * @throws IllegalStateException if cannot read root node from config
     */
    public ConfigNode getRoot();
}
