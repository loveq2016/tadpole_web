package com.cy.common.util;

/**
 * 随机字符串生成类
 * Created by kam on 2015/10/26.
 */
public class RandomString {
    private static final String src_number = "0123456789";
    private static final String src_lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String src_upper = src_lower.toUpperCase();
    private static final String src_hex_lower = "0123456789abcdef";
    private static final String src_hex_upper = src_hex_lower.toUpperCase();
    private static final String esc_char = "?";

    /**
     * 获得指定长度的随机字符串，由大小写字母+数字组合的随机字符串；
     *
     * @param size 指定长度
     * @return
     */
    public static String get(int size) {
        StringBuffer r = new StringBuffer(size);
        String src = src_number + src_upper;
        for (int i = 0; i < size; i++) {
            r.append(getRandomChar(src));
        }
        return r.toString();
    }

    /**
     * 产生如下格式的随机字符串“{E3-K91Z}”，“?”表示一个占位符；
     *
     * @param format 指定格式
     * @return
     */
    public static String get(String format) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_number + src_upper;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(esc_char)) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    /**
     * 产生如下格式的随机字符串“Are you W5B?”，可以自己指定临时占位符，这里用“#”；
     *
     * @param format 指定格式
     * @param esc
     * @return
     */
    public static String get(String format, char esc) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_number + src_upper;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(String.valueOf(esc))) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    /**
     * 生成指定长度，由数字组成的随机字符串；
     *
     * @param size 指定长度
     * @return
     */
    public static String getNum(int size) {
        StringBuffer r = new StringBuffer(size);
        String src = src_number;
        for (int i = 0; i < size; i++) {
            r.append(getRandomChar(src));
        }
        return r.toString();
    }

    public static String getNum(String format) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_number;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(esc_char)) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    public static String getNum(String format, char esc) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_number;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(String.valueOf(esc))) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    /**
     * 生成指定长度，由十六进制字符组成的随机字符串；
     *
     * @param size
     * @return
     */
    public static String getHex(int size) {
        StringBuffer r = new StringBuffer(size);
        String src = src_hex_upper;
        for (int i = 0; i < size; i++) {
            r.append(getRandomChar(src));
        }
        return r.toString();
    }

    public static String getHex(String format) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_hex_upper;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(esc_char)) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    public static String getHex(String format, char esc) {
        StringBuffer r = new StringBuffer(format.length());
        String src = src_hex_upper;
        for (int i = 0; i < format.length(); i++) {
            String curr = String.valueOf(format.charAt(i));
            if (curr.equalsIgnoreCase(String.valueOf(esc))) {
                r.append(getRandomChar(src));
            } else {
                r.append(curr);
            }
        }
        return r.toString();
    }

    private static final String getRandomChar(String src) {
        if (null == src || "".equals(src)) {
            return "";
        }
        return String.valueOf((src.charAt((int) (Math.random() * src.length()))));
    }

    public static void main(String[] args) {
        System.out.println(RandomString.get(10));
    }
}