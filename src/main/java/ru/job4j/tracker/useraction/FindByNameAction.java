package ru.job4j.tracker.useraction;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindByNameAction implements UserAction {
  private final Output out;

  public FindByNameAction(Output out) {
    this.out = out;
  }

  @Override
  public String name() {
    return "Find items by name";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    String name = input.askStr("Enter name: ");
    List<Item> items = tracker.findByName(name);
    if (items.size()== 0) {
      out.println("Item not found by this name.");
    } else {
      for (Item item : items) {
        out.println(item);
      }
    }
    out.println("");
    return true;
  }
}
