# Basic Differences Between JUnit 4 and JUnit 4

## Explained

<iframe width="560" height="315" src="https://www.youtube.com/embed/hqbSjkQxGwU" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## Summary Basic difference between JUnit 4 and JUnit 5

Marking Tests as Ignored:

- JUnit 4 uses `@Ignore`
- JUnit 5 uses `@Disabled`

Assertions are statically accessed from:

- JUnit 4 uses `Assert.`
- JUnit 5 uses `Assertions.`

Assertion message position differs:

- JUnit 4 assertion messages are the first argument
- JUnit 5 assertion messages are the last argument

Annotations for running code before and after each method:

- JUnit 4 uses `@Before`, and `@After`
- JUnit 5 uses `@BeforeEach`, and `@AfterEach`

Annotations for running code before and after each class:

- JUnit 4 uses `@BeforeClass`, and `@AfterClass`
- JUnit 5 uses `@BeforeAll`, and  `@AfterAll`

By default the methods need to be `static` in both JUnit 4 and 5, but in v5 we
can annotate the class to avoid need to make the `All` methods static:

- @TestInstance(TestInstance.Lifecycle.PER_CLASS)

Checking that an exception is thrown:

- JUnit 4 uses `@Test(expected = InterruptedException.class)`
- JUnit 5 uses an assertion with the code in a closure lambda expression, which allows
  additional assertions to be made on the exception

~~~~~~~~
Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
    throw new NullPointerException("We interrupt this test to throw an runtime exception");
});
~~~~~~~~