package org.example.subject;

import org.example.observer.Observer;

import java.util.*;

public class Channel implements Subject{
    private final String name;
    private final Set<Observer> subscribers = new HashSet<>();
    private final Set<Observer> observers = new HashSet<>();
    private final Map<String ,String> videos = new HashMap<>();

    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title){
        // TODO: Notify all subscribers about new video
        String videoid = UUID.randomUUID().toString();
        videos.put(videoid, title);
        notifyObservers(title);

    }
    public void wantNotification(Observer observer){
        if (subscribers.contains(observer)){
            observers.add(observer);
        }
    }


    @Override
    public void subscribe(Observer observer) {
        // TODO: Add subscriber
        subscribers.add(observer);
    }


    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
        // TODO: Remove subscriber
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
        // TODO: Notify subscribers
    }

    public String getName() {
        return this.name;
    }

}
