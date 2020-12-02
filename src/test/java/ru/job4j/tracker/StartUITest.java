package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

  @Test
  public void whenAddItem() {
    String[] answers = {"Заявка 1"};
    Input input = new StubInput(answers);
    Tracker tracker = new Tracker();
    StartUI.createItem(input, tracker);
    Item created = tracker.findAll()[0];
    Item expected = new Item(answers[0]);
    assertThat(created.getName(), is(expected.getName()));
  }
}