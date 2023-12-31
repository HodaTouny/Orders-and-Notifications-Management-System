package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ShipmentTemplate extends NotificationTemplate{
    ShipmentTemplate(){
        this.subject = "shipment";
        this.availableLanguages.add(Language.en);
        this.availableLanguages.add(Language.fr);
    }


    @Override
    public void setContent(SimpleOrder order, Language language) {
        if (this.availableLanguages.contains(language)){
            ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language.name()));
            String key = "order.shipped";
            String translatedContent = messages.getString(key)
                    .replace("{customerName}", order.getCustomer().getName())
                    .replace("{orderId}", String.valueOf(order.getId()));

            this.content = translatedContent;
        }
    }
}
