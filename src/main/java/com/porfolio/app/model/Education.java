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
@Table(name = "education")
public class Education extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 324324324322L;
    
    private String careerFinished;
	private String careerName;
    private String highSchoolFinished;
    private String highSchoolName;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPerson", referencedColumnName = "id", nullable = false)
    private Person person;   
    
}
