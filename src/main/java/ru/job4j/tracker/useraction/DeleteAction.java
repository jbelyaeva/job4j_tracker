package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAction implements UserAction {
  private final Output out;

  public DeleteAction(Output out) {
    this.out = out;
  }

  @Override
  public String name() {
    return "Delete item";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    int id = input.askInt("Enter id: ");
    if (tracker.delete(id)) {
      out.println("Delete pass");
    } else {
     out.println("Delete failure. Not found id.");
    }
    out.println("");
    return true;
  }
}
