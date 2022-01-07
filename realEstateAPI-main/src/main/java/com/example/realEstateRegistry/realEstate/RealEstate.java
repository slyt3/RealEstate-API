package com.example.realEstateRegistry.realEstate;

import javax.persistence.*;

@Entity
@Table
public class RealEstate {
    @Id
    @SequenceGenerator(
            name = "realestate_sequence",
            sequenceName = "realeastate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "realestate_sequence"
    )

    private Long id;
    private String city;
    private String street;
    private Integer number;
    private String owner;
    private Long size;
    private Double marketValue;
    private String propertyType;
    private Double tax;
    @Transient
    private Double calculatedTaxes;


    public RealEstate() {
    }

    public RealEstate(Long id, String city, String street, Integer number, String owner, Long size, Double marketValue, String propertyType, Double tax) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
        this.owner = owner;
        this.size = size;
        this.marketValue = marketValue;
        this.propertyType = propertyType;
        this.tax = tax;
    }

    public RealEstate(String city, String street, Integer number, String owner, Long size, Double marketValue, String propertyType, Double tax) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.owner = owner;
        this.size = size;
        this.marketValue = marketValue;
        this.propertyType = propertyType;
        this.tax = tax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getCalculatedTaxes() {
        return tax * marketValue;
    }

    public void setCalculatedTaxes(Double calculatedTaxes) {
        this.calculatedTaxes = calculatedTaxes;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", owner='" + owner + '\'' +
                ", size=" + size +
                ", marketValue=" + marketValue +
                ", propertyType='" + propertyType + '\'' +
                ", tax=" + tax +
                '}';
    }

}
