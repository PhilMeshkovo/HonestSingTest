package spring.demo.HonestSingTest.storage;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import spring.demo.HonestSingTest.model.Order;

import java.util.ArrayList;
import java.util.List;

@Data
@Log4j2
public class OrderStorage {
    private List<Order> orderList = new ArrayList<>();

    public void save(Order order) {
        orderList.add(order);
        log.log(Level.INFO, "Сохранено удачно");
    }

}
