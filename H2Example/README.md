## Java Application Using an In-Memory Database

This Java application uses the H2 Database, an open source SQL database for Java. 
The application interacts with this database through the JDBC driver.

The demo shows how to build a native executable pulling the configuration from the [GraalVM Reachability Metadata Repository](https://github.com/oracle/graalvm-reachability-metadata). The goal is to illustrate how the use of reachability metadata can simplify your development tasks.

## Install GraalVM 

The easiest way to get started is with [SDKMAN!](https://sdkman.io/jdks/#graal):
```bash
sdk install java 23.0.1-graal
```
For other download options, see [GraalVM Downloads](https://www.graalvm.org/downloads/).

## Build on a JVM and Run (Optional)

Package and run with Maven on a JVM:
```bash
./mvnw clean package
```
```bash
./mvnw exec:java
```

## Build a Native Image and Run

Compile and build a native image with Maven: 
```bash
./mvnw package -Pnative
```
Run the application from the native image:
```bash
./target/h2example
```
The application returns a list of customers stored in the H2 Database.