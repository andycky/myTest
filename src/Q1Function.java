// Java implementation of the approach
import java.util.*;

class Q1Function
{

    // Function to find n positive integers
// that satisfy the given conditions
    static int functionn(int n)
    {
        int result;
        switch(n) {
            case 0:
                result = 0;
                break;
            case 1:
                result = 1;
                break;
            default:
                result = functionn(n-1) + functionn(n-2);
        }
            //System.out.println("result="+result);
        return result;
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 8181;
        int result = functionn(n);
        System.out.println("final result="+result);
    }
}
