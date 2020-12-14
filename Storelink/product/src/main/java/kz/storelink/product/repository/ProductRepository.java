package kz.storelink.product.repository;

import kz.storelink.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> getAll();

    @Query(value = "SELECT * FROM product p, storage s where p.id=s.product_id", nativeQuery = true)
    List<Product, Storage> getAllProducts();

    @Query(value = "SELECT * FROM storage", nativeQuery = true)
    List<Storage> getAllProducts();

    @Query(value = "SELECT * FROM recommendation", nativeQuery = true)
    List<Recommendation> getAllRecommendation();

    @Query(value = "SELECT * FROM storage s, user u where u.id=storage.user_id", nativeQuery = true)
    List<Storage, User> getAllStorage();

    List<Product> findByNameContaining(String name);

}
