package person.pjzero.cfman;

/**
 * @author pengjian05
 */
public interface ConfigProvider {

    /**
     * bind spec path content to class type
     *
     * @param pointPath path from root
     * @param tClass    output class
     * @param <T>       class type
     * @return
     */
    <T> T bind(String pointPath, Class<T> tClass);
}
