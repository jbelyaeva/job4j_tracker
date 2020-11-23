package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

  private final Item[] items = new Item[100];
  private int ids = 1;
  private int size = 0;

  public Item add(Item item) {
    item.setId(ids++);
    items[size++] = item;
    return item;
  }

  public Item findById(int id) {
    /* Находим индекс */
    int index = indexOf(id);
    /* Если индекс найден возвращаем item, иначе null */
    return index != -1 ? items[index] : null;
  }

  public Item[] findByName(String key) {
    Item[] result = new Item[100];
    int size = 0;
    for (Item item : items) {
      if (item.getName().equals(key)) {
        result[size] = item;
        size++;
      }
    }
    return Arrays.copyOf(result, size);
  }

  public Item[] findAll() {
    return Arrays.copyOf(items, size);
  }

  private int indexOf(int id) {
    int rsl = -1;
    for (int index = 0; index < size; index++) {
      if (items[index].getId() == id) {
        rsl = index;
        break;
      }
    }
    return rsl;
  }

  public boolean replace(int id, Item item) {
    boolean rsl = indexOf(id) != -1;
    if (rsl) {
      findById(id).setId(id);
      findById(id).setName(item.getName());
    }
    return rsl;
  }

  public boolean delete(int id) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    if (rsl) {
      System.arraycopy(items, index + 1, items, index, size - index);
      items[size - 1] = null;
      size--;
    }
    return rsl;
  }

}