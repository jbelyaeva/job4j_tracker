package ru.job4j.tracker.sortItem;

import java.util.Comparator;
import java.util.Objects;
import ru.job4j.tracker.Item;

public class SortItemByNameDecrease implements Comparator<Item> {

  @Override
  public int compare(Item first, Item second) {
      return second.getName().compareTo(first.getName());
  }
}