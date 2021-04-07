package src.util;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<Object> list;

    public Matrix() {
        this.list = new ArrayList<>();
    }

    public static Matrix create(String... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Integer... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Boolean... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Matrix... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Float... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Double... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(Long... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    public static Matrix create(JSON... values) {
        Matrix matrix = new Matrix();
        matrix.parseData(values);
        return matrix;
    }

    void parseDataObject(Object[] values) {
        this.list = new ArrayList<>();
        for (Object value : values)
            this.list.add(value);
    }

    public void parseData(String... values) {
        parseDataObject(values);
    }

    public void parseData(Integer... values) {
        parseDataObject(values);
    }

    public void parseData(Long... values) {
        parseDataObject(values);
    }

    public void parseData(Double... values) {
        parseDataObject(values);
    }

    public void parseData(Float... values) {
        parseDataObject(values);
    }

    public void parseData(Boolean... values) {
        parseDataObject(values);
    }

    public void parseData(Matrix... values) {
        parseDataObject(values);
    }

    public void parseData(JSON... values) {
        parseDataObject(values);
    }

    void addObject(Object value) {
        this.list.add(value);
    }

    public void add(String value) {
        addObject(value);
    }

    public void add(Integer value) {
        addObject(value);
    }

    public void add(Double value) {
        addObject(value);
    }

    public void add(Float value) {
        addObject(value);
    }

    public void add(Boolean value) {
        addObject(value);
    }

    public void add(Long value) {
        addObject(value);
    }

    public void add(Matrix value) {
        addObject(value);
    }

    public void add(JSON value) {
        addObject(value);
    }

    void removeObject(Object value) {
        this.list.remove(value);
    }

    public void remove(String value) {
        removeObject(value);
    }

    public void remove(Integer value) {
        removeObject(value);
    }

    public void remove(Double value) {
        removeObject(value);
    }

    public void remove(Float value) {
        removeObject(value);
    }

    public void remove(Boolean value) {
        removeObject(value);
    }

    public void remove(Long value) {
        removeObject(value);
    }

    public void remove(Matrix value) {
        removeObject(value);
    }

    public void remove(JSON value) {
        removeObject(value);
    }

    public void removeByIndex(int index) {
        this.list.remove(index);
    }

    public List<Object> getList() {
        return list;
    }

    public static String[] convert(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    public static String arrayToString(List<Object> values) {
        List<String> res = new ArrayList<>();

        for (Object obj : values) {
            if (obj instanceof Boolean || obj instanceof Integer || obj instanceof Double || obj instanceof Float
                    || obj instanceof Long || obj instanceof Matrix || obj instanceof JSON) {
                res.add(obj.toString());
            } else {
                res.add("\"" + obj.toString() + "\"");
            }
        }

        return String.format("[%s]", String.join(",", Matrix.convert(res)));
    }

    @Override
    public String toString() {
        return Matrix.arrayToString(list);
    }

}
