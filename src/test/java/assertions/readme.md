# Assertions

This package doesn't explore all the assertion libraries fully.

But it shows the basics to compare them.

## Java Built In Assertions

Java has a built in assertion `assert`.

These are designed for production applications rather than testing. They can be enabled or disabled at run time and by default are disabled in production code.

In the olden days, we used to add asserts into code to assert on preconditions prior to executing code, to protect the system from bad data etc.

_Or more likely, to protect from other programmers in the team who might not call your module with the correct parameters._

Whatever the reason, I don't think it is a good idea to 'assert' in production code and bring the application down because you didn't validate the input. I do remember using it in `C` and `C++` when writing non-production code. But I would never do that when coding today.

Java `assert` throws an `AssertionError` which is actually an `Error` and I advise against code throwing Errors, leave that to the JVM, our code throws Exceptions.

- `AssertionError extends Error`

All told, I don't recommend using `assert` but if you find yourself in a bind and want to use this when debugging or something, then you know it exists.

## Statically Importing or Accessing Assertions

I tend to statically access assertions in the code rather than statically import them.

JUnit 4 assertions are imported from `org.junit.Assert`:

- statically access `Assert.assertTrue(true)`
- statically import `import static org.junit.Assert.*;` and then access `assertTrue(true);`

~~~~~~~~
import static org.junit.Assert.*;
import org.junit.Test;

public class JavaStaticallyImportAsserts {
    
    @Test
    public void canAccessAssertsViaStaticImport(){
        assertTrue(true);
    }
}
~~~~~~~~

I used to statically import, but I found that statically accessing them was more helpful because I could take advantage of code completion in the IDE e.g. `Assert.` and then see a list of available assertions.

Different teams use different coding standards. Personally I statically access. And I find it easier to teach people using this approach because code completion helps them learn.

See `staticimportsvsaccess` package for an example of statically importing.

In the examples I use static access in JUnit 4 and JUnit 5 rather than import for:

- readability
- ease of code completion

In Truth and AssertJ, I use static import again for readability and ease of code completion.

The difference is that Truth and AssertJ are both fluent interfaces based around method chaining, whereas JUnit 4 and Junit 5 are single method calls.


## JUnit 5 Assertions

## Hamcrest

## AssertJ


