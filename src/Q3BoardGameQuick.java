/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

class Q3BoardGameQuick {

    static BigInteger getPossibleWay(BigInteger[] possibleWayCount, int space)
    {
        BigInteger possibleWay = BigInteger.valueOf(0);
        for (int dice = 1; dice <= space && dice <= 6; dice++) {
            int remainingSpace = space - dice;
            BigInteger possibleMoveOfRemainingSpace;
            if (possibleWayCount[remainingSpace] != null && possibleWayCount[remainingSpace].signum() == 1) {
                possibleMoveOfRemainingSpace = possibleWayCount[remainingSpace];
            } else {
                possibleMoveOfRemainingSpace = getPossibleWay(possibleWayCount, remainingSpace);
            }
            possibleWay = possibleWay.add(possibleMoveOfRemainingSpace);
        }

        if (space >= 1 && space <=6) {
            possibleWay = possibleWay.add(BigInteger.valueOf(1));
        }
        possibleWayCount[space] = possibleWay;
        return possibleWay;
    }



    public static void main(String args[])
    {
        int spaceToMove = 610;
        BigInteger[] possibleMoveCount = new BigInteger[spaceToMove+1];
        for (int n=1; n<=spaceToMove; n++) {
            System.out.println("Number of possible ways (2) to exactly move " + n + " spaces=" + getPossibleWay(possibleMoveCount, n));
            System.out.println("possibleMoveCount[]: " + Arrays.toString(possibleMoveCount));
        }
    }


}