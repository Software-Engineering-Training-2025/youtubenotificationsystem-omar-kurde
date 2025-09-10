package org.example;

import org.example.observer.User;
import org.example.subject.Channel;

public class Main {
    public static void main(String[] args) {
        // TODO:
        // 1. Create some Channels
        // 2. Create some Users
        // 3. Subscribe Users to Channels
        // 4. Upload videos and see notifications propagate
        ChannelService channelService = new ChannelService();
        Channel channel1 = new Channel("MY CHANNEL1");
        channelService.createNewChannel(channel1);
        Channel channel2 = new Channel("MY CHANNEL2");
        channelService.createNewChannel(channel2);

        User user1 = new User("omar");
        User user2 = new User("ahmad");

        channelService.subscribeToChannel(channel1, user1);
        channelService.subscribeToChannel(channel1, user2);
        channelService.subscribeToChannel(channel2, user2);

        channelService.wantNotifications(channel1, user1);

        channelService.wantNotifications(channel2, user2);

        channelService.upload(channel1 , "my first video ");
        channelService.upload(channel2 , "my first video ");
        channelService.upload(channel1 , "my second video ");



    }
}