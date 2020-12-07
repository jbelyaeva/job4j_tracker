package ru.job4j.tracker;

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
    Item[] items = tracker.findByName(name);
    if (items.length == 0) {
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
