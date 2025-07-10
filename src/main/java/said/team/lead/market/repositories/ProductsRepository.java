package said.team.lead.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import said.team.lead.market.models.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
