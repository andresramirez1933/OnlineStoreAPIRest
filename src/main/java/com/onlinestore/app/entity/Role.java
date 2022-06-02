package com.onlinestore.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
