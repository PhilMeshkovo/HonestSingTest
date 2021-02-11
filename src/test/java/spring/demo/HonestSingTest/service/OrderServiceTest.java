package spring.demo.HonestSingTest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.demo.HonestSingTest.model.Order;
import spring.demo.HonestSingTest.model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void postOrderTest() {
        Product product = new Product("milk", "1234567891234");
        Order order = new Order();
        order.setCustomer("123456789");
        order.setSeller("12345678");
        order.setProducts(new Product[]{product});
        try {
            orderService.postOrder(order);
        } catch (Exception e) {
            Assert.assertEquals("Длина id покупателя и продавца должна составлять 9 символов",
                    e.getMessage());
        }
    }
}
