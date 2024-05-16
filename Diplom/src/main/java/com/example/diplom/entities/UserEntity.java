package com.example.diplom.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int pass_series;
    private int pass_id;
    private String email;
    private String password;
    private ERole role = ERole.USER_ROLE;
    @OneToMany(mappedBy = "owner")
    private List<DealEntity> deals;
}
