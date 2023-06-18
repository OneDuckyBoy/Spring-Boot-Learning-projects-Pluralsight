package com.SpEL.spel.controller;

import com.SpEL.spel.data.City;
import com.SpEL.spel.data.Order;
import com.SpEL.spel.data.Shipping;
import com.SpEL.spel.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.CipherSpi;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    Order order;
    @Autowired
    User user;

    @Autowired
    Shipping shipping;

    @Autowired
    City city;

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public String getCustomer(){
        return user.getName();
    }
    @RequestMapping(value = "/amount",method = RequestMethod.GET)
    public double getOrderAmount(){
        return order.getDaysToDeliver();
    }

    @RequestMapping(value = "/discount",method = RequestMethod.GET)
    public double getDiscount(){
        return order.getDiscount();
    }
    @RequestMapping(value = "/origin",method = RequestMethod.GET)
    public String getOrigin(){
        return order.getOrigin();
    }
    @RequestMapping(value = "/deliver",method = RequestMethod.GET)
    public int getDaysToDeliver(){
        return order.getDaysToDeliver();
    }
    @RequestMapping(value = "/amount/formatted",method = RequestMethod.GET)
    public String getFormattedOrderAmount(){
        return order.getFormattedAmount();
    }

}
