package ru.job4j.tracker;

public class StartUI {

  private final Output out;

  public StartUI(Output out) {
    this.out = out;
  }

  public void init(Input input, Tracker tracker, UserAction[] actions) {
    boolean run = true;
    while (run) {
      this.showMenu(actions);
      boolean invalid = true;
      do {
        int select = input.askInt("Select: ");
        try {
          UserAction action = actions[select];
          run = action.execute(input, tracker);
          invalid = false;
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("Please enter validate data from Menu.");
        }
      } while (invalid);
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
    Input input = new ValidateInput();
    Tracker tracker = new Tracker();
    UserAction[] actions = {
        new CreateAction(output), new ShowAllAction(output), new EditAction(output),
        new DeleteAction(output),
        new FindByIdAction(output), new FindByNameAction(output), new ExitAction()
    };
    new StartUI(output).init(input, tracker, actions);
  }
}
