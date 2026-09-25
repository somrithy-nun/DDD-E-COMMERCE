package dtwg.mptc.ecommerce.order.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(OrderItemIdEntity.class)
@Table(name = "order_items")
public class OrderItemEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
    @Id
    private Integer id;

    @Id
    @ManyToOne
    private OrderEntity order;

    private UUID productId;


    private  Integer quantity;
    private BigDecimal price;
    private  BigDecimal subTotal;


}
