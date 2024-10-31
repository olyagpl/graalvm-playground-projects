# String Manipulation GC Stress Test

This demo simulates applications with heavy text processing, like log analysis, where large strings are frequently concatenated, split, or manipulated, generating many temporary objects that need to be garbage collected.

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
    ./target/string-manipulatio
    ```