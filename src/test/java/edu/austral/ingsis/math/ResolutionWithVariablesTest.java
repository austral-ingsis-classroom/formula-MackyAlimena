package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /**
   * Case 1 + x where x = 3
   */
  @Test
  public void shouldResolveFunction1() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("x", 3d);
    final Double result = evaluator.evaluate("1 x +");
    assertThat(result, equalTo(4d));
  }

  /**
   * Case 12 / div where div = 4
   */
  @Test
  public void shouldResolveFunction2() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("div", 4d);
    final Double result = evaluator.evaluate("12 div /");
    assertThat(result, equalTo(3d));
  }

  /**
   * Case (9 / x) * y where x = 3 and y = 4
   */
  @Test
  public void shouldResolveFunction3() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("x", 3d);
    evaluator.setVariable("y", 4d);
    final Double result = evaluator.evaluate("9 x / y *");
    assertThat(result, equalTo(12d));
  }

  /**
   * Case (27 / a) ^ b where a = 9 and b = 3
   */
  @Test
  public void shouldResolveFunction4() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("a", 9d);
    evaluator.setVariable("b", 3d);
    final Double result = evaluator.evaluate("27 a / b ^");
    assertThat(result, equalTo(3d));
  }

  /**
   * Case z ^ (1/2) where z = 36
   */
  @Test
  public void shouldResolveFunction5() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("z", 36d);
    final Double result = evaluator.evaluate("z ^ (1 / 2)");
    assertThat(result, equalTo(6d));
  }

  /**
   * Case |value| - 8 where value = 8
   */
  @Test
  public void shouldResolveFunction6() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("value", 8d);
    final Double result = evaluator.evaluate("| value | - 8");
    assertThat(result, equalTo(0d));
  }

  /**
   * Case |value| - 8 where value = -8
   */
  @Test
  public void shouldResolveFunction7() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("value", -8d);
    final Double result = evaluator.evaluate("| value | - 8");
    assertThat(result, equalTo(0d));
  }

  /**
   * Case (5 - i) * 8 where i = 2
   */
  @Test
  public void shouldResolveFunction8() {
    MathEvaluator evaluator = new MathEvaluator();
    evaluator.setVariable("i", 2d);
    final Double result = evaluator.evaluate("(5 - i) * 8");
    assertThat(result, equalTo(24d));
  }
}