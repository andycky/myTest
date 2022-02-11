// Java implementation of the approach

import java.util.concurrent.*;

public class Q1FunctionMt {

    static int n = 8181;
    static long timeout = 500000;
    static int newFixedThreadPool = 10000000;
    static ExecutorService executorService = Executors.newFixedThreadPool(newFixedThreadPool);
    static class CalculationJob implements Callable<Integer> {


        private Thread t;
        private String threadName;
        private int input;
        private int result;

        public CalculationJob(int input) {
            this.input = input;
        }

        // Function to find n positive integers
    // that satisfy the given conditions
        public Integer call() {

            //ExecutorService executorService = Executors.newFixedThreadPool(2);

            int result=0;
            switch (this.input) {
                case 0:
                    result = 0;
                    break;
                case 1:
                    result = 1;
                    break;
                default:
                    System.out.println("Input: " + this.input+", T="+((ThreadPoolExecutor)executorService).getActiveCount());
                    Future<Integer> result1 = executorService.submit(new CalculationJob(this.input-1));
                    Future<Integer> result2 = executorService.submit(new CalculationJob(this.input-2));
                    try {
                        Integer integer1 = result1.get(timeout, TimeUnit.MILLISECONDS);
                        Integer integer2 = result2.get(timeout, TimeUnit.MILLISECONDS);
                        result = integer1+integer2;
                        System.out.println("T result: " + result);
                    } catch (Exception e) {
                        // interrupts if there is any possible error
                        System.out.println("T Cancel");
                        e.printStackTrace();
                        result1.cancel(true);
                        result2.cancel(true);
                    }

            }
            System.out.println("final result="+result);
            return result;
        }

    }

    // Driver code
    public static void main (String[] args) throws InterruptedException {

        //ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result = executorService.submit(new CalculationJob(n));

        long start = System.nanoTime();
        try {
            Integer integer = result.get(timeout, TimeUnit.MILLISECONDS);
            System.out.println("result: " + integer);
        } catch (Exception e) {
            // interrupts if there is any possible error
            result.cancel(true);
        }

        long elapsedTime = System.nanoTime() - start;
        System.out.println("Time="+elapsedTime/1000000);


        executorService.shutdown();
        executorService.awaitTermination(timeout, TimeUnit.SECONDS);

        //int n = 8181;
        //int result = functionn(n);
        //System.out.println("final result="+result);
    }

}
