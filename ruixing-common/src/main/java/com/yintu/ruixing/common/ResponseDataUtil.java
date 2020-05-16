package com.yintu.ruixing.common;

import java.util.HashMap;
import java.util.Map;

public class ResponseDataUtil {

    private static final Map<String, Object> map = new HashMap<>();
    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    public static Map<String, Object> ok(String message) {
        map.put(CODE, 200);
        map.put(MESSAGE, message);
        return map;
    }

    public static Map<String, Object> ok(String message, Object data) {
        map.put(CODE, 200);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        return map;
    }

    public static Map<String, Object> ok(String message, Object data, Map<String, Object> map) {
        map.put(CODE, 200);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        map.putAll(map);
        return map;
    }

    public static Map<String, Object> error(String message) {
        map.put(CODE, 500);
        map.put(MESSAGE, message);
        return map;
    }

    public static Map<String, Object> error(String message, Object data) {
        map.put(CODE, 500);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        return map;
    }

    public static Map<String, Object> error(String message, Object data, Map<String, Object> map) {
        map.put(CODE, 500);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        map.putAll(map);
        return map;
    }

}
