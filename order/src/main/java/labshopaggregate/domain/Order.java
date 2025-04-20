package labshopaggregate.domain;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import labshopaggregate.OrderApplication;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Integer qty;

    @Embedded
    private InventoryId inventoryId;

    @Embedded
    private Address address;

    @ElementCollection
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void placeOrder(PlaceOrderCommand placeOrderCommand) {
        // Set order details from command
        this.userId = placeOrderCommand.getUserId();
        this.qty = placeOrderCommand.getQty();
        this.inventoryId = placeOrderCommand.getInventoryId();
        this.address = placeOrderCommand.getAddress();
        this.orderItems = placeOrderCommand.getOrderItems();
        this.orderStatus = placeOrderCommand.getOrderStatus();
    
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void modifyOrder(ModifyOrderCommand modifyOrderCommand) {
        repository().findById(this.getId()).ifPresent(order -> {
            // ModifyOrderCommand에서 전달받은 orderItems가 null이 아닌 경우에만 처리
            if (modifyOrderCommand.getOrderItems() != null) {
                // 기존 orderItems를 새로운 orderItems로 교체
                order.orderItems = new ArrayList<>(modifyOrderCommand.getOrderItems());
            }
            repository().save(order);
        });

        OrderModified orderModified = new OrderModified(this);
        orderModified.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
