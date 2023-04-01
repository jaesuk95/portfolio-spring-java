package com.portfolio.domain.model.product;

import com.portfolio.domain.model.material.Material;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String modelName;
    private int price;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_ID")
    protected Material material;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private ProductCategory productCategory;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;

    }

    public void setModelName(Long id) {
        // model 이름 딱히 생각안남,
        String m_name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        this.modelName = m_name + id;
    }
}
