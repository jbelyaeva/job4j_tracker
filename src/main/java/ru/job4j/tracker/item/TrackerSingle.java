package ru.job4j.tracker.item;

import ru.job4j.tracker.Tracker;

public class TrackerSingle {
  private TrackerSingle() {
  }

  public static Tracker getInstance() {
    return Holder.INSTANCE;
  }

  private static final class Holder {
    private static final Tracker INSTANCE = new Tracker();
  }
}