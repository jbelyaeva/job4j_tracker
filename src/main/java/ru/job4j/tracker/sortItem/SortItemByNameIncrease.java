package ru.job4j.tracker.sortItem;

import java.util.Comparator;
import java.util.Objects;
import ru.job4j.tracker.Item;

public class SortItemByNameIncrease implements Comparator<Item> {

  private int id;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public int compare(Item first, Item second) {
      return first.getName().compareTo(second.getName());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SortItemByNameIncrease that = (SortItemByNameIncrease) o;
    return id == that.id && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}