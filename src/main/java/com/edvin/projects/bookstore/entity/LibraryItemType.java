package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "LIBRARY_ITEM_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryItemType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3382054217977907616L;
	
	@Id
	@Column(name = "TYPE_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIBRARY_ITEM_TYPE")
	@SequenceGenerator(name = "SEQ_LIBRARY_ITEM_TYPE", sequenceName = "SEQ_LIBRARY_ITEM_TYPE", allocationSize = 1)
	private Integer typeId;
	
	@Column(name = "TYPE_NAME", nullable = false, unique = true, length = 50)
	private String typeName;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;

}
