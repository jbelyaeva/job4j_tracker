package ru.job4j.tracker;

public class EditAction implements UserAction{

  @Override
  public String name() {
    return "Edit item";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    int id = input.askInt("Enter id: ");
    String name = input.askStr("Enter new name: ");
    Item item = new Item(name);
    if (tracker.replace(id, item)) {
      System.out.println("Edit pass");
      System.out.println(item);
    } else {
      System.out.println("Edit failure. Not found id.");
    }
    System.out.println();
    return true;
  }
}
