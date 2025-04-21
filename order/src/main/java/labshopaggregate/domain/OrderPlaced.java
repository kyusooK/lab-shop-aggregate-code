package labshopaggregate.domain;

import java.time.LocalDate;
import java.util.*;
import labshopaggregate.domain.*;
import labshopaggregate.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private Date orderDate;
    private InventoryId inventoryId;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItem> orderItems;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
