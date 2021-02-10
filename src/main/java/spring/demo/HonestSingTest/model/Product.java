package spring.demo.HonestSingTest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import spring.demo.HonestSingTest.annotations.CodeLengthValid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty
    private String name;
    @NotEmpty
//    @Size(min = 13, max = 13)
    @CodeLengthValid
    private String code;

}
