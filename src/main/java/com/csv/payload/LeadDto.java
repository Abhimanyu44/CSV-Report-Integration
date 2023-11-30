package com.csv.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDto {

    private String lid;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;
    private String address;
    private String company;
    private String designation;
    private String leadType;
    private String note;

}
