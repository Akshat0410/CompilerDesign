package com.anupam.compiler.Lab3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Question {

    static HashSet<Character> match = new HashSet<>(Arrays.asList('+', '-', '*', '/', '&', '!', '%', '^', '|', '<', '>'));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedReader br;
        br = createFile(sc);

        ArrayList<String> list;
        list = getArraysOfString(br);

        System.out.println("***********File before removed whitespaces*************\n");
        for (String line : list) {
            System.out.println(line);
        }

        ArrayList<String> removed = removeWhiteSpaces(list);

        System.out.println("**********File after removed whitespaces************");
        for (String r : removed) {
            System.out.println(r);
        }

        findTokens(list);
    }

    private static void findTokens(ArrayList<String> list) {
        getJavaKeyWords(list);
        getJavaOperators(list);
        countIdentifiers(list);
    }

    private static void getJavaOperators(ArrayList<String> list) {

        HashSet<Character> operators = new HashSet<>();
        for (String st : list) {
            for (char c : st.toCharArray()) {
                if (match.contains(c))
                    operators.add(c);
            }
        }

        System.out.println("\n*******Operators*********");
        System.out.println(operators);
        System.out.println("\n");
    }

    private static ArrayList<String> removeWhiteSpaces(ArrayList<String> list) {
        ArrayList<String> ans = new ArrayList<>();

        for (String st : list) {
            st = st.replace(" ", "");
            ans.add(st);
        }
        return ans;
    }


    private static BufferedReader createFile(Scanner sc) throws IOException {

        System.out.println("Enter the file location ");
        String path = sc.next();

        File file = new File(path);
        if (!file.exists()) {
            if (file.createNewFile())
                System.out.println("File created successfully");
        }

        return new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    }

    private static ArrayList<String> getArraysOfString(BufferedReader br) throws IOException {
        ArrayList<String> listOfString = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            listOfString.add(line);
        }

        return listOfString;
    }

    private static void getJavaKeyWords(ArrayList<String> list) {
        Set<String> keywords = new HashSet<>();
        for (String line : list) {
            for (String word : line.split(" ")) {
                if (JAVA_KEY_WORDS.contains(word)) {
                    keywords.add(word);
                }
            }
        }

        System.out.println("\n\n*******Keywords*********");
        System.out.println(keywords);
    }

    public static void countIdentifiers(ArrayList<String> list) {
        Set<String> keywords = Arrays.stream(new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"}).collect(Collectors.toSet());
        int count = 0;
        for (String word : list) {
            if (!keywords.contains(word)) {
                count++;
            }
        }
        System.out.println("Number of identifiers is -> "+count);
    }

    private static final Set<String> JAVA_KEY_WORDS = Arrays.stream(
            new String[]{"abstract", "assert", "boolean",
                    "break", "byte", "case", "catch", "char", "class", "const",
                    "continue", "default", "do", "double", "else", "extends", "false",
                    "final", "finally", "float", "for", "goto", "if", "implements",
                    "import", "instanceof", "int", "interface", "long", "native",
                    "new", "null", "package", "private", "protected", "public",
                    "return", "short", "static", "strictfp", "super", "switch",
                    "synchronized", "this", "throw", "throws", "transient", "true",
                    "try", "void", "volatile", "while"}
    ).collect(Collectors.toSet());


}
