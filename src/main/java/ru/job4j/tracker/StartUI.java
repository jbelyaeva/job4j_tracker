package ru.job4j.tracker;

import java.util.ArrayList;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.item.TrackerSingle;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.useraction.CreateAction;
import ru.job4j.tracker.useraction.DeleteAction;
import ru.job4j.tracker.useraction.EditAction;
import ru.job4j.tracker.useraction.ExitAction;
import ru.job4j.tracker.useraction.FindByIdAction;
import ru.job4j.tracker.useraction.FindByNameAction;
import ru.job4j.tracker.useraction.ShowAllAction;
import ru.job4j.tracker.useraction.UserAction;

public class StartUI {

  private final Output out;

  public StartUI(Output out) {
    this.out = out;
  }

  public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
    boolean run = true;
    while (run) {
      this.showMenu(actions);
      int select = input.askInt("Select: ");
      if (select < 0 || select >= actions.size()) {
        out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
        continue;
      }
      UserAction action = actions.get(select);
      run = action.execute(input, tracker);
    }
  }

  private void showMenu(ArrayList<UserAction> actions) {
    out.println("Menu.");
    for (int index = 0; index < actions.size(); index++) {
      out.println(index + ". " + actions.get(index).name());
    }
  }

  public static void main(String[] args) {
    Output output = new ConsoleOutput();
    Input input = new ValidateInput(output, new ConsoleInput());
    Tracker tracker = TrackerSingle.getInstance();
    ArrayList<UserAction> actions = new ArrayList<>();
    actions.add(new CreateAction(output));
    actions.add(new ShowAllAction(output));
    actions.add(new EditAction(output));
    actions.add(new DeleteAction(output));
    actions.add(new FindByIdAction(output));
    actions.add(new FindByNameAction(output));
    actions.add(new ExitAction());
    new StartUI(output).init(input, tracker, actions);
  }
}
