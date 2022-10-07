package com.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false) //NULLABLE DURUMLARIMI DEĞERLENDİR
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "discount", nullable = false)
    private Long discount;

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_CATEGORY_ID"))
    private Category category;

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "vendor_user_id", foreignKey = @ForeignKey(name = "FK_VENDOR_USER_ID"))
    private Client vendorClient;


}
