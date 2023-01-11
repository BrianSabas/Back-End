package com.porfolio.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceLaboralDTO {
	private Long id;
    private String nombreEmpresa;
    private String trabajoActual;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
}
