package com.edvin.projects.bookstore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PUBLISHER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLISHER")
	@SequenceGenerator(name = "SEQ_PUBLISHER", sequenceName = "SEQ_PUBLISHER", allocationSize = 1)
	@Column(name = "PUBLISHER_ID", nullable = false, unique = true)
	private Integer id;

	
	@Column(nullable = false, unique = true)
    private String name;

    @Column(length = 100)
    private String address;
    
    @Column(length = 100)
    private String city;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    @Column(name="CONTACT_EMAIL", length = 100, nullable = true)
    private String contactEmail;

    @Column(name="CONTACT_PHONE", length = 20, nullable = true)
    private String contactPhone;
 

    @Column(name = "active")
    private boolean active;


}
