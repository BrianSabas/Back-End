package com.porfolio.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "person" )
public class Person extends BaseEntity implements Serializable {
	
    private static final long serialVersionUID = 79835435686783L;

    private String name;
    private String surname;
    private String tel;
    private String aboutMe;
    private String email;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdUser", referencedColumnName = "id", nullable = false)
    private User user;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDomicile", referencedColumnName = "id", nullable = false)
    private Domicile domicile;
    
}