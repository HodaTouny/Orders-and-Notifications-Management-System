package com.example.Orders.and.Notifications.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersAndNotificationsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersAndNotificationsManagementSystemApplication.class, args);
	}

}

/* Product Categories -> Enum { DairyProducts,vegetables, Fruits , Sweets,  Electronics}
   Customer Type -> Enum { customer , vendor}
   Order Type -> Enum { Simple , Compound}
*/