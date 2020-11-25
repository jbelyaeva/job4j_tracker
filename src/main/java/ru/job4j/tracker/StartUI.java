package ru.job4j.tracker;

public class StartUI {

  public static void main(String[] args) {
    Tracker tracker = new Tracker();
    tracker.add(new Item(1,"Заявление старое"));
    tracker.add(new Item(2,"Заявление новое"));
    Item item = tracker.findById(1);
    System.out.println(item.getId()+" "+item.getName());

    Item[] items = tracker.findByName("Заявление новое");
    for (int i = 0; i <items.length ; i++) {
      System.out.println(items[i]);
    }
  }

}
