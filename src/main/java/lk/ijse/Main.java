package lk.ijse;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.OrderDetailDto;
import lk.ijse.dto.OrderDto;
import lk.ijse.embadded.OrderDetailsPK;
import lk.ijse.service.CustomerService;
import lk.ijse.service.ItemService;
import lk.ijse.service.OrderDetailService;
import lk.ijse.service.OrderService;
import lk.ijse.service.impl.CustomerServiceImpl;
import lk.ijse.service.impl.ItemServiceImpl;
import lk.ijse.service.impl.OrderDetailServiceImpl;
import lk.ijse.service.impl.OrderServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        CustomerDto customer = new CustomerDto(003,"amal","colombo",014523124l);
//        CustomerService service = CustomerServiceImpl.getInstance();
//        int isSave = service.saveCustomer(customer);
//        System.out.println(isSave);
//
//        OrderDto order = new OrderDto(003,"Food Order",customer.toEntity());
//        OrderService orderService = OrderServiceImpl.getInstance();
//        int isSaveOrder = orderService.saveOrder(order);
//        System.out.println(isSaveOrder);

//        ItemDto item = new ItemDto(001,"soup",250,10);
//        ItemService itemService = ItemServiceImpl.getInstance();
//        int isSaveItem = itemService.saveItem(item);
//        System.out.println(isSaveItem);

//        OrderDetailsPK orderDetailsPK = new OrderDetailsPK(order.toEntity().getoId(),item.toEntity().getiId());
//
//
//        OrderDetailDto orderDetail = new OrderDetailDto(orderDetailsPK,"Gaming badu");
//        OrderDetailService orderDetailService = OrderDetailServiceImpl.getInstance();
//        int isSaveOrderDetail = orderDetailService.saveOrderDetail(orderDetail);

        //update();
        //getObject();
        getAll();

    }

    private static void getAll() {
        CustomerService customerService = CustomerServiceImpl.getInstance();
        List<CustomerDto> customerList = new ArrayList<>();
        customerList = customerService.getAllCustomer();

        System.out.println(customerList);

//        System.out.println("Huttoooo");
//        int size = customerList.size();
//        System.out.println("ai meeeee");
//        System.out.println(customerList.size());
//        System.out.println("ai meeeee");
//        try {
//          for (CustomerDto customer : customerList){
//                System.out.println(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

    private static void getObject() {
        CustomerService customerService = CustomerServiceImpl.getInstance();
        CustomerDto customerDto = customerService.getCustomer(01);
        System.out.println(customerDto);
    }

    private static void update() {
        CustomerDto customer = new CustomerDto(00,"amal","colombo",014523124l);
//        CustomerService customerService = CustomerServiceImpl.getInstance();
//        boolean isUpdate = customerService.updateCustomer(customer);
//        System.out.println(isUpdate);

        OrderDto order = new OrderDto(01,"cake badu",customer.toEntity());
//        OrderService orderService = OrderServiceImpl.getInstance();
//        boolean isUpdate = orderService.updateOrder(order);

        ItemDto item = new ItemDto(01,"Maduru_koil",100,250);
//        ItemService itemService = ItemServiceImpl.getInstance();
//        boolean isUpdate = itemService.updateItem(item);

        OrderDetailsPK orderDetailsPK = new OrderDetailsPK(order.toEntity().getoId(),item.toEntity().getiId());

        OrderDetailDto orderDetail = new OrderDetailDto(orderDetailsPK,"Kamantha pupmantha");
        OrderDetailService orderDetailService = OrderDetailServiceImpl.getInstance();
        boolean isUpdate = orderDetailService.updateOrderDetail(orderDetail);
    }
}