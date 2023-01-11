package com.porfolio.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
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
@Table(name = "domicile")
public class Domicile extends BaseEntity implements Serializable {
	
    private static final long serialVersionUID = 67432486764322L;
       
   private String localidad;
   private String address;
   
}