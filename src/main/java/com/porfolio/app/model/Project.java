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
@Table(name = "projects")
public class Project extends BaseEntity implements Serializable {
	
    private static final long serialVersionUID = 79835435686783L;

	private String projectName;
	private String aboutProject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerson", referencedColumnName = "id", nullable = false)
	private Person person;

}