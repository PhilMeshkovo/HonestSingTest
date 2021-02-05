package spring.demo.HonestSingTest.service;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.demo.HonestSingTest.model.Order;
import spring.demo.HonestSingTest.model.Product;
import spring.demo.HonestSingTest.storage.OrderStorage;

import java.util.Arrays;
import java.util.Optional;

@Service
@Log4j2
public class OrderService {

    @Value("${product.code.length}")
    private int productCodeLen;

    public void postOrder(Order order) throws Exception {
        OrderStorage orderStorage = new OrderStorage();
        log.log(Level.INFO, "получаем любой экземпляр с нарушением кода");
        Optional<Product> unexepctedCode = Arrays.stream(order.getProducts()).filter(p -> p.getCode().length() != productCodeLen).findFirst();
        if (unexepctedCode.isPresent()) {
            throw new Exception("Код товара должен быть длиной 13 символов");
        } else {
            log.log(Level.INFO, "Пробуем сохранить заказ");
            orderStorage.save(order);
        }

    }
}
