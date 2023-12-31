# Orders and Notifications Management System

This Java Spring Boot application is designed to manage orders and notifications, providing a comprehensive system for customers to interact with products, place orders, and receive notifications. The application follows RESTful API principles and utilizes an in-memory database for data storage.

## Features

### 1. Product Management

- Display a list of all available products for purchase, including details such as serial number, name, vendor, category, and price.
- Provide a count of remaining parts for each product category.

### 2. Customer Account Management

- Allow customers to create an account and set a specific balance for future purchases.

### 3. Order Placement

- Enable customers to place both simple and compound orders.
- Compound orders can include products from different locations to reduce shipping fees.

### 4. Order Details

- List details of both simple and compound orders.

### 5. Order Shipping

- Deduct shipping fees from customer accounts upon order shipment.

### 6. Notifications Management

- Create notification templates for order placement and shipment.
- Manage templates, subjects, content, languages, and channels (email, SMS).
- Implement a notifications queue for pending notifications.
- List the content of the notifications queue.

### 7. Order Cancelation
- Allow customers to cancel order placement or shipping within a pre-configured automated duration.
