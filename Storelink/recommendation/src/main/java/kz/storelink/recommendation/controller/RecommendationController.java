package kz.storelink.recommendation.controller;

import kz.storelink.recommendation.model.Product;
import kz.storelink.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public ResponseEntity<List<Product>> getRecommendation() {
        return new ResponseEntity<>(recommendationService.getRecommendation(), HttpStatus.OK);
    }

}
