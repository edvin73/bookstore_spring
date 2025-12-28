package com.edvin.projects.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEDIA_TYPE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MediaType {
	
	@Id
	@Column(name = "MEDIA_TYPE_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDIA_TYPE")
	@SequenceGenerator(name = "SEQ_MEDIA_TYPE", sequenceName = "SEQ_MEDIA_TYPE", allocationSize = 1)
	private Integer mediaTypeId; // Unique identifier for the media type
	
	@Column(name = "MEDIA_TYPE", nullable = false, length = 50)
	private String mediaType; // Name of the media type (e.g., audio, video, etc.)
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description; // Description of the media type
}
