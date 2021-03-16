package ru.job4j.tracker.sortitem;

import java.util.Comparator;
import ru.job4j.tracker.Item;

public class SortItemByNameDecrease implements Comparator<Item> {

  @Override
  public int compare(Item first, Item second) {
      return second.getName().compareTo(first.getName());
  }
}