// Java program to print all permutations
// with repetition of characters

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Q3BoardGameNPR
{

    // The main function that recursively prints
    // all repeated permutations of the given string.
    // It uses data[] to store all permutations one by one
    static void allLexicographicRecur(List<List<Integer>> result, List<Integer> str, List<Integer> data,
                                      int last, int index,int n)
    {
        int length = str.toArray().length;

        // One by one fix all characters at the given index
        // and recur for the subsequent indexes
        for (int i = 0; i < length; i++)
        {

            // Fix the ith character at index and if
            // this is not the last index then
            // recursively call for higher indexes
            data.set(index,str.get(i));
            //System.out.println(str.indexOf(i));

            // If this is the last index then print
            // the string stored in data[]
            if (index == last) {
                if(data.stream()
                        .mapToInt(a -> a)
                        .sum()==n)result.add(List.copyOf(data));
                //return data;
                //System.out.println(data);
                //System.out.println(str);
            }else
                allLexicographicRecur(result,str, data, last,
                        index + 1,n);
        }
    }

    // This function sorts input string, allocate memory
    // for data(needed for allLexicographicRecur()) and calls
    // allLexicographicRecur() for printing all permutations
    static void allLexicographic(List<List<Integer>> result,List<Integer> str,int range,int n)
    {
        int length = str.toArray().length;

        // Create a temp array that will be used by
        // allLexicographicRecur()
        //List<Integer> result1 = new ArrayList<Integer>();

        int[] data1 = new int[range];
        List<Integer> data = Arrays.stream(data1).boxed().collect(Collectors.toList());

        // Now print all permutations
        allLexicographicRecur(result,str, data, range-1, 0,n);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n =6;
        int[] str1 = {1,2,3,4,5,6};
        List<Integer> str = Arrays.stream(str1).boxed().collect(Collectors.toList());

        System.out.printf("All permutations with " +
                "repetition of %s are: \n", str);
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int j = 1; j <= i; j++) {
                allLexicographic(result, str, j, i);
            }
            System.out.print(result);
            System.out.print(",Number of way to Move "+i+": ");
            System.out.println(result.toArray().length);
        }
    }
}

// This code is contributed by
// sanjeev2552
