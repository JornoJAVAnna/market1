package said.team.lead.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import said.team.lead.market.models.Order;
import said.team.lead.market.models.OrderItem;
import said.team.lead.market.repositories.OrderItemRepository;
import said.team.lead.market.repositories.OrdersRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    
    private final OrderItemRepository orderItemRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderService(OrderItemRepository orderItemRepository, OrdersRepository ordersRepository) {
        this.orderItemRepository = orderItemRepository;
        this.ordersRepository = ordersRepository;
    }

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public Optional<Order> findOne(int id) {
        return ordersRepository.findById(id);
    }

    public void createOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.calculateTotalPrice();
        ordersRepository.save(order);
    }

    public void updateOrder(int id, Order updatedOrder) {
        updatedOrder.setId(id);
        ordersRepository.save(updatedOrder);
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }


}
