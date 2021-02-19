package ru.job4j.tracker.useraction;

import java.util.List;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ShowAllAction implements UserAction {

  private final Output out;

  public ShowAllAction(Output out) {
    this.out = out;
  }

  @Override
  public String name() {
    return "Show all items";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    List<Item> items = tracker.findAll();
    for (Item item : items) {
      out.println(item);
    }
    out.println("");
    return true;
  }

}
