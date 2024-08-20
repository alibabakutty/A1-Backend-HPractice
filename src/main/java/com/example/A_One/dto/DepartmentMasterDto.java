package com.example.A_One.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentMasterDto {

    @Column(name = "id")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;
}