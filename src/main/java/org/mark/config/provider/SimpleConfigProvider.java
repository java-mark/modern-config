package org.mark.config.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mark.config.exception.ConfigBindException;
import org.mark.config.source.ConfigNode;
import org.mark.config.source.ConfigSource;

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
