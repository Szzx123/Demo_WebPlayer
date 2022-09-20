package org.WebPlayer.util;

public class Bv {
    public static String get(int i) {
        // i 只要不超过 1491126880, 长度就固定为 6
        return "bv" + Base58.encode((Integer.MAX_VALUE) ^ i);
    }

    private static class Base58 {
        // "123456789ABCDEFGH JKLMN PQRSTUVWXYZabcdefghijk mnopqrstuvwxyz"
        static String chars = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
        // b站 fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF

        public static String encode(int i) {
            StringBuilder sb = new StringBuilder(16);
            if (i == 0) {
                return String.valueOf(chars.charAt(0));
            }
            while (i > 0) {
                sb.append(chars.charAt(i % 58));
                i = i / 58;
            }
            return sb.reverse().toString();
        }

        public static int decode(String str) {
            StringBuilder reverse = new StringBuilder(str).reverse();
            int r = 0;
            for (int i = 0; i < str.length(); i++) {
                int n = chars.indexOf(reverse.charAt(i));
                r += n * (int) Math.pow(58, i);
            }
            return r;
        }
    }

    public static void main(String[] args) {
        String s = Bv.get(10);
        System.out.println(s);
    }
}
