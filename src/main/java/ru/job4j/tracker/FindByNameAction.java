package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

  @Override
  public String name() {
    return "Find items by name";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    String name = input.askStr("Enter name: ");
    Item[] items = tracker.findByName(name);
    if (items.length == 0) {
      System.out.println("Item not found by this name.");
    } else {
      for (Item item : items) {
        System.out.println(item);
      }
    }
    System.out.println();
    return true;
  }
}
