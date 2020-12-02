package ru.job4j.tracker;


public class StartUI {

  public static void createItem(Input input, Tracker tracker) {
    System.out.println("=== Create a new Item ====");
    String name = input.askStr("Enter name: ");
    Item item = new Item(name);
    tracker.add(item);
    System.out.println();
  }

  public static void showAllItem(Tracker tracker) {
    System.out.println("=== Show all items ====");
    Item[] items = tracker.findAll();
    for (Item item : items) {
      System.out.println(item);
    }
    System.out.println();
  }

  public static void editItem(Input input, Tracker tracker) {
    System.out.println("=== Edit item ====");
    int id = input.askInt("Enter id: ");
    String name = input.askStr("Enter new name: ");
    Item item = new Item(name);
    if (tracker.replace(id, item)) {
      System.out.println("Edit pass");
      System.out.println(item);
    } else {
      System.out.println("Edit failure. Not found id.");
    }
    System.out.println();
  }

  public static void deleteItem(Input input, Tracker tracker) {
    System.out.println("=== Delete item ====");
    int id = input.askInt("Enter id: ");
    if (tracker.delete(id)) {
      System.out.println("Delete pass");
    } else {
      System.out.println("Delete failure. Not found id.");
    }
    System.out.println();
  }

  public static void findItemById(Input input, Tracker tracker) {
    System.out.println("=== Find item by Id ====");
    int id = input.askInt("Enter id: ");
    Item item = tracker.findById(id);
    if (item == null) {
      System.out.println("Item not found by this id.");
    } else {
      System.out.println(item);
    }
    System.out.println();
  }

  public static void findItemByName(Input input, Tracker tracker) {
    System.out.println("===  Find items by name ====");
    String name = input.askStr("Enter name: ");
    Item[] items = tracker.findByName(name);
    if (items.length == 0) {
      System.out.println("Item not found by this name.");
    } else {
      for (Item item : items) {
        System.out.println(item);
      }
    }
    System.out.println();
  }

  public void init(Input input, Tracker tracker) {
    boolean run = true;
    while (run) {
      this.showMenu();
      int select = input.askInt("Select: ");
      if (select == 0) {
        createItem(input, tracker);
      } else if (select == 1) {
        showAllItem(tracker);
      } else if (select == 2) {
        editItem(input, tracker);
      } else if (select == 3) {
        deleteItem(input, tracker);
      } else if (select == 4) {
        findItemById(input, tracker);
      } else if (select == 5) {
        findItemByName(input, tracker);
      } else if (select == 6) {
        run = false;
      }
    }
  }

  private void showMenu() {
    System.out.println("Menu.");
    System.out.println("0. Add new Item");
    System.out.println("1. Show all items");
    System.out.println("2. Edit item");
    System.out.println("3. Delete item");
    System.out.println("4. Find item by Id");
    System.out.println("5. Find items by name");
    System.out.println("6. Exit Program");
  }


  public static void main(String[] args) {
    Input input = new ConsoleInput();
    Tracker tracker = new Tracker();
    new StartUI().init(input, tracker);
  }

}
