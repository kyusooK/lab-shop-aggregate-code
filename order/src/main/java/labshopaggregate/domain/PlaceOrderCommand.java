package labshopaggregate.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private String userId;
    private Integer qty;
    private InventoryId inventoryId;
    private Address address;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
}
