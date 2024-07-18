package dev.canverse.workflow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "product_types")
@Entity
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
