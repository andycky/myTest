// Java implementation of the approach

import java.math.BigInteger;
import java.util.HashMap;

class Q1FunctionQuick
{
    static HashMap<BigInteger,BigInteger> cache = new HashMap<BigInteger,BigInteger>();
    // Function to find n positive integers
// that satisfy the given conditions
    static BigInteger functionn(BigInteger n)
    {
        BigInteger result;

        if (cache.containsKey(n)){
            result =  cache.get(n);
        }else {

            if (n.equals(BigInteger.ZERO)) {
                result = BigInteger.ZERO;
            }else if (n.equals(BigInteger.ONE)) {
                result = BigInteger.ONE;
            }else{
                result = functionn(n.add(BigInteger.valueOf(-1))).add( functionn(n.add(BigInteger.valueOf(-2))));
            }
        }

        cache.put(n, result);
        //System.out.println("result="+result);
        return result;
    }

    // Driver code
    public static void main (String[] args)
    {
        BigInteger n = BigInteger.valueOf(15);
        System.out.println("Q1: for n="+n);
        BigInteger result = functionn(n);
        //System.out.println("cache="+cache);
        System.out.println("final result="+result);
        System.out.println("final result="+BigInteger.valueOf(-1));
    }
}
