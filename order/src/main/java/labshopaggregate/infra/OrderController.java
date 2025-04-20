package labshopaggregate.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import labshopaggregate.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/orders/placeorder",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order placeOrder(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody PlaceOrderCommand placeOrderCommand
    ) throws Exception {
        System.out.println("##### /order/placeOrder  called #####");
        Order order = new Order();
        order.placeOrder(placeOrderCommand);
        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/modifyorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order modifyOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody ModifyOrderCommand modifyOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/modifyOrder  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.modifyOrder(modifyOrderCommand);

        orderRepository.save(order);
        return order;
    }
}
//>>> Clean Arch / Inbound Adaptor
