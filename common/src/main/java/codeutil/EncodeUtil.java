package codeutil;

public class EncodeUtil {
    public static String unicode2String(String unicode) {
        StringBuilder sb = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            sb.append((char) data);
        }
        return sb.toString();
    }

    public static String string2Unicode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append("\\u" + Integer.toHexString(c));
        }
        return sb.toString();
    }
}
