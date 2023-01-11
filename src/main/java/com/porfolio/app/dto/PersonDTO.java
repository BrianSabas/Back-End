package com.porfolio.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private String name;
    private String surname;
    private String tel;
    private String aboutMe;
    private String email;
    
    private String localidad;
    private String address;
}
