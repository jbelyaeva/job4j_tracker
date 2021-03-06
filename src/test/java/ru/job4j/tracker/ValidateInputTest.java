package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

public class ValidateInputTest {

  @Test
  public void whenInvalidInput() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"one", "2"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(2));
  }

  @Test
  public void whenValidInput() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"1"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(1));
  }

  @Test
  public void whenDifferentInput() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"ш", "к", "2", "3", "3"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(2));
  }

  @Test
  public void when3ValidInput() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"2", "3", "3"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(2));
  }

  @Test
  public void whenValidNegative1Input() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"-1"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(-1)); //считает валидным,т.к. в этом классе не проверяется
    // это исключение
  }
}