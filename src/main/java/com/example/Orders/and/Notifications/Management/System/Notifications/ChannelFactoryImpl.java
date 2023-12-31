package com.example.Orders.and.Notifications.Management.System.Notifications;

public class ChannelFactoryImpl implements ChannelFactory {
    @Override
    public Channel createChannel(String channelType) {
        if (channelType.equalsIgnoreCase("SMS")) {
            return new SMS();
        } else if (channelType.equalsIgnoreCase("Email")) {
            return new Email();
        }return null;
    }
}
