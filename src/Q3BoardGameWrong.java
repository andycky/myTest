/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/

import java.io.*;

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
//        for (int j=1; j<=6; j++) {
 //           for (int i=j; i<=n; i++)
//                table[i] += table[i-j];
//        }
        for (int i = 1; i <= n; i++)
            table[i] += table[i - 1];
        for (int i = 2; i <= n; i++)
            table[i] += table[i - 2];
        for (int i = 3; i <= n; i++)
            table[i] += table[i - 3];
        for (int i = 4; i <= n; i++)
            table[i] += table[i - 4];
        for (int i = 5; i <= n; i++)
            table[i] += table[i - 5];
        for (int i = 6; i <= n; i++)
            table[i] += table[i - 6];
        return table[n];
    }

    public static void main(String args[])

    {
        int n=8;
        System.out.println("Number of possible ways to exactly move "+n+" spaces="+getCombinaison(n));
    }

}