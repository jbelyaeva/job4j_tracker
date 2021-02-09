package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateAction implements UserAction {
  private final Output out;

  public CreateAction(Output out) {
    this.out = out;
  }

  @Override
  public String name() {
    return "Create item";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    out.println("=== Create a new Item ====");
    String name = input.askStr("Enter name: ");
    Item item = new Item(name);
    tracker.add(item);
    out.println("");
    return true;
  }
}
