package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Set;

import edu.austral.ingsis.math.binary.*;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new Constant(1), new Constant(6));
    final Set<String> result = function.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function twelve = new Constant(12);
    Function divVariable = new Variable("div");
    Function division = new Division(twelve, divVariable);

    final Set<String> result = division.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function nine = new Constant(9);
    Function xVariable = new Variable("x");
    Function division = new Division(nine, xVariable);
    Function yVariable = new Variable("y");
    Function multiplication = new Multiplication(division, yVariable);

    final Set<String> result = multiplication.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function twentySeven = new Constant(27);
    Function aVar = new Variable("a");
    Function division = new Division(twentySeven, aVar);
    Function bVar = new Variable("b");
    Function exponentiation = new Pow(division, bVar);

    final Set<String> result = exponentiation.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function zVariable = new Variable("z");
    Function half = new Constant(0.5);
    Function power = new Pow(zVariable, half);

    final Set<String> result = power.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function valueVariable = new Variable("value");
    Function eight = new Constant(8);
    Function subtraction = new Subtraction(valueVariable, eight);

    final Set<String> result = subtraction.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function valueVariable = new Variable("value");
    Function eight = new Constant(8);
    Function subtraction = new Subtraction(valueVariable, eight);

    final Set<String> result = subtraction.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function five = new Constant(5);
    Function iVar = new Variable("i");
    // Use Subtraction instead of Operation for clarity and correctness
    Function subtraction = new Subtraction(five, iVar);
    Function eight = new Constant(8);
    // Use Multiplication instead of Operation for clarity and correctness
    Function multiplication = new Multiplication(subtraction, eight);

    final Set<String> result = multiplication.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
