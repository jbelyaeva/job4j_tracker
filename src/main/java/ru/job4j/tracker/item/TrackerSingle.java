package ru.job4j.tracker.item;

import ru.job4j.tracker.Tracker;

public enum  TrackerSingle {
  INSTANCE;
  Tracker tracker = new Tracker();

  public Tracker getTracker() {
    return tracker;
  }
}
