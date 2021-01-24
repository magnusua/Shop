package com.restapp.shop.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")

@Getter
@Setter
@NonNull
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}

/*
get/set/hashCode/equals методов можно заюзать lombok
 */
