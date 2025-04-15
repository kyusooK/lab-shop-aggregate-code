package labshopaggregate.domain;

import java.util.*;
import labshopaggregate.domain.*;
import labshopaggregate.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer qty;
}
