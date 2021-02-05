package spring.demo.HonestSingTest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.HonestSingTest.model.Order;
import spring.demo.HonestSingTest.service.OrderService;
import spring.demo.HonestSingTest.validations.ResponseErrorValidation;

import javax.validation.Valid;

@RestController
@Log4j2
public class MainController {

    private final OrderService orderService;

    @Autowired
    private ResponseErrorValidation responseErrorValidation;


    @Autowired
    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> postOrder(@Valid @RequestBody Order order,
                                       BindingResult bindingResult) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);

        if (!ObjectUtils.isEmpty(errors)) return errors;

        try {
            orderService.postOrder(order);
            return new ResponseEntity("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}
