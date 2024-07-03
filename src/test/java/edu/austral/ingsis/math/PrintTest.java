package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binary.*;
import edu.austral.ingsis.math.unary.AbsoluteValue;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function addition = new Addition(new Constant(1), new Constant(6));
    final String result = addition.print();
    final String expected = "1 + 6";
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function division = new Division(new Constant(12), new Constant(2));
    final String result = division.print();
    final String expected = "12 / 2";
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function division = new Division(new Constant(9), new Constant(2));
    Function multiplication = new Multiplication(division, new Constant(3));
    final String result = multiplication.print();
    final String expected = "(9 / 2) * 3";
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function division = new Division(new Constant(27), new Constant(6));
    Function exponentiation = new Pow(division, new Constant(2));
    final String result = exponentiation.print();
    final String expected = "(27 / 6) ^ 2";
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    // Assuming an Absolute class exists for handling absolute value operations
    Function valueVariable = new Variable("value");
    Function absoluteValue = new AbsoluteValue(valueVariable); // Hypothetical implementation
    Function subtraction = new Subtraction(absoluteValue, new Constant(8));
    final String result = subtraction.print();
    final String expected = "|value| - 8";
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    // Assuming an Absolute class exists for handling absolute value operations
    Function valueVariable = new Variable("value");
    Function absoluteValue = new AbsoluteValue(valueVariable); // Hypothetical implementation
    Function subtraction = new Subtraction(absoluteValue, new Constant(8));
    final String result = subtraction.print();
    final String expected = "|value| - 8";
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Function subtraction = new Subtraction(new Constant(5), new Variable("i"));
    Function multiplication = new Multiplication(subtraction, new Constant(8));
    final String result = multiplication.print();
    final String expected = "(5 - i) * 8";
    assertThat(result, equalTo(expected));
  }
}
