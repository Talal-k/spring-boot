package com.example.a3.Employees;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestEmpReturn {

    String name;
    String email;

    private Long salary;
}
