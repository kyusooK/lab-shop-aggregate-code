package labshopaggregate.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private String userId;
    private Date orderDate;
    private InventoryId inventoryId;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItem> orderItems;
}
