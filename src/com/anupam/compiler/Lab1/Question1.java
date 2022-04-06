package com.anupam.compiler.Lab1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Question1 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        BufferedReader br;
        br=createFile(sc);


        ArrayList<String> list;
        list=getArraysOfString(br);


        int digits=getNumberOfDigits(list);
        int whiteSpaces=getNumberOfWhiteSpaces(list);
        int words=getNumberOfWords(list);
        Set<String> keywords=getJavaKeyWords(list);
        int assignedVariables=getAssignedVariables(list);


        System.out.println("Number of words = "+words);
        System.out.println("Number of whitespace = "+whiteSpaces);
        System.out.println("Number of digits = "+digits);
        System.out.println("Number of keywords in string is " + keywords.size());

    }

    private static int getAssignedVariables(ArrayList<String> list) {

        return 0;
    }

    private static Set<String> getJavaKeyWords(ArrayList<String> list) {
        Set<String> keywords = new HashSet<>();
        for (String line : list) {
            for (String word : line.split(" ")) {
                if (JAVA_KEY_WORDS.contains(word)) {
                    keywords.add(word);
                }
            }
        }
        return keywords;
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


    private static int getNumberOfWhiteSpaces(ArrayList<String> list) {
        int whiteSpaces=0;
        for(String st : list){
            char[] chars=st.toCharArray();
            for(char ch : chars){
                if(ch==' ')
                    whiteSpaces++;
            }
        }
        return whiteSpaces;

    }

    private static int getNumberOfDigits(ArrayList<String> list) {
        int digits=0;
        for(String st : list){
            char[] chars=st.toCharArray();
            for(char ch : chars){
                if(ch>='0' && ch<='9')
                    digits++;
            }
        }
        return digits;
    }

    private static int getNumberOfWords(ArrayList<String> list) {
        int words=0;
        for(String st : list){
            words+=st.split(" ").length;
        }

        return words;
    }

    private static BufferedReader createFile(Scanner sc) throws IOException {

        System.out.println("Enter the file location ");
        String path=sc.next();

        File file=new File(path);
        if(!file.exists()){
            if(file.createNewFile())
                System.out.println("File created successfully");
        }

        return new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    }

    private static ArrayList<String> getArraysOfString(BufferedReader br) throws IOException {
        ArrayList<String> listOfString=new ArrayList<>();
        String line;
        while((line=br.readLine()) != null){
            listOfString.add(line);
        }

        return listOfString;
    }
}
