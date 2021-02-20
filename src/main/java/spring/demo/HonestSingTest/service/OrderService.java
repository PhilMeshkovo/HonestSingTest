package spring.demo.HonestSingTest.service;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Service;
import spring.demo.HonestSingTest.model.Order;
import spring.demo.HonestSingTest.storage.OrderStorage;

@Service
@Log4j2
public class OrderService {

    public void postOrder(Order order) {
        OrderStorage orderStorage = new OrderStorage();
        log.log(Level.INFO, "Пробуем сохранить заказ");
        orderStorage.save(order);
    }
}
