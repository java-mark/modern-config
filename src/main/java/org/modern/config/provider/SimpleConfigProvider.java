package org.modern.config.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.modern.config.exception.ConfigBindException;
import org.modern.config.source.ConfigNode;
import org.modern.config.source.ConfigSource;

/**
 * @author pengjian05
 */
public class SimpleConfigProvider implements ConfigProvider {
    private final ConfigSource configSource;

    public SimpleConfigProvider(ConfigSource configSource) {
        this.configSource = configSource;
    }

    @Override
    public <T> T bind(String pointPath, Class<T> tClass) throws IllegalAccessException, ConfigBindException {
        ConfigNode res = configSource.getRoot().readPointPathValue(pointPath);
        try {
            return res.treeToValue(tClass);
        } catch (JsonProcessingException e) {
            throw new ConfigBindException(res, tClass.getName(), e);
        }
    }
}
