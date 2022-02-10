/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

class Q3BroadGame

{

    // Returns number of ways to reach score n
    static int getCombinaison(int n)
    {
        int[] table = new int[n+1];
        // table[i] will store count of solutions for
        // Base case (If given value is 0)
        table[0] = 1;

        // One by one consider given 3 moves and update the table[]
        // values after the index greater than or equal to the
        // value of the picked move

        ArrayList<Integer> m = new ArrayList<Integer>();

        for (int j=1; j<=6; j++) {
           for (int i=1; i<=n; i++)
//                table[i] += table[i-j];
               m.add(Integer.valueOf(j));
        }
        System.out.println(m);
//        for (int j=1; j<=6; j++) {
//            for (int i = j; i <= n; i++)
//                table[i] += table[i - j];
//        }
        return table[n];
    }

    static int sum(){
        ArrayList<Integer> m = new ArrayList<Integer>();
        m.add(Integer.valueOf(1));
        m.add(Integer.valueOf(2));
        m.add(Integer.valueOf(3));
        return m.stream()
                .mapToInt(a -> a)
                .sum();
    }

    public static void main(String args[])

    {
        System.out.println(sum());

        int n=4;
        System.out.println("Number of possible ways to exactly move "+n+" spaces="+getCombinaison(n));
    }

}