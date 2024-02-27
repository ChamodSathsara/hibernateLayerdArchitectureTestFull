package lk.ijse.entity;

import lk.ijse.dto.CustomerDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    //attributes (instance variables)
    @Id
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_mob_number")
    private Long telNumber;

    //Order RelationShip Generate
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "customer")
    private List<Order> orderList;

    //No args Constructor
    public Customer() {
    }

    //All args Constructor
    public Customer(int id, String name, String address, Long telNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    //ToString method
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telNumber=" + telNumber +
                '}';
    }
    public CustomerDto ToClass(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(this.id);
        customerDto.setAddress(this.address);
        customerDto.setName(this.name);
        customerDto.setTelNumber(this.telNumber);

        return customerDto;
    }
}
