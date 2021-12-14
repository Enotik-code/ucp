package com.example.sweater.domain;

import com.example.sweater.repos.CargoRepo;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String pickupAddress;
    private String deliveryAddress;
    private String addressPointOne;
    private String addressPointTwo;
    private String addressPointThree;
    private String deliveryType;
    private String companyName;
    private String cargoName;
    private int deliveryCost;
    private int deliveryTime;
    private int distance;
    private int volume;
    private boolean isDangerous;

    public Delivery(){}

    public Delivery(String pickupAddress, String deliveryAddress,
                    String addressPointOne, String addressPointTwo,
                    String addressPointThree, String deliveryType,
                    int distance, boolean isDangerous, Cargo cargo){
        this.addressPointOne = addressPointOne;
        this.addressPointTwo = addressPointTwo;
        this.addressPointThree = addressPointThree;
        this.pickupAddress = pickupAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
        this.distance = distance;
        this.isDangerous = isDangerous;
        this.cargo = cargo;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(long id) {
        this.id = id;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setAddressPointOne(String addressPointOne) {
        this.addressPointOne = addressPointOne;
    }

    public void setAddressPointThree(String addressPointThree) {
        this.addressPointThree = addressPointThree;
    }

    public void setAddressPointTwo(String addressPointTwo) {
        this.addressPointTwo = addressPointTwo;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public int getVolume() {
        return volume;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public User getUser() {
        return user;
    }

    public String getCargoName() {
        return cargoName;
    }

    public String getAddressPointOne() {
        return addressPointOne;
    }

    public String getAddressPointThree() {
        return addressPointThree;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getAddressPointTwo() {
        return addressPointTwo;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getDistance() {
        return distance;
    }
}
