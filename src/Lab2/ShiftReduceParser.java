package Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
  This program contains shift reduce parsers
 */


/*
* Considering the CFG below
* E -> 2E2
* E -> 3E3
* E -> 4
* */


public class ShiftReduceParser {
    public static void main(String[] args) throws IOException {
        int no, loc=0, i, j;
        String str;
        StringBuilder stack= new StringBuilder();
        String temp;
        String[][] productions;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no. of productions: ");
        no = Integer.parseInt(in.readLine());
        productions = new String[no][2];
        System.out.println("Enter the productions:");
        for (i=0; i < no; i++)
        {
            System.out.print("LHS for production "+(i+1)+": ");
            productions[i][0] = in.readLine();
            System.out.print("RHS for production "+(i+1)+": ");
            productions[i][1] = in.readLine();
        }
        System.out.println("The productions are:");
        for (i=0; i < no; i++)
        {
            System.out.println(productions[i][0]+" -> "+productions[i][1]);
        }
        System.out.print("Enter a string: ");
        str = in.readLine();
        while (loc < str.length())
        {
            temp = str.substring(loc, str.indexOf(' ',loc));
            loc = str.indexOf(' ', loc)+1;
            System.out.println(temp+" "+loc);
            for (i=0; i < no; i++)
            {
                if (stack.toString().contains(productions[i][1]))
                {
                    temp = productions[i][0];
                }
            }
            stack.append(temp);
            for (i=0; i < no; i++)
            {
                if (stack.toString().equals(productions[i][1]))
                {
                    stack = new StringBuilder(productions[i][0]);
                    break;
                }
            }
        }
        System.out.println("Stack contents: "+stack);
        if (stack.toString().equals(productions[0][0]))
            System.out.println("Accepted.");
        else
            System.out.println("Rejected.");
    }
}
