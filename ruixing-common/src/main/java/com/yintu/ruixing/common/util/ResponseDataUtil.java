package com.yintu.ruixing.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 200 成功 500 失败 401未登录 403 未授权
 */
public class ResponseDataUtil {


    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    public static Map<String, Object> ok(String message) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 200);
        returnData.put(MESSAGE, message);
        return returnData;
    }

    public static Map<String, Object> ok(String message, Object data) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 200);
        returnData.put(MESSAGE, message);
        returnData.put(DATA, data);
        return returnData;
    }

    public static Map<String, Object> ok(String message, Object data, Map<String, Object> map) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 200);
        returnData.put(MESSAGE, message);
        returnData.put(DATA, data);
        returnData.putAll(map);
        return returnData;
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 500);
        returnData.put(MESSAGE, message);
        return returnData;
    }

    public static Map<String, Object> error(String message, Object data) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 500);
        returnData.put(MESSAGE, message);
        returnData.put(DATA, data);
        return returnData;
    }

    public static Map<String, Object> error(String message, Object data, Map<String, Object> map) {
        Map<String, Object> returnData = new HashMap<>();
        map.put(CODE, 500);
        map.put(MESSAGE, message);
        map.put(DATA, data);
        map.putAll(map);
        return map;
    }

    public static Map<String, Object> noLogin(String message) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 401);
        returnData.put(MESSAGE, message);
        return returnData;
    }

    public static Map<String, Object> noLogin(String message, Object data) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 401);
        returnData.put(MESSAGE, message);
        returnData.put(DATA, data);
        return returnData;
    }

    public static Map<String, Object> noLogin(String message, Map<String, Object> map) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 401);
        returnData.put(MESSAGE, message);
        returnData.putAll(map);
        return returnData;
    }

    public static Map<String, Object> noAuthorize(String message) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 403);
        returnData.put(MESSAGE, message);
        return returnData;
    }

    public static Map<String, Object> noAuthorize(String message, Object data) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 403);
        returnData.put(MESSAGE, message);
        returnData.put(DATA, data);
        return returnData;
    }

    public static Map<String, Object> noAuthorize(String message, Map<String, Object> map) {
        Map<String, Object> returnData = new HashMap<>();
        returnData.put(CODE, 403);
        returnData.put(MESSAGE, message);
        returnData.putAll(map);
        return returnData;
    }

}
