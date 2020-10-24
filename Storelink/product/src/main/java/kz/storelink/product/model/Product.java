package kz.storelink.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;
    private String description;
    private String product;
    private String photo;
    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate = LocalDate.now();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    private double rate;
    private int count;

}
