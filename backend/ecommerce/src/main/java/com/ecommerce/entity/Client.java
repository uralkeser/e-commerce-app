package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client { //userType??, product ile ilişkisi ne olucak??

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false) //NULLABLE DURUMLARIMI DEĞERLENDİR
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
}
