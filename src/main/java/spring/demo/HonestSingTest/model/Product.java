package spring.demo.HonestSingTest.model;


import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    @NonNull
    private String name;
    @NonNull
    private String code;
}
