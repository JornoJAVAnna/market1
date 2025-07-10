package said.team.lead.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderService {
    private final OrderService orderService;

    @Autowired
    public OrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    
}
