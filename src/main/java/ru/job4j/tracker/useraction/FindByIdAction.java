package ru.job4j.tracker.useraction;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindByIdAction implements UserAction {
  private final Output out;

  public FindByIdAction(Output out) {
    this.out = out;
  }

  @Override
  public String name() {
    return "Find item by Id";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    int id = input.askInt("Enter id: ");
    Item item = tracker.findById(id);
    if (item == null) {
     out.println("Item not found by this id.");
    } else {
     out.println(item);
    }
    out.println("");
    return true;
  }
}
