package Lab4;

import java.util.Scanner;

public class BottomUpParser {
    static String[] RULES;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rules: ");
        int n = sc.nextInt();
        RULES = new String[n];

        System.out.println("Enter the rules");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("E -> ");
            RULES[i] = sc.nextLine();
        }
        System.out.println();

        System.out.println("Enter input string: ");

        StringBuilder input = new StringBuilder(sc.nextLine());
        input.append("$");

        StringBuilder stack = new StringBuilder("$");
        System.out.println("Stack\t\t\tInput\t\t\t\tAction");
        while (!(input.length() ==0)) {
            System.out.print(stack + "\t\t\t" + input + "\t\t\t");
            if (input.toString().equals("$")) {
                if (reduce(stack)) {
                    System.out.print("\n\n The input String is -> " + (stack.toString().equals("$E") ? "Accepted" : "Rejected"));
                    break;
                }
                System.out.println();
                continue;
            }
            if (reduce(stack)) shift(stack, input);
            System.out.println();
        }
    }


    static void shift(StringBuilder stack, StringBuilder input) {
        stack.append(input.toString().charAt(0));
        input.deleteCharAt(0);
        System.out.print("\tSHIFT");
    }


    private static boolean reduce(StringBuilder stack) {

        for (String rule : RULES) {
            if (stack.toString().contains(rule)) {
                String reducedString = stack.toString().replace(rule, "E");
                stack.delete(0, stack.length());
                stack.append(reducedString);
                System.out.print("\tREDUCE E -> " + rule);
                return false;
            }
        }

        return true;
    }
}
