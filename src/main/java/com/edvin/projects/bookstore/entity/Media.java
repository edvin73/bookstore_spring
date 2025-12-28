package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "MEDIA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Media extends LibraryItem   { 	 
	 
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
	 
	@Column(name = "MEDIA_CODE", nullable = false, unique = true)
	private String mediaCode; // Unique code for the media item
	
	@ManyToOne
	@JoinColumn(name = "MEDIA_TYPE_ID", referencedColumnName = "MEDIA_TYPE_ID", nullable = false)
	private MediaType mediaType; // Type of media (e.g., audio, video, etc.)
	
	@ManyToOne
	@JoinColumn(name = "MEDIA_FORMAT_ID", referencedColumnName = "FORMAT_ID", nullable = false)
	private MediaFormat format; // Format of the media (e.g., MP3, MP4, etc.)
 

}
