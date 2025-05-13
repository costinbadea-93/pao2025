package threads;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        Runnable runnable = () -> {
//            //logica de rulare
//        }

        Task task = new Task();
        MyThread myThread1 = new MyThread(task);
        MyThread myThread2 = new MyThread(task);

//        myThread1.start();
//        try {
//            myThread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        myThread2.start();

        //ExecutorService
        //ForkJoin
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.submit(myThread1);

        int arr[] = new int[1000000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
//        System.out.println(Arrays.toString(arr));

        //solution without threads processing
        int sum = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("Duration = " + (endTime - startTime) + " ms");

        //solution with threads processing
        int nrOfThreds = 3;
        SumThread[] sumThreads = new SumThread[nrOfThreds];
        int chunkSize = arr.length / nrOfThreds;
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < nrOfThreds; i++) {
            int start = i * chunkSize;
            int end = (i == nrOfThreds - 1) ? arr.length : start + chunkSize;
//            System.out.println("start " + start + " end " + end);
            sumThreads[i] = new SumThread(arr, start, end);
            sumThreads[i].start();
        }

        long totalParallel = 0;
        for (SumThread t : sumThreads) {
            t.join();
            totalParallel += t.getPartialSum();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Parallel sum: " + totalParallel + " in " + (endTime1 - startTime1) + " ms");

    }
}

class SumThread extends Thread {
    private int[] array;
    private int start, end;
    private long partialSum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}
