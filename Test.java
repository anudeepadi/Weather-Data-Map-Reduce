package com.company;

public class Test {
    public static void main(String[] args) {
        String s = "2006-08-15 21:00:00.000 +0200";
        String[] words = s.split(" ");
        String[] date = words[0].split("-");
        String year = date[0];
        String month = date[1];

        System.out.println(year + "/" + month);
    }
}
