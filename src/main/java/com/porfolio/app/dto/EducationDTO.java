package com.porfolio.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EducationDTO {
	private Long id;
	private String careerFinished;
	private String careerName;
	
	
	private String highSchoolFinished;
	
    @NotNull(message = "El campo Institución no puede ser nulo")
    @NotBlank(message = "El campo Institución no puede ser vacío")
    @Size(min=3, max=50, message = "Longitud aceptada de 3 a 50 caractéres")
    @Pattern(regexp="^[a-zA-Z0-9\\sÁáÉéÍíÓóÚúÑñÜü]+$", message = "Formato invalido para el campo Institución")
	private String highSchoolName;
}
