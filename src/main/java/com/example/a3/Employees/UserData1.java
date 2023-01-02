package com.example.a3.Employees;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_data1")
public class UserData1 {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull

    @Column(name = "username",unique = true)
    private String username1;

    @NotNull
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name="emp_id")
    private Emp emp;

}
