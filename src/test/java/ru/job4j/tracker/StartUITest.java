package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class StartUITest {

  @Test
  public void whenExit() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"0"}
    );
    Tracker tracker = new Tracker();
    UserAction[] actions = {
        new ExitAction()
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        "Menu." +
            System.lineSeparator() +
            "0. Exit" +
            System.lineSeparator()
    ));
  }

  @Test
  public void whenFindAll() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"0", "1"}
    );
    Tracker tracker = new Tracker();
    Item item = tracker.add(new Item("Items name"));
    UserAction[] actions = {
        new ShowAllAction(out),
        new ExitAction()
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        "Menu." +
            System.lineSeparator() +
            "0. Show all items" +
            System.lineSeparator() +
            "1. Exit" +
            System.lineSeparator() +
            item +
            System.lineSeparator() +
            System.lineSeparator() +
            "Menu." +
            System.lineSeparator() +
            "0. Show all items" +
            System.lineSeparator() +
            "1. Exit" +
            System.lineSeparator()
    ));
  }

  @Test
  public void whenFindByName() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"0", "Items name", "1"}
    );
    Tracker tracker = new Tracker();
    Item item = tracker.add(new Item("Items name"));
    UserAction[] actions = {
        new FindByNameAction(out),
        new ExitAction()
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        "Menu." +
            System.lineSeparator() +
            "0. Find items by name" +
            System.lineSeparator() +
            "1. Exit" +
            System.lineSeparator() +
            item +
            System.lineSeparator() +
            System.lineSeparator() +
            "Menu." +
            System.lineSeparator() +
            "0. Find items by name" +
            System.lineSeparator() +
            "1. Exit"
            + System.lineSeparator()
    ));
  }

  @Test
  public void whenFindById() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"0", "1", "1"}
    );
    Tracker tracker = new Tracker();
    Item item = tracker.add(new Item("Items name"));
    UserAction[] actions = {
        new FindByIdAction(out),
        new ExitAction()
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        "Menu." +
            System.lineSeparator() +
            "0. Find item by Id" +
            System.lineSeparator() +
            "1. Exit" +
            System.lineSeparator() +
            item +
            System.lineSeparator() +
            System.lineSeparator() +
            "Menu." +
            System.lineSeparator() +
            "0. Find item by Id" +
            System.lineSeparator() +
            "1. Exit"
            + System.lineSeparator()
    ));
  }
}