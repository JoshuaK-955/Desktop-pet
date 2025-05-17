package org.example.Controller;

public class Stopwatch {
    private final long startTime;

    // Constructor starts the stopwatch automatically
    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    // Get elapsed time in milliseconds
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    // Get elapsed time in seconds
    public double getElapsedTimeSeconds() {
        return getElapsedTime() / 1000.0;
    }

    // Check if a specific duration in milliseconds has passed
    public boolean hasElapsed(long milliseconds) {
        return getElapsedTime() >= milliseconds;
    }

    // Check if a specific duration in seconds has passed
    public boolean hasElapsedSeconds(double seconds) {
        return getElapsedTimeSeconds() >= seconds;
    }

//    // Example usage
//    public static void main(String[] args) {
//        Stopwatch timer = new Stopwatch();
//
//        // Simulate program running
//        try {
//            Thread.sleep(10000); // Wait 2 seconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Check elapsed time
//        System.out.println("Elapsed: " + timer.getElapsedTimeSeconds() + " seconds");
//
//        // Check if 15 minutes (900 seconds) has passed
//        if (timer.hasElapsedSeconds(10)) {
//            System.out.println("15 minutes have passed!");
//        } else {
//            System.out.println("15 minutes not reached yet.");
//        }
//    }
}