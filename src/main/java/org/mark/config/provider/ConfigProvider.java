package org.mark.config.provider;

import org.mark.config.exception.ConfigBindException;

/**
 * @author pengjian05
 */
public interface ConfigProvider {

    /**
     * bind spec path content to class type
     * <p>
     * this implement imitate spring config module
     *
     * @param pointPath path from root
     * @param tClass    output class
     * @param <T>       class type
     * @return
     */
    <T> T bind(String pointPath, Class<T> tClass) throws IllegalAccessException, ConfigBindException;
}
