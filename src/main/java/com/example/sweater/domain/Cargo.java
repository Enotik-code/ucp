package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Cargo {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private int cost;
    private int capacity;
    private int weight;
    private boolean isClose;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "cargo", fetch = FetchType.LAZY)
    private Delivery delivery;


    public Cargo(){}

    public  Cargo(String name, int cost, int capacity, int weight, User user){
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.weight = weight;
        this.user = user;
        this.isClose = false;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public User getUser() {
        return user;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setClose(boolean close) {
        isClose = close;
    }

    public boolean isClose() {
        return isClose;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getCost() {
        return cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Delivery getDelivery() {
        return delivery;
    }

}
