package CompilerLabOffline;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Question1 {


    static HashSet<Character> OPERATORS=new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        BufferedReader br;
        br=createFile(sc);


        createOperatorSet(OPERATORS);
        ArrayList<String> list;
        list=getArrayOfStrings(br);
        System.out.println("The input file contains");
        for(String s : list){
            System.out.println(s);
        }

        findTokens(list);
        sc.close();
    }

    private static void createOperatorSet(HashSet<Character> operators) {
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');
        operators.add('!');
        operators.add('&');
        operators.add('>');
        operators.add('<');
    }

    private static void findTokens(ArrayList<String> list) {

        findKeywords(list);
        findOperators(list);

    }

    private static void findOperators(ArrayList<String> list) {

        HashSet<Character> operators=new HashSet<>();
        for(String s : list){
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(OPERATORS.contains(ch))
                    operators.add(ch);
            }
        }


        System.out.println("The Java operators in the program are");
        System.out.println(operators);
    }


    private static void findKeywords(ArrayList<String> list) {

        Set<String> keywords=getJavaKeyWords(list);
        System.out.println("Set of Java Keywords in the particular file are");
        System.out.println(keywords);

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

    private static ArrayList<String> getArrayOfStrings(BufferedReader br) throws IOException {
        ArrayList<String> listOfString=new ArrayList<>();
        String line;
        while((line=br.readLine()) != null){
            listOfString.add(line.trim());
        }

        return listOfString;
    }
}
