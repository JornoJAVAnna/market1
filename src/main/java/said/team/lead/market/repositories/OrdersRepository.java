package said.team.lead.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import said.team.lead.market.models.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
