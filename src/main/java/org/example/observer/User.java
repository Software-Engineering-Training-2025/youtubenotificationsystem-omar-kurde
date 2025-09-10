package org.example.observer;

import java.util.Objects;
import java.util.UUID;

public class User implements Observer {
    private final String username;
    private final String id;
    public User(String username) {
        this.username = username;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + this.username + ": " + message);
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }




    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(username, user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
