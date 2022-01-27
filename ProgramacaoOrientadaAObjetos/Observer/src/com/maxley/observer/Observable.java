package com.maxley.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
