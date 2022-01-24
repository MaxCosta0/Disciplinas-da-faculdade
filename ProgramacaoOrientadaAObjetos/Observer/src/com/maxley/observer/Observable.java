package com.maxley.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer);

    public void unsubscribe(Observer observer);

    public void publish();
}
