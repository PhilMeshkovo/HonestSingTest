package spring.demo.HonestSingTest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.demo.HonestSingTest.annotations.LengthValid;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Order {
    @NotEmpty
//    @Size(min = 9, max = 9, message = "Размер id продавца должен быть 9 символов")
    @LengthValid
    private String seller;
    @NotEmpty
//    @Size(min = 9, max = 9, message = "Размер id покупателя должен быть 9 символов")
    @LengthValid
    private String customer;
    @Valid
    @NotEmpty
    private Product[] products;
}
