// Java implementation of the approach

class Q1Function2
{
    static int n = 8181;

    // Function to find n positive integers
// that satisfy the given conditions
    static int functionn(int n)
    {
        //System.out.print("input="+n+", ");
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
        long start = System.nanoTime();
        int result = functionn(n);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("final result="+result+", Time="+elapsedTime/1000000);
    }
}
