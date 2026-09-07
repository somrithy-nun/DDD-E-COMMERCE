package dtwg.mptc.ecommerce.domain.entity;

import dtwg.mptc.ecommerce.domain.valueobject.Money;
import dtwg.mptc.ecommerce.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {

    private  final ProductId productId;
    private  final Money price;

    public ProductId getProductId() {
        return productId;
    }

    public Money getPrice() {
        return price;
    }

    private Product(Builder builder) {
        super.setId(builder.id);
        productId = builder.productId;
        price = builder.price;
    }

    public static final class Builder {
        private ProductId id;
        private ProductId productId;
        private Money price;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ProductId val) {
            id = val;
            return this;
        }

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
