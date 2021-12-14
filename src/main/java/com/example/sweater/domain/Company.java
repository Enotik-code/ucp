package com.example.sweater.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private String mail;
    private String telephone;
    private String address;
    private double deliveryTimeCoefficient;
    private double deliveryCostCoefficient;

    public Company(){ }

    public Company(String name, String address, String mail, String telephone, double deliveryTimeCoefficient, double deliveryCostCoefficient, User user){
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.telephone = telephone;
        this.deliveryTimeCoefficient = deliveryTimeCoefficient;
        this.deliveryCostCoefficient = deliveryCostCoefficient;
        this.user = user;
    }


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<Truck> trucks;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<Delivery> deliveries;

    public void setId(long id) { this.id = id; }

    public void setAddress(String address) { this.address = address; }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void setDeliveryCostCoefficient(double deliveryCostCoefficient) {
        this.deliveryCostCoefficient = deliveryCostCoefficient;
    }

    public void setDeliveryTimeCoefficient(double deliveryTimeCoefficient) {
        this.deliveryTimeCoefficient = deliveryTimeCoefficient;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public void setName(String name) { this.name = name; }

    public void setMail(String mail) { this.mail = mail; }

    public void setTelephone(String tel_number) { this.telephone = tel_number; }

    public void setUser(User user) { this.user = user; }

    public String getAddress() { return address; }

    public String getName() { return name; }

    public Long getId() { return id; }

    public String getMail() { return mail; }

    public String getTelephone() { return telephone; }

    public User getUser() { return user; }

    public double getDeliveryCostCoefficient() {
        return deliveryCostCoefficient;
    }

    public double getDeliveryTimeCoefficient() {
        return deliveryTimeCoefficient;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(mail, company.mail) &&
                Objects.equals(telephone, company.telephone) &&
                Objects.equals(address, company.address) &&
                Objects.equals(user, company.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mail, telephone, address, user);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}



