package com.company;

import java.math.BigInteger;
import java.util.stream.Stream;

public class WorkerThread implements Runnable {
    private Stream<BigInteger> data;

    public WorkerThread(int offset) {
        var start = offset == 0 ? BigInteger.TWO : BigInteger.valueOf(mathPowLong(offset));
        //use a stream to save memory and increase processing speed
        this.data = Stream.iterate(start, n -> n.add(BigInteger.ONE))
                .limit(mathPowLong(2)- 1)
                .filter(this::isPrime);
    }

    private long mathPowLong(int input) {
        return (long) Math.pow(10,7) * input;
    }

    //check if the number is prime
    private boolean isPrime(BigInteger n) {
        return n.isProbablePrime(10);
    }

    @Override
    public void run() {
        data.forEach((number) -> System.out.println(Thread.currentThread().getName() + " found a prime number: " + number));
    }
}
