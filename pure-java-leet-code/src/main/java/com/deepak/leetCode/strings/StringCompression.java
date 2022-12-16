package com.deepak.leetCode.strings;

public class StringCompression {

    public int compress(char[] chars) {

        if(chars.length == 0)
            return  0;

        if(chars.length == 1)
            return 1;

        int count = 1;
        char curr = chars[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curr) {
                count++;
            } else {
                sb.append(curr);
                if (count > 1)
                    sb.append(count);

                curr = chars[i];
                count = 1;
            }
            if(i == chars.length -1 ){
                sb.append(curr);
                if (count > 1)
                    sb.append(count);

            }
        }



        for (int i = 0; i < chars.length; i++) {
            if(i < sb.length())
            chars[i] = sb.charAt(i);
            else
                break;
        }

        return sb.length();
    }
}
