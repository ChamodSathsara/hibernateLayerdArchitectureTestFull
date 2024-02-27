package lk.ijse.dto;

import lk.ijse.entity.Item;

public class ItemDto {
    private int iId;
    private String name;
    private int price;
    private int qty;

    public ItemDto() {
    }

    //All Args Constructor
    public ItemDto(int iId, String name, int price, int qty) {
        this.iId = iId;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    //Getters & Setters

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    //To string method

    @Override
    public String toString() {
        return "Item{" +
                "iId=" + iId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
    public Item toEntity(){
        Item itemdto = new Item();
        itemdto.setiId(this.iId);
        itemdto.setName(this.name);
        itemdto.setPrice(this.price);
        itemdto.setQty(this.qty);

        return itemdto;
    }
}
