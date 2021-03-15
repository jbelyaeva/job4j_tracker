package ru.job4j.tracker;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import ru.job4j.tracker.sortItem.SortItemByNameDecrease;
import ru.job4j.tracker.sortItem.SortItemByNameIncrease;

public class SortItemByNameTest{

    @Test
    public void whenSortIncrease() {
      List<Item> items = Arrays.asList(
          new Item(1,"Petr Arsentev"),
          new Item(3,"Anna Poletaeva"),
          new Item(2,"Lev Tolstoy")
      );
      Collections.sort(items, new SortItemByNameIncrease());
      assertThat(items, equalTo(Arrays.asList(
          new Item(3,"Anna Poletaeva"),
          new Item(2,"Lev Tolstoy"),
          new Item(1,"Petr Arsentev")
      )));
    }

  @Test
  public void whenSortDecrease() {
    List<Item> items = Arrays.asList(
        new Item(1,"Petr Arsentev"),
        new Item(3,"Anna Poletaeva"),
        new Item(2,"Lev Tolstoy")
    );
    Collections.sort(items, new SortItemByNameDecrease());
    assertThat(items, equalTo(Arrays.asList(
        new Item(1,"Petr Arsentev"),
        new Item(2,"Lev Tolstoy"),
        new Item(3,"Anna Poletaeva")
    )));
  }
}