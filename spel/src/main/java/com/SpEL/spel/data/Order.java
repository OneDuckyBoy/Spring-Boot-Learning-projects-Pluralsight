package com.SpEL.spel.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("order")
public class Order /* some fries*/{

    @Value("#{100}")
    private double amount;// of fries
    @Value("#{order.amount>99 ? order.amount * 5 /100:0}")
    private double discount;// of the fries
    @Value("#{user.country =='bg' and user.timeZone =='No.' 1: 3}")
    private int daysToDeliver;//the fries
    @Value("#{user.country}")
    private String origin;// of the fries
    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
    private String formattedAmount;

    @Value("#{shipping.locationsByCounty[user.country]}")
    public List<City> getShippingLocations() {
        return shippingLocations;
    }

    public void setShippingLocations(List<City> shippingLocations) {
        this.shippingLocations = shippingLocations;
    }

    private List<City> shippingLocations;

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }

    public double getAmount/*of fries*/() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDaysToDeliver() {
        return daysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver) {
        this.daysToDeliver = daysToDeliver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
