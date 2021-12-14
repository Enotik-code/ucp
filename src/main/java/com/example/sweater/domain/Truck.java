package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String band;
    private String truckModel;
    private String plateNumber;
    private int liftingCapacity;
    private String type;
    private boolean isBusy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Truck(){}

    public Truck(String band, String truckModel, String plateNumber, int liftingCapacity, String type, Company company){
        this.band = band;
        this.truckModel = truckModel;
        this.plateNumber = plateNumber;
        this.liftingCapacity = liftingCapacity;
        this.type = type;
        this.company = company;
        this.isBusy = false;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public Company getCompany() {
        return company;
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public long getId() {
        return id;
    }

    public String getBand() {
        return band;
    }

    public String getTruckModel() {
        return truckModel;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", band='" + band + '\'' +
                ", model='" + truckModel + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", liftingCapacity=" + liftingCapacity +
                ", type='" + type + '\'' +
                ", company=" + company +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id &&
                liftingCapacity == truck.liftingCapacity &&
                Objects.equals(band, truck.band) &&
                Objects.equals(truckModel, truck.truckModel) &&
                Objects.equals(plateNumber, truck.plateNumber) &&
                Objects.equals(type, truck.type) &&
                Objects.equals(company, truck.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, band, truckModel, plateNumber, liftingCapacity, type, company);
    }
}
