package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

  public static void main(String[] args) {
    Item date = new Item();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    String currentDateTimeFormat = date.getCreated().format(formatter);
    System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

    Item item = new Item(1, "Вася");
    System.out.println(item);
  }

}
