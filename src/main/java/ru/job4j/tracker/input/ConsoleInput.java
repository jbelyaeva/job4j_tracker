package ru.job4j.tracker.input;

import java.util.Scanner;
import ru.job4j.tracker.input.Input;

public class ConsoleInput implements Input {
  private Scanner scanner = new Scanner(System.in);

  @Override
  public String askStr(String question) {
    System.out.print(question);
    return scanner.nextLine();
  }

  @Override
  public int askInt(String question) {
    return Integer.valueOf(askStr(question));
  }
}
