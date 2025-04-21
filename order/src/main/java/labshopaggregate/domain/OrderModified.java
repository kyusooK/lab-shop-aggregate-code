package labshopaggregate.domain;

import java.time.LocalDate;
import java.util.*;
import labshopaggregate.domain.*;
import labshopaggregate.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderModified extends AbstractEvent {

    private Long id;
    private String userId;
    private List<OrderItem> orderItems;
    private Date orderDate;
    private InventoryId inventoryId;
    private OrderStatus orderStatus;
    private Address address;

    public OrderModified(Order aggregate) {
        super(aggregate);
    }

    public OrderModified() {
        super();
    }
}
//>>> DDD / Domain Event
