//package dtwg.mptc.ecommerce.order.persistence.entity;
//
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "products")
//public class ProductEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//    private String name;
//    private BigDecimal price;
//
//    private List<OrderItemEntity> items;
//
//    @OneToOne(mappedBy = "product")
//    private OrderItemEntity orderItem;
//}
