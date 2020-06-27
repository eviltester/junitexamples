# Parameterized Tests in JUnit 4

In JUnit 4 to create a parameterized test we:

- annotate the test class with `@RunWith(Parameterized.class)`
- create a static method to provide the data
- this method should be annotated with `@Parameterized.Parameters`
- the method providing data should return `Collection<Object[]>`
- we can provide a name attribute for the parameter method which dynamically changes the display name of the test
- our test class needs a constructor to setup the data when called by JUnit Runner
- our test methods do not take parameters but they all use the same data provided by the constructor
- if we want more granular control of parameterized tests in JUnit4 then use the library http://pragmatists.github.io/JUnitParams/

## Explanation Video

[![Junit 4 Parameterized Test](http://img.youtube.com/vi/9KLtQdBSqJo/0.jpg)](http://www.youtube.com/watch?v=9KLtQdBSqJo)

## Related Blog Post

[Junit 4 Parameterized Tests](http://eviltester.com/post/junit/junit-4-parameterized-tests/)