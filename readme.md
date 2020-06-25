# JUnit Examples

Some simple code to show uses of and differences between Junit 4 and 5.

[![Build Status](https://travis-ci.org/eviltester/junitexamples.svg?branch=master)](https://travis-ci.org/eviltester/junitexperiments)
![Java CI](https://github.com/eviltester/junitexamples/workflows/Java%20CI/badge.svg)
## Junit 5 can support JUnit 4

Rather than mix Junit 4 and JUnit 5

I added the JUnit 5 backwards compatibility dependency.

So the following gives JUnit 5 and JUnit 4 direct backwards compatibility:

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


## Running Both JUnit 4 and JUnit 5 from Command line

The `pom.xml`

with the addition of surefire plugin:

~~~~~~~
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M4</version>
            </plugin>
        </plugins>
    </build>
~~~~~~~

Should run both JUnit 4 and Junit 5 on `mvn clean test`

### Explanation Video

[![Video Showing Both JUnit 4 and JUnit 5 from Command Line](http://img.youtube.com/vi/UYyPrZ76G3I/0.jpg)](http://www.youtube.com/watch?v=UYyPrZ76G3I "Running JUnit 4 and 5 from Commandline")

## Generating an HTML Report for JUnit

And generate an HTML report covering both with `mvn clean test site`

Add the maven site plugin, (in addition to the surefire plugin) in the build section of `pom.xml`

~~~~~~~~
   <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-site-plugin</artifactId>
                <version>3.7.1</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M4</version>
            </plugin>
        </plugins>
    </build>
~~~~~~~~

And add maven surefire report plugin to the reporting section:

~~~~~~~~
    <!-- `mvn clean test site` to generate the junit html report-->
    <reporting>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M4</version>
            </plugin>
        </plugins>
    </reporting>
~~~~~~~~

### Explanation Video

[![Video Generation of JUnit HTML Report](http://img.youtube.com/vi/aOWWq70-z5o/0.jpg)](http://www.youtube.com/watch?v=aOWWq70-z5o "Generating a JUnit HTML Report")


## Differences between Junit 4 and JUnit 5

There are many differences between JUnit 4 and 5, in terms of JUnit 5 having more capabilities and different ways of doing stuff.

But there are some very obvious differences between 4 and 5 in terms of:

- ignoring tests
- running methods before and after methods and test classes
- exception asserting

I created two easy to 'diff' example tests with explanation in the project here:

[Basic Differences Between 4 and 5](https://github.com/eviltester/junitexperiments/tree/master/src/test/java/compare4and5basics)