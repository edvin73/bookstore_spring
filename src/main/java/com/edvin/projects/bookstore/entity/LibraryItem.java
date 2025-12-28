package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
   
@Entity
@Table(name = "LIBRARY_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryItem implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2022435310235907342L;
	 
	@Id
	@Column(name = "ITEM_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIBRARY_ITEM")
	@SequenceGenerator(name = "SEQ_LIBRARY_ITEM", sequenceName = "SEQ_LIBRARY_ITEM", allocationSize = 1)
	private Integer itemId; // Unique identifier
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_TYPE_ID", referencedColumnName = "TYPE_ID", nullable = false)
	private LibraryItemType itemType;
	
	@OneToMany(mappedBy = "item")
	private List<Keyword> keywords;
	
	@Column(name = "ISBN", nullable = true) 
	private String isbn; // International Standard Book Number	
		
	@Column(name = "CLASSIFICATION_UDC", length = 20, nullable = true)
	private String classificationUDC; // Universal Decimal Classification;
	
	@Column(name = "PUBLICATION_DATE", nullable = true)
	private LocalDate publicationDate;
	
	
	@Column(name = "PUBLICATION_YEAR", nullable = true)
	private Integer publicationYear; // Publication year, if available
	
	@Column(name = "NUMBER_OF_COPIES", nullable = false)
	private Integer numberOfCopies; // Number of copies available in the library
	
	@Column(name = "MEDIA_CODE", nullable = true)
	private String mediaCode; // Unique code for the media item
	
	@ManyToOne
	@JoinColumn(name = "MEDIA_TYPE_ID", referencedColumnName = "MEDIA_TYPE_ID", nullable = true)
	private MediaType mediaType; // Type of media (e.g., audio, video, etc.)
	
	@ManyToOne
	@JoinColumn(name = "MEDIA_FORMAT_ID", referencedColumnName = "FORMAT_ID", nullable = true)
	private MediaFormat format; // Format of the media (e.g., MP3, MP4, etc.)
	
	@ManyToMany
	@JoinTable(name = "ITEM_AUTHOR", 
		joinColumns = @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID"), 
		inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", 
		referencedColumnName = "AUTHOR_ID"))
	private List<Author> authors;
 
	
	@Column(name = "PAGE_COUNT", nullable = true)
	private Integer  pageCount;
	  
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LibraryItemCopy> copies;
	 
	@ManyToOne
	@JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "PUBLISHER_ID")
	private Publisher publisher;
	
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT", nullable = true)
	private LocalDateTime updatedAt;
}
