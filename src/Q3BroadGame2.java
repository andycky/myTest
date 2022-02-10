/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/

import java.util.Scanner;

class Q3BroadGame2

{

    public static int fact(int num)

    {

        int i,m,fact=1;

        int number;

        System.out.println("Enter n:");

        Scanner sm= new Scanner(System.in);

        number= sm.nextInt();

        for(i=1;i<=number;i++)

        {

            fact=fact*i;

        }

        return fact;

    }

    public static void main(String args[])

    {

        int m;

        System.out.println("Enter the number of times dice is rolled:");

        Scanner sn = new Scanner(System.in);

        m= sn.nextInt();

        int numofpossibleways= 126*fact(m)/fact(m-6);

        System.out.print("Number of possible ways:"+ numofpossibleways);

    }

}