package spring.demo.HonestSingTest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Order {
    @NonNull
    private String seller;
    @NonNull
    private String customer;
    @NonNull
    private Product[] products;
}
