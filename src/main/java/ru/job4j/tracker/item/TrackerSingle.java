package ru.job4j.tracker.item;

import ru.job4j.tracker.Tracker;

public class TrackerSingle {
  private static final Tracker INSTANCE = new Tracker();

  private TrackerSingle() {
  }

  public static Tracker getInstance() {
    return INSTANCE;
  }
}