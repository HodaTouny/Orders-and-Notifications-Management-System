package com.example.Orders.and.Notifications.Management.System.Customize;

import com.example.Orders.and.Notifications.Management.System.Notifications.Notification;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NotificationSerialize extends JsonSerializer<Notification> {
    @Override
    public void serialize(Notification notication, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("order", notication.getOrder());
        jsonGenerator.writeObjectField("notificationTemplate", notication.getNotificationTemplate());
        jsonGenerator.writeEndObject();
    }

}
