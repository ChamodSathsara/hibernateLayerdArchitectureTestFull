package lk.ijse.dto;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Order;

import javax.persistence.*;
import java.util.List;

public class CustomerDto {

    private int id;
    private String name;
    private String address;
    private Long telNumber;

    public CustomerDto() {

    }
    public CustomerDto(int id, String name, String address, Long telNumber) {
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

    public Customer toEntity(){
        Customer customerDto = new Customer();
        customerDto.setId(this.id);
        customerDto.setName(this.name);
        customerDto.setAddress(this.address);
        customerDto.setTelNumber(this.telNumber);

        return customerDto;
    }
}
