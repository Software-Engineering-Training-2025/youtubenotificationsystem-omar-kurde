package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.util.*;

public class ChannelService {

    private final Map<String , Channel> channels = new HashMap<>();

    public Optional<Channel> getChannel(String name){
        return Optional.ofNullable(channels.get(name));
    }

    public void createNewChannel(Channel channel) {
        channels.put(channel.getName(), channel);
    }
    public void deleteChannel(Channel channel) {
        channels.remove(channel.getName());
    }


    public void subscribeToChannel(Channel channel,Observer observer) {
        channel.subscribe(observer);
    }
    public void wantNotifications(Channel channel,Observer observer) {
        channel.wantNotification(observer);
    }
    public void unsubscribeFromChannel(Channel channel,Observer observer) {
        channel.unsubscribe(observer);
    }

    public Set<String> listChannels(){
        return new HashSet<>(channels.keySet());
    }

    public void upload(Channel channel, String videoTitle){
        channel.uploadVideo(videoTitle);
    }

    public void newContentNotification(Channel channel, String message) {
        channel.notifyObservers(message);
    }
}
