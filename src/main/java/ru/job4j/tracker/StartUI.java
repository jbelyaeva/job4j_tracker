package ru.job4j.tracker;

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

  public void init(Input input, Tracker tracker, UserAction[] actions) {
    boolean run = true;
    while (run) {
      this.showMenu(actions);
      int select = input.askInt("Select: ");
      if (select < 0 || select >= actions.length) {
        out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
        continue;
      }
      UserAction action = actions[select];
      run = action.execute(input, tracker);
    }
  }

  private void showMenu(UserAction[] actions) {
    out.println("Menu.");
    for (int index = 0; index < actions.length; index++) {
      out.println(index + ". " + actions[index].name());
    }
  }

  public static void main(String[] args) {
    Output output = new ConsoleOutput();
    Input input = new ValidateInput(output, new ConsoleInput());
    Tracker tracker = TrackerSingle.getInstance();
    UserAction[] actions = {
        new CreateAction(output), new ShowAllAction(output), new EditAction(output),
        new DeleteAction(output),
        new FindByIdAction(output), new FindByNameAction(output), new ExitAction()
    };
    new StartUI(output).init(input, tracker, actions);
  }
}
