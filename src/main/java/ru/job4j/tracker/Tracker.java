package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс описывает работу с записями
 * @author YLIYA BELYAEVA
 * @version 1.0
 */
public class Tracker {

  private final List<Item> items = new ArrayList<>();
  private int ids = 1;

  /**
   * Метод добавляет новую Запись, которую получает на вход
   * @param item, запись, которую необходимо добавить
   * @return - возвращает добавленную запись
   */
  public Item add(Item item) {
    item.setId(ids++);
    items.add(item);
    return item;
  }

  /**
   * Метод осуществляет поиск записи по id, который получает на вход
   * @param id  - идентификатор записи
   * @return возвращает найденную запис в случае успешного поиска и null, есди запись не найдена
   */
  public Item findById(int id) {
    int index = indexOf(id);
    return index != -1 ? items.get(index) : null;
  }

  /**
   * Метод осуществляет поиск записи по имени, которое получает на вход
   * @param key - имя в записи
   * @return возвращает список найденных записей, при успешном поиске, и нулевой список,
   * при не успешном
   */
  public List<Item> findByName(String key) {
    List<Item> result = new ArrayList<>();
    for (Item item : items) {
      if (item.getName().equals(key)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Метод осуществляет поиск всех записей
   * @return возвращает список найденных записей
   */
  public List<Item> findAll() {
    return items;
  }

  /**
   * Метод осуществляет поиск записи по id, который получает на вход
   * @param id - идентификатор записи
   * @return возвращает индекс
   */
  private int indexOf(int id) {
    int rsl = -1;
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getId() == id) {
        rsl = i;
        break;
      }
    }
    return rsl;
  }

  /**
   * Метод обновляет запись, найдя ее по id
   * @param id - идентификатор записи
   * @param item - новая запись
   * @return - возвращает true, если запись успешно обновлена и false, если не успешно
   */
  public boolean replace(int id, Item item) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    item.setId(id);
    if (rsl) {
      items.set(index, item);
    }
    return rsl;
  }

  /**
   * Метод удаляет запись, найдя ее по id, который получает на вход
   * @param id - идентификатор записи
   * @return - возвращает true, если запись успешно удалена и false, если не успешно
   */
  public boolean delete(int id) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    if (rsl) {
      items.remove(index);
    }
    return rsl;
  }

}