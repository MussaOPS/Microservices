package kz.storelink.recommendation.service;

import kz.storelink.recommendation.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RestTemplate restTemplate;

    public List<Product> getRecommendation() {

        ResponseEntity<List<Product>> recommendations =
                restTemplate.exchange("http://product-service/product/recommendations",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
                        });
        List<Product> productRecommendations = recommendations.getBody();

        return productRecommendations;

    }

}
