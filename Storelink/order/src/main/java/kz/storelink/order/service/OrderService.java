package kz.storelink.order.service;

import kz.storelink.order.model.Order;
import kz.storelink.order.model.Product;
import kz.storelink.order.repository.OrderRepository;
import kz.storelink.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public Order getOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Not Found Order");
        }

        return orderRepository.findById(id).get();
    }

    public Order createOrder(Order order) {
        Order modelOrder = new Order();
        if (!userRepository.existsById(order.getUser().getId())) {
            throw new RuntimeException("Not Found User");
        }
        modelOrder.setUser(userRepository.findById(order.getUser().getId()).get());
        for (Product product : order.getProduct()) {
            Product existingProduct = restTemplate.getForObject("http://product-service/product/" + product.getId(), Product.class);
            modelOrder.getProduct().add(existingProduct);
        }

        return orderRepository.save(modelOrder);
    }

    public Order payOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Not Found Order");
        }
        Order order = orderRepository.findById(id).get();
        order.setPayedDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

}
