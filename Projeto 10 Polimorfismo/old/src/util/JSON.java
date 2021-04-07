package src.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSON {
    private Map<String, Object> objects;

    public JSON() {
        this.objects = new HashMap<>();
    }

    public static String formater(String jsonString) {

        Matcher m1 = Pattern.compile("\"[a-zA-Z_0-9]+\"+\s*[:]\s*").matcher(jsonString);
        while (m1.find()) {
            String find = m1.group();
            jsonString = jsonString.replaceAll(find, find.replaceAll("\s*[:]\s*", ":"));
        }

        return jsonString.trim().replaceAll(",?\"[a-zA-Z_0-9]+\"\s*:\s*[{]+\s*[}]", "");
    }

    // public static JSON parse(String jsonString) {

    // JSON json = new JSON();

    // jsonString = JSON.formater(jsonString);

    // for (int i = 1; i < jsonString.length(); i++) {
    // if (jsonString.charAt(i) == '"') {
    // StringBuilder key = new StringBuilder();
    // StringBuilder value = new StringBuilder();
    // int j;
    // for (j = i + 1; j < jsonString.length(); j++) {
    // if (jsonString.charAt(j) == '"') {
    // break;
    // } else {
    // key.append(jsonString.charAt(j));
    // }
    // }

    // int son = -1;
    // int matrix = -1;
    // boolean number = false;
    // for (int k = j + 2; k < jsonString.length(); k++) {
    // StringBuilder save = new StringBuilder();
    // if (jsonString.charAt(j + 2) == '"') {
    // if (k != j + 2 && jsonString.charAt(k) != '"') {
    // value.append(jsonString.charAt(k));
    // } else
    // break;
    // } else {
    // if (jsonString.charAt(j + 2) == '{')
    // son = 1;
    // else if (jsonString.charAt(j + 2) == '[')
    // matrix = 1;
    // else {
    // number = true;
    // }

    // if (jsonString.charAt(k) == '{' && (son != -1 || number))
    // son++;
    // else if (jsonString.charAt(k) == '}' && (son != -1 || number))
    // son--;
    // else if (jsonString.charAt(k) == '[' && (matrix != -1 || number))
    // matrix++;
    // else if (jsonString.charAt(k) == ']' && (matrix != -1 || number))
    // matrix--;

    // if (!((!number && (son == 1 && jsonString.charAt(k) == '}'
    // || matrix == 1 && jsonString.charAt(k) == ']'))
    // || (son == -1 && matrix == -1 && jsonString.charAt(k) == ','))) {
    // save.append(jsonString.charAt(k));
    // }

    // else if (son == 1) {
    // save.append("}");
    // value.append(JSON.parse(save.toString()));
    // break;
    // } else if (matrix == 1) {
    // // ainda por fazer
    // } else {
    // value.append(save.toString());
    // }
    // }

    // }
    // }
    // }

    // return json;
    // }

    public static JSON create(String keys, String... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Integer... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Float... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Double... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Boolean... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Long... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, Matrix... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    public static JSON create(String keys, JSON... values) {
        JSON json = new JSON();
        int i = 0;
        for (String key : keys.trim().split(";")) {
            json.add(key, values[i++]);
        }

        return json;
    }

    JSON addObject(String key, Object value) {
        objects.computeIfAbsent(key, v -> value);
        return this;
    }

    public JSON add(String key, String value) {
        return addObject(key, value);
    }

    public JSON add(String key, Boolean value) {
        return addObject(key, value);
    }

    public JSON add(String key, Integer value) {
        return addObject(key, value);
    }

    public JSON add(String key, Float value) {
        return addObject(key, value);
    }

    public JSON add(String key, Double value) {
        return addObject(key, value);
    }

    public JSON add(String key, Long value) {
        return addObject(key, value);
    }

    public JSON add(String key, Matrix value) {
        return addObject(key, value);
    }

    public JSON add(String key, JSON value) {
        return addObject(key, value);
    }

    public static String keyToJsonFormatter(String key, Object value) {
        if (value instanceof Boolean || value instanceof Integer || value instanceof Double || value instanceof Float
                || value instanceof Long || value instanceof Matrix || value instanceof JSON) {
            return String.format("\"%s\":%s", key, value.toString());
        } else {
            return String.format("\"%s\":\"%s\"", key, value.toString());
        }
    }

    @Override
    public String toString() {

        StringBuilder jsonString = new StringBuilder();

        jsonString.append("{");
        for (Map.Entry<String, Object> obj : objects.entrySet()) {
            String key = obj.getKey();
            Object value = obj.getValue();

            jsonString.append(JSON.keyToJsonFormatter(key, value)).append(",");

        }
        if (jsonString.length() > 2) {
            jsonString.setLength(jsonString.length() - 1);
        }
        jsonString.append("}");
        return jsonString.toString();
    }
}
