package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class EditAction implements UserAction {
  private final Output out;

  public EditAction(Output out) {
    this.out = out;
  }

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
     out.println("Edit pass");
     out.println(item);
    } else {
      out.println("Edit failure. Not found id.");
    }
    out.println("");
    return true;
  }
}
