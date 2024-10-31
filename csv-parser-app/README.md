# CSV Parser Java Application

This example application parses a CSV file at run time using the Apache Commons CSV library. This library provides efficient streaming of CSV data, especially for large files.
The application streams the data from the file, processing the content without loading the entire file into memory.

The CSV file contains the list of all countires in the world and their capitals.
The `CsvParser` class to handles both arguments (file path and country name) and search the CSV for the specified country.

## Install GraalVM 

The easiest way to get started is with [SDKMAN!](https://sdkman.io/jdks/#graal):
```bash
sdk install java 23.0.1-graal
```
For other download options, see [GraalVM Downloads](https://www.graalvm.org/downloads/).

## Build on a JVM and Run (Optional)

1. Compile and package with Maven:
    ```bash
    ./mvnw clean package
    ```

2. Query the capital for a specific country:
    ```bash
    ./mvnw exec:java -Dexec.args="countries_and_capitals.csv Canada"
    ```

## Build a Native Image and Run

1. Compile and build a native executable with Maven: 
    ```bash
    ./mvnw -Pnative package
    ```
2. Query the capital for a specific country, run:
    ```bash
    ./target/csv-parser countries_and_capitals.csv Canada
    ```
