package com.yintu.ruixing.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 200 成功 500 失败 401未登录 403 未授权
 */
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

    public static Map<String, Object> noLogin(String message) {
        map.put(CODE, 401);
        map.put(MESSAGE, message);
        return map;
    }

    public static Map<String, Object> noLogin(String message, Object data) {
        map.put(CODE, 401);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        map.putAll(map);
        return map;
    }

    public static Map<String, Object> noLogin(String message, Map<String, Object> map) {
        map.put(CODE, 401);
        map.put(MESSAGE, message);
        map.putAll(map);
        return map;
    }

    public static Map<String, Object> noAuthorize(String message) {
        map.put(CODE, 403);
        map.put(MESSAGE, message);
        return map;
    }

    public static Map<String, Object> noAuthorize(String message, Object data) {
        map.put(CODE, 403);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        map.putAll(map);
        return map;
    }

    public static Map<String, Object> noAuthorize(String message, Map<String, Object> map) {
        map.put(CODE, 403);
        map.put(MESSAGE, message);
        map.putAll(map);
        return map;
    }

}
