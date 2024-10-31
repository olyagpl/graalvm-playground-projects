package com.example.stringManipulation;

public class StringManipulation {

    public static void main(String[] args) {
        System.out.println("Starting string manipulation GC stress test...");

        for (int i = 0; i < 100000; i++) {
            String base = "log-entry";
            StringBuilder builder = new StringBuilder(base);

            // Simulate log entry generation with random data
            for (int j = 0; j < 100; j++) {
                builder.append("-").append(System.nanoTime());
            }

            // Create a large temporary string
            String logEntry = builder.toString();

            // Simulate processing that generates temporary strings
            String[] parts = logEntry.split("-");
            logEntry = null; // Release reference

            // Periodically log progress and wait to observe GC
            if (i % 10000 == 0) {
                System.out.println("Processed " + i + " log entries");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("String manipulation GC stress test completed.");
    }
}