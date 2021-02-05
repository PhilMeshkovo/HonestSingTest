package spring.demo.HonestSingTest.model;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
public class Product {
    @NonNull
    private String name;
    @NonNull
    @Size(min = 13, max = 13)
    private String code;
}
