package ru.job4j.tracker;

public class DeleteAction implements  UserAction{
  @Override
  public String name() {
    return "Delete item";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    int id = input.askInt("Enter id: ");
    if (tracker.delete(id)) {
      System.out.println("Delete pass");
    } else {
      System.out.println("Delete failure. Not found id.");
    }
    System.out.println();
    return true;
  }
}
