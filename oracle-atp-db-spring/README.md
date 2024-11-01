# Connect a Spring Boot Application to an Oracle Autonomous Database

This example demonstrates how to connect a Spring Boot application an Oracle Autonomous Database (Autonomous Transaction Processing database service).
The application uses the JDBC driver for the database access and Oracle Wallet to securely store the credentials.

## 1. Install GraalVM 

The easiest way to get started is with [SDKMAN!](https://sdkman.io/jdks/#graal):
```bash
sdk install java 23.0.1-graal
```
For other download options, see [GraalVM Downloads](https://www.graalvm.org/downloads/).

## 2. Create an Oracle Autonomous Database and Save Your Database Connection Details

1. Create an Autonomous Database instance in the Oracle Cloud console and get your database connection details.

2. Create a user to access the database in the SQL worksheet.

[This blog post by Anders Swanson](https://medium.com/@anders.swanson.93/oracle-autonomous-database-with-spring-boot-1e71cdd8b59e) describes step by step how to achieve that.

## 3. Export Connection Details via Environment Variables

Export database and wallet connection infromation via environment variables on the command line, one by one:

```bash
export TNS_NAME=<TNS Name for your database>
export WALLET_DIR=<full path to a directory where our database wallet was unzipped>
export DATABASE_USERNAME=<database username created in SQL worksheet>
export DATABASE_PASSWORD=<database password created in SQL worksheet>
```

## 4. Configure Your Application Properties  

Copy and paste the following to the _/src/main/resources/application.yaml_ file:
```yml
spring:
  datasource:
    url: jdbc:oracle:thin:@${TNS_NAME}?TNS_ADMIN=${WALLET_DIR}
    username: ${DATABASE_USERNAME}
    password: ${DATABASE_PASSWORD}
    driver-class-name: oracle.jdbc.OracleDriver
    type: oracle.ucp.jdbc.PoolDataSourceImpl
    oracleucp:
      connection-factory-class-name: oracle.jdbc.pool.OracleDataSource
      connection-pool-name: ADBExample
      initial-pool-size: 5
      min-pool-size: 1
      max-pool-size: 30
      shared: true
```

Alternatively, you can use the properties file, _/src/main/resources/application.properties_:
```
spring.datasource.url=jdbc:oracle:thin:@${TNS_NAME}?TNS_ADMIN=${WALLET_DIR}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.type=oracle.ucp.jdbc.PoolDataSourceImpl
spring.datasource.oracleucp.connection-factory-class-name=oracle.jdbc.pool.OracleDataSource
spring.datasource.oracleucp.connection-pool-name=ADBExample
spring.datasource.oracleucp.initial-pool-size=5
spring.datasource.oracleucp.min-pool-size=1
spring.datasource.oracleucp.max-pool-size=30
spring.datasource.oracleucp.shared=true
```

## 5. Build on a JVM and Run

Build and package the application with Maven:
```bash
./mvnw clean package
```

Run this Spring Boot application. If everything is configured correctly, it should connect to your Oracle Autonomous Database.

## 6. Build a Native Image and Run

1. Compile and build a native executable with Maven: 
    ```bash
    ./mvnw -Pnative native:compile
    ```
2. Run the application from a native executable: 
    ```bash
    ./target/oci
    ```

Notice how the time to initialize the same database Spring Boot application dropped when deployed from a native image!