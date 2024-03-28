package com.example.locationmanagementapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "`user`")
@Data
@NoArgsConstructor
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String password;
}
