package com.deepak.leetCode.strings;

public class LicenceKeyFormatting {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println();
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder(s.replace("-", "").toUpperCase());
        int i = sb.length() - k;
        while(i  > 0){
            sb.insert(i, "-");
            i -= k;
        }
        return sb.toString();
    }
}
