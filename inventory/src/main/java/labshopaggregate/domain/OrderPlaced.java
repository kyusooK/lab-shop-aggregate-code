package labshopaggregate.domain;

import java.util.*;
import labshopaggregate.domain.*;
import labshopaggregate.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private Date orderDate;
    private Object inventoryId;
    private Object orderStatus;
    private Object address;
    private Object orderItems;
}
