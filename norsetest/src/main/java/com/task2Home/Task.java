package com.task2Home;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
        writeHTMLFile(page);
    }

    private static void writeHTMLFile(String page) {
        try (PrintWriter printWriter = new PrintWriter("result.html")) {
            printWriter.append(page);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getShortest(String page, String arg1, String arg2) {
        String string1 = getShortestSubstring(page, arg1, arg2);
        String string2 = getShortestSubstring(page, arg2, arg1);
        return string1.length() < string2.length() ? string1 : string2;
        /*for (int i = 0; i < page.length(); i++) {
            if (page.startsWith(arg2, i)) {
                int indexOf = page.indexOf(arg1, i);
                if (indexOf < 0) {
                    continue;
                }
                String preResult = page.substring(i, indexOf + arg1.length());
                if (preResult.length() < length) {
                    result = preResult;
                    length = result.length();
                }
            }
        }*/
        /*for (int i = 0; i < page.length(); i++) {
            if (page.startsWith(arg2, i)) {
                int indexOf2 = page.indexOf(arg1, i);
                String preResult = page.substring(i, indexOf2 + arg1.length());
                if (preResult.length() < length) {
                    result = preResult;
                    length = result.length();
                }
            }
        }*/
        /*page = page.replaceAll("[-+.^:,!?();]", "");
        Queue<String> queue = new LinkedList<>(Arrays.asList(page.split(" ")));
        //StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(" ");
        String preResult = "";
        String result = "";
        int length = page.length();
        while (!queue.isEmpty()) {
            String removed = queue.remove();
            if (preResult.isEmpty() && !Objects.equals(removed, arg1) && !Objects.equals(removed, arg1)) {
                continue;
            }
            if (preResult.startsWith(removed)) {
                stringJoiner = new StringJoiner(" ");
            }
            //preResult = preResult.concat(removed).concat(" ");
            stringJoiner.add(removed);
            preResult = stringJoiner.toString();
            if ((preResult.startsWith(arg1) && preResult.endsWith(arg2))
                    || (preResult.startsWith(arg2) && preResult.endsWith(arg1))) {
                if (preResult.length() < length) {
                    result = preResult;
                    length = result.length();
                } else {
                    preResult = "";
                }
            }
        }
        return result.trim();*/
    }

    private static String getShortestSubstring(String page, String arg1, String arg2) {
        int length = page.length();
        String result = null;
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex < page.length()) {
            startIndex = page.indexOf(arg1, startIndex);
            if (startIndex < 0) {
                return result;
            }
            endIndex = page.indexOf(arg2, startIndex) + arg2.length();
            if (endIndex < 0) {
                return result;
            }
            if (startIndex + endIndex < length) {
                result = page.substring(startIndex, endIndex);
                length = result.length();
            }
            startIndex++;
        }
        return result;
    }

    private static String mark(String text) {
        return "<mark>" + text + "</mark>";
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
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
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
