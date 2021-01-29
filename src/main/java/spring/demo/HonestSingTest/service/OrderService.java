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

    @Value("${seller.customer.id.length}")
    private int sellerCustomerIdLen;

    @Value("${product.code.length}")
    private int productCodeLen;

    public void postOrder(Order order) throws Exception {
        OrderStorage orderStorage = new OrderStorage();
        if (order.getSeller().length() != sellerCustomerIdLen) {
            throw new Exception("Идентификатор продавца должен быть длиной 9 символов");
        } else if (order.getCustomer().length() != sellerCustomerIdLen) {
            throw new Exception("Идентификатор покупателя должен быть длиной 9 символов");
        } else {
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
}
