package ru.job4j.tracker;

public class FindByIdAction implements UserAction{

  @Override
  public String name() {
    return "Find item by Id";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    int id = input.askInt("Enter id: ");
    Item item = tracker.findById(id);
    if (item == null) {
      System.out.println("Item not found by this id.");
    } else {
      System.out.println(item);
    }
    System.out.println();
    return true;
  }
}
