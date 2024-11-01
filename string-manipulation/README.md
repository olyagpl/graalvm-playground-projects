# String Manipulation GC Stress Test

When running a native image, Java heap settings are determined based on the system configuration and the garbage collection (GC) policy.
You can override this default mechanism by setting a maximum heap size for more predictable memory usage.

The guide demonstrates how to manipulate with the run-time memory usage to reduce the application footprint.
For the demo part, you will use a Java application that generates a significant number of temporary strings putting pressure on the young generation in the heap.

A Java application that does some heavy text processing, like log analysis, where large strings are frequently concatenated, split, or manipulated, is a good approach to stress test the garbage collector.

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
    > Run with `-Xms256m -Xmx256m` and GC logging to observe temporary object cleanup.

## Build a Native Image and Run

1. Compile and build a native executable with Maven: 
    ```bash
    ./mvnw -Pnative package
    ```
   > Enable G1 GC with Native Image by passing this option `--gc=G1` at build time (available with Oracle GraalVM and for Linux only).

2. Query the capital for a specific country:
    ```bash
    ./target/string-manipulatio
    ```

Monitoring this application with logging and memory profiling tools like VisualVM or Java Flight Recorder will give insights into GC efficiency under varied workloads.