package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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

  @Test
  public void whenReplaceItem() {
    Tracker tracker = new Tracker();
    Item item = new Item("new item");
    tracker.add(item);
    String[] answers = {
        String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
        "replaced item"
    };
    Input input = new StubInput(answers);
    StartUI.editItem(input, tracker);
    Item replaced = tracker.findById(item.getId());
    assertThat(replaced.getName(), is("replaced item"));
  }

  @Test
  public void whenDeleteItem() {
    Tracker tracker = new Tracker();
    Item item = new Item("new item");
    tracker.add(item);
    String[] answers = {
        String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
        "delete item"
    };
    Input input = new StubInput(answers);
    StartUI.deleteItem(input, tracker);
    Item delete = tracker.findById(item.getId());
    assertThat(delete, is(nullValue()));
  }
}