package said.team.lead.market.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock_quantity")
    private Integer stock_quantity;

    public Product(String title, String description, double price, int stock_quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }
}
