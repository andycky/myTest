import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Program in Java for finding possible ways of arriving exactly at the finishing point as mentioned above*/
class Q3BoardGameCnt

{
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    // Returns number of ways to reach score n

    private static int[] push(int[] array, int push) {
        int[] longer = new int[array.length + 1];
        for (int i = 0; i < array.length; i++)
            longer[i] = array[i];
        longer[array.length] = push;
        return longer;
    }

    static int getCombination2(int[] movedResult,int space)
    {
        //if(movedResult==null) {
        //    movedResult = {1};
        //}

        int combination = 0;
        if (space == 1) {
            combination = 1;
        }


        for (int moved = 1; moved <= space && moved <= 6; moved++) {

            //if(movedResult.toArray().length==0)moved=1;
            //System.out.println(moved+" "+space+" "+Arrays.stream(movedResult).boxed().collect(Collectors.toList()));
            int[] newMovedResult=push(movedResult,moved);

            if(space - moved<=0){
                //int[] newMoveResult = (int[])movedResult.clone();
                List<Integer> movedResultList = Arrays.stream(newMovedResult).boxed().collect(Collectors.toList());
                result.add(movedResultList);
                //movedResult.removeAll(movedResult);
            }
//            System.out.println(movedResult);
            combination += getCombination2(newMovedResult,space - moved);
        }
        if (space >= 2 && space <=6) {
            combination +=1;
        }
  //      System.out.println(result);
        return combination;
    }



    public static void main(String args[])

    {
        for (int n=1; n<=10; n++) {
            result = new ArrayList<List<Integer>>();
            int[] movedResult={};
            //System.out.println("Number of possible ways to exactly move " + n + " spaces=" + getCombination2(movedResult,n));
            getCombination2(movedResult,n);
            System.out.println("Cases="+result);
            //resu
            System.out.println("count="+result.toArray().length);
        }
    }

}

