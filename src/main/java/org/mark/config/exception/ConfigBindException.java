package org.mark.config.exception;

import org.mark.config.source.ConfigNode;

public class ConfigBindException extends RuntimeException {
    private static final String MSG = "Fail to bind %s to class=%s";

    public ConfigBindException(ConfigNode configNode, String className, Throwable cause) {
        super(String.format(MSG, configNode.toString(), className), cause);
    }
}
