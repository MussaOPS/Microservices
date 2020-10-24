package kz.storelink.order.controller;

import kz.storelink.order.model.Order;
import kz.storelink.order.repository.OrderRepository;
import kz.storelink.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @GetMapping("/order/list")
    public ResponseEntity<List<Order>> getMovie() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createMovie(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/order/pay/{id}")
    public ResponseEntity<Order> createMovie(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.payOrder(id), HttpStatus.OK);
    }

}
