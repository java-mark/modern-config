package org.modern.config.utils;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.modern.config.exception.PointPathException;

import java.util.Arrays;

/**
 * @author pengjian05
 */
@Slf4j
public class JsonNodeUtils {
    /**
     * read point path
     *
     * @param pointPath
     * @param jsonNode
     * @return
     */
    public static JsonNode readPointPathValue(String pointPath, JsonNode jsonNode) {
        String[] segments = pointPath.split("\\.");
        log.debug("Segment result={}", Arrays.toString(segments));

        JsonNode parent = jsonNode;
        try {
            for (String segment : segments) {
                parent = parent.get(segment);
            }
            return parent;
        } catch (Exception e) {
            throw new PointPathException(pointPath, e.getCause());
        }
    }
}
