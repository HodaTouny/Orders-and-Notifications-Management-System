package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Orders.SimpleOrder;
import com.example.Orders.and.Notifications.Management.System.Users.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class OrderTemplate extends NotificationTemplate{
    OrderTemplate(){
        this.subject = "order";
        this.availableLanguages.add(Language.en);
        this.availableLanguages.add(Language.fr);
   }
    @Override
    public void setContent(SimpleOrder order, Language language) {
        if (this.availableLanguages.contains(language)){
            ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language.name()));
            String key = "order.placed";
            String translatedContent = messages.getString(key)
                    .replace("{customerName}", order.getCustomer().getName())
                    .replace("{orderId}", String.valueOf(order.getId()));

            this.content = translatedContent;
        }

    }
}
