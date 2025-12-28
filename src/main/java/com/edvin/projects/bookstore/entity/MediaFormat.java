package com.edvin.projects.bookstore.entity;

import java.util.List;

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
@Table(name = "MEDIA_FORMAT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MediaFormat  {
	
	@Id
	@Column(name = "FORMAT_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDIA_FORMAT")
	@SequenceGenerator(name = "SEQ_MEDIA_FORMAT", sequenceName = "SEQ_MEDIA_FORMAT", allocationSize = 1)
	private Integer formatId;
	
	@Column(name = "FORMAT_CODE", nullable = false, unique = true, length = 20)
	private String formatCode; // e.g., "HARDCOVER", "PAPERBACK", "EBOOK", "AUDIOBOOK"
	
	@Column(name = "FORMAT_NAME", nullable = false, length = 100)
	private String formatName;


}
