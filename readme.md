# JUnit 5 experiments

Some simple code to experiment with Junit 5.

## Junit 5 can support JUnit 4

Rather than mix Junit 4 and JUnit 5

I added the JUnit 5 backwards compatibility dependency.

So the following give JUnit 5 and JUnit 4 direct backwards compatibility:

~~~~~~~~
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>${junit.jupiter.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>${junit.jupiter.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <version>${junit.jupiter.version}</version>
        <scope>test</scope>
    </dependency>
~~~~~~~~

The `pom.xml`

Should run both JUnit 4 and Junit 5 on `mvn clean test`

And generate an HTML report covering both with `mvn clean test site`

## Differences between Junit 4 and JUnit 5

There are many differences between JUnit 4 and 5, in terms of JUnit 5 having more capabilities and different ways of doing stuff.

But there are some very obvious differences between 4 and 5 in terms of:

- ignoring tests
- running methods before and after methods and test classes
- exception asserting

I created two easy to 'diff' tests with explanation in the project here:

[Basic Differences Between 4 and 5](https://github.com/eviltester/junitexperiments/tree/master/src/test/java/compare4and5basics)