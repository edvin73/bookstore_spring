package com.edvin.projects.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "KEYWORD")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Keyword   {
	
	@Id
	@Column(name = "KEYWORD_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KEYWORD")
	@SequenceGenerator(name = "SEQ_KEYWORD", sequenceName = "SEQ_KEYWORD", allocationSize = 1)
	private Integer id; // Unique identifier for the keyword
	
	@Column(name = "KEYWORD", length = 50, nullable = false, unique = true)
	private String keyword; // The keyword itself
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private LibraryItem item; // The library item associated with this keyword

}
