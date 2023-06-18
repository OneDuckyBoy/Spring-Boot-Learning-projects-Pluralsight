package com.Spring.AOP.example1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Passenger {
    private int id;
    public Passenger(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Passenger: "+id;
    }

}
