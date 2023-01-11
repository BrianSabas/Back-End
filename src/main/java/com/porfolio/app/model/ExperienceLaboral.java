package com.porfolio.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "explaboral" )
public class ExperienceLaboral extends BaseEntity implements Serializable {
	
    private static final long serialVersionUID = 13722436764322L;

    private String nombreEmpresa;
    private String trabajoActual;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPerson", referencedColumnName = "id", nullable = false)
    private Person person;
    
}
