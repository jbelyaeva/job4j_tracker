package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {

  private final ArrayList<Item> items = new ArrayList<>();
  private int ids = 1;
  private int size = 0;

  public Item add(Item item) {
    item.setId(ids++);
    items.add(item);
    return item;
  }

  public Item findById(int id) {
    /* Находим индекс */
    int index = indexOf(id);
    /* Если индекс найден возвращаем item, иначе null */
    return index != -1 ? items.get(index-1) : null;
  }

  public ArrayList<Item>  findByName(String key) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : items)
        if (item.getName().equals(key)) {
          result.add(item);
        size++;
      }
    return result;
  }

  public ArrayList<Item> findAll() {
    return items;
  }

  private int indexOf(int id) {
    int rsl = -1;
      for (Item item : items){
        if(item.getId()==id){
          rsl = item.getId();
          break;
        }
      }
    return rsl;
  }

  public boolean replace(int id, Item item) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    item.setId(id);
    if (rsl) {
      items.add(item);
    }
    return rsl;
  }

  public boolean delete(int id) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    if (rsl) {
      System.arraycopy(items, index + 1, items, index, size - index);
      size--;
    }

    return rsl;
  }

}