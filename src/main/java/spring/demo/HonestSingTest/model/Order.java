package spring.demo.HonestSingTest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import spring.demo.HonestSingTest.annotations.LengthValid;

@Data
@NoArgsConstructor
public class Order {
    @NonNull
//    @Size(min = 9, max = 9, message = "Размер id продавца должен быть 9 символов")
    @LengthValid
    private String seller;
    @NonNull
//    @Size(min = 9, max = 9, message = "Размер id покупателя должен быть 9 символов")
    @LengthValid
    private String customer;
    @NonNull
    private Product[] products;
}
