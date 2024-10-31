# Complex Object Hierarchies GC Stress Test

For applications like web servers or microservices, where each request creates a graph of objects (for example, request, response, DTOs), this application simulates handling complex object hierarchies that are frequently created and discarded.

## Install GraalVM 

The easiest way to get started is with [SDKMAN!](https://sdkman.io/jdks/#graal):
```bash
sdk install java 23.0.1-graal
```
For other download options, see [GraalVM Downloads](https://www.graalvm.org/downloads/).

## Build on a JVM and Run

1. Compile and package with Maven:
    ```bash
    ./mvnw clean package
    ```
2. Query the capital for a specific country:
    ```bash
    ./mvnw compile exec:java
    ```

## Build a Native Image and Run

1. Compile and build a native executable with Maven: 
    ```bash
    ./mvnw -Pnative package
    ```
2. Query the capital for a specific country:
    ```bash
    ./target/gc-stress-testing
    ```