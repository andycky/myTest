/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/
class Q3BoardGame610

{
    // Returns number of ways to reach score n
    static int getCombination2(int space)
    {
        int combination = 0;
        if (space == 1) {
            combination = 1;
        }

        for (int moved = 1; moved < space; moved++) {
            combination += getCombination2(space - moved);
        }
        if (space >= 2 && space <=6) {
            combination +=1;
        }
        return combination;
    }

    public static void main(String args[])

    {
//        for (int n=1; n<=8; n++) {
//            System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getCombination2(n));
//        }
        int n = 610;
        System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getCombination2(n));
    }

}

