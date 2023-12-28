package com.example.Orders.and.Notifications.Management.System.Customize;

import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductSerialize extends JsonSerializer<Product> {
    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("serialNumber", product.getSerialNumber());
        jsonGenerator.writeStringField("vendor", product.getVendor());
        jsonGenerator.writeStringField("name", product.getName());
        jsonGenerator.writeNumberField("price", product.getPrice());
        jsonGenerator.writeObjectField("category", product.getCategory());
        jsonGenerator.writeEndObject();
    }
}
