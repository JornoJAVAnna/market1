package said.team.lead.market.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "orders")
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "total_price")
    private double totalPrice;

    public void calculateTotalPrice() {
        this.totalPrice = orderItems.stream()
                .mapToDouble(oi -> oi.getProduct().getPrice() * oi.getQuantity())
                .sum();
    }

    public Order( LocalDateTime createdAt, double totalPrice) {
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
    }
}
