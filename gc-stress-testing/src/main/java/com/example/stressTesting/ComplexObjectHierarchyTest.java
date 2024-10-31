package com.example.stressTesting;

import java.util.ArrayList;
import java.util.List;

public class ComplexObjectHierarchyTest {

    static class Request {
        List<String> parameters = new ArrayList<>();
        Response response = new Response();
    }

    static class Response {
        List<String> headers = new ArrayList<>();
        byte[] payload = new byte[1024]; // Simulate response body
    }

    public static void main(String[] args) {
        System.out.println("Starting complex object hierarchy GC stress test...");

        for (int i = 0; i < 100000; i++) {
            // Simulate request processing
            Request request = new Request();
            for (int j = 0; j < 10; j++) {
                request.parameters.add("param" + j);
                request.response.headers.add("header" + j);
            }

            // Release the reference immediately after processing
            request = null;

            // Monitor progress
            if (i % 10000 == 0) {
                System.out.println("Processed " + i + " requests");
            }
        }

        System.out.println("Complex object hierarchy GC stress test completed.");
    }
}