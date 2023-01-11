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
@Table(name = "technologies")
public class Technology extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1786867867867L;

	private String name;
	
	private String porcentaje;
	
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPerson", referencedColumnName = "id", nullable = false)
    private Person person;  

}
