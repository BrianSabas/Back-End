package com.porfolio.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegiserUserDTO {
	private String username;
	private String password;
	
    private String name;
    private String surname;
    private String tel;
    private String aboutMe;
    private String email;
    
    private String localidad;
    private String address;
}
