/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/
import java.util.ArrayList;
class Q3BoardGame {

    static long getPossibleWay(int space)
    {
        long possibleWay = 0;
        for (int dice = 1; dice <= space && dice <= 6; dice++) {
            int remainingSpace = space - dice;
            long possibleMoveOfRemainingSpace = getPossibleWay(remainingSpace);
            possibleWay += possibleMoveOfRemainingSpace;
        }

        if (space >= 1 && space <=6) {
            possibleWay += 1;
        }
        return possibleWay;
    }



    public static void main(String args[])
    {
        for (int n=1; n<=8; n++) {
            ArrayList<Integer> possibleMove = new ArrayList<Integer>();
            System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getPossibleWay(n));
        }
    }

}