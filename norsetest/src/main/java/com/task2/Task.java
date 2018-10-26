package com.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Task {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new RuntimeException();
        }
        String page = downloadPage(args[0]);
        System.out.println(page);
        String shortest = getShortest(page, args[1], args[2]);
        page = page.replaceAll(shortest, mark(shortest));
        System.out.println(page);
    }

    private static String getShortest(String page, String arg1, String arg2) {
        String[] strings = page.split(" ");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strings));
        int length = page.length();
        String string = null;
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            String removed = queue.remove();
            //if (Objects.equals(removed, arg1)  Objects.equals(removed, arg2))
            stringBuilder.append(removed);
            String s = stringBuilder.toString();
            if (((s.startsWith(arg1) && s.endsWith(arg2)) || (s.startsWith(arg2) && s.endsWith(arg1))) && length > s.length()) {
                string = s;
            }
        }
        return string;
        /*for (int i = 0; i < strings.length; i++) {
            if (Objects.equals(strings[i], arg1) || Objects.equals(strings[i], arg2)) {
                continue;
            }

        }
        int index1 = page.indexOf(arg1);
        int index2 = page.indexOf(arg2);
        int size;
        if (index1 < index2) {
            size = index2 + arg2.length() - index1;
        } else {
            size = index1 + arg1.length() - index2;
        }*/
    }

    private static String[] getCombinations(String[] args) {
        return new String[]{};
    }

    private static String mark(String text) {
        return "<mark>" + text + "</mark>";
    }

    private static String[] findCombinations(String page, String[] args) {
        //String[] regexes = new String[args.length * args.length];
        String[] regexes = new String[2];
        regexes[0] = "^" + args[1] + ".*" + args[2];
        regexes[1] = "^" + args[2] + ".*" + args[1];
        return regexes;
    }

    private static String downloadPage(String urlAddress) {
        URL url = null;
        try {
            url = new URL(urlAddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
