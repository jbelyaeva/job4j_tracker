package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.useraction.ExitAction;
import ru.job4j.tracker.useraction.FindByIdAction;
import ru.job4j.tracker.useraction.FindByNameAction;
import ru.job4j.tracker.useraction.ShowAllAction;
import ru.job4j.tracker.useraction.UserAction;


public class StartUITest {

  @Test
  public void whenExit() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[]{"0"}
    );
    Tracker tracker = new Tracker();
    List<UserAction> actions = new ArrayList<>();
   actions.add(new ExitAction());
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
    List<UserAction> actions = new ArrayList<>();
    actions.add(new ShowAllAction(out));
    actions.add(new ExitAction());
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
    List<UserAction> actions = new ArrayList<>();
    actions.add( new FindByNameAction(out));
    actions.add(new ExitAction());
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
    List<UserAction> actions = new ArrayList<>();
    actions.add(new FindByIdAction(out));
    actions.add(new ExitAction());
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
  @Test
  public void whenInvalidExit() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[] {"9","0"}
    );
    Tracker tracker = new Tracker();
    List<UserAction> actions = new ArrayList<>();
    actions.add(new ExitAction());
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        String.format(
            "Menu.%n"
                + "0. Exit%n"
                + "Wrong input, you can select: 0 .. 0%n"
                + "Menu.%n"
                + "0. Exit%n"
        )
    ));
  }

  @Test
  public void whenInvalidMenu() {
    Output out = new StubOutput();
    Input in = new StubInput(
        new String[] {"-1","0"}
    );
    Tracker tracker = new Tracker();
    List<UserAction> actions = new ArrayList<>();
    actions.add(new ExitAction());
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
        String.format(
            "Menu.%n"
                + "0. Exit%n"
                + "Wrong input, you can select: 0 .. 0%n"
                + "Menu.%n"
                + "0. Exit%n"
        )
    ));
  }
}