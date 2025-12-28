package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book  extends LibraryItem  {	 
	 
	@Id
	@Column(name = "ITEM_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK")
	@SequenceGenerator(name = "SEQ_BOOK", sequenceName = "SEQ_BOOK", allocationSize = 1)
	private Integer itemId; // Unique identifier
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Column(length = 500)
	private String description;
	
	@OneToMany(mappedBy = "item")
	private List<Keyword> keywords;
	
	@Column(name = "ISBN", nullable = false, unique = true) 
	private String isbn; // International Standard Book Number	
		
	@Column(name = "CLASSIFICATION_UDC", length = 20)
	private String classificationUDC; // Universal Decimal Classification;
	
	@Column(name = "PUBLICATION_DATE", nullable = true)
	private LocalDate publicationDate;
	
	
	@Column(name = "PUBLICATION_YEAR", nullable = true)
	private Integer publicationYear; // Publication year, if available
	
	@Column(name = "NUMBER_OF_COPIES", nullable = false)
	private Integer numberOfCopies; // Number of copies available in the library
	
	@ManyToMany
	@JoinTable(name = "BOOK_AUTHOR", 
		joinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID"), 
		inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", 
		referencedColumnName = "AUTHOR_ID"))
	private List<Author> authors;
 
	
	@Column(name = "PAGE_COUNT", nullable = false)
	private Integer  pageCount;
	 
	
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LibraryItemCopy> copies;
	 
	@ManyToOne
	@JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "PUBLISHER_ID")
	private Publisher publisher;

	
 
}
