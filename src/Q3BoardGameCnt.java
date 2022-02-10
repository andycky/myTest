import java.util.ArrayList;
import java.util.List;

/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/
class Q3BoardGameCnt

{
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    // Returns number of ways to reach score n
    static int getCombination2(List<Integer> movedResult,int space)
    {
        if(movedResult==null) {
            movedResult = new ArrayList<Integer>();
        }

//        int combination = 0;
//        if (space == 1) {
//            combination = 1;
//        }


        for (int moved = 1; moved <= space; moved++) {
            //System.out.println(moved);
            movedResult.add(moved);

            if(space - moved<=0){
                result.add(List.copyOf(movedResult));
                movedResult.removeAll(movedResult);
            }
//            System.out.println(movedResult);
            combination += getCombination2(movedResult,space - moved);
        }
        if (space >= 2 && space <=6) {
            combination +=1;
        }
  //      System.out.println(result);
        return combination;
    }



    public static void main(String args[])

    {
        for (int n=1; n<=3; n++) {
            result = new ArrayList<List<Integer>>();
            System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getCombination2(null,n));
            System.out.println("Cases="+result);
            System.out.println("count="+result.toArray().length);
        }
        //int n = 610;
        //System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getCombination2(n));
    }

}

