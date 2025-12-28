package com.edvin.projects.bookstore.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LIBRARY_ITEM_COPY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class LibraryItemCopy implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Unique identifier for the item copy
	@Id
	@Column(name = "ITEM_COPY_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_COPY")
	@SequenceGenerator(name = "SEQ_ITEM_COPY", sequenceName = "SEQ_ITEM_COPY", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", nullable = false)
	private LibraryItem item; // Reference to the associated LibraryItem entity

	// Status of the item copy (e.g., available, checked out, reserved)
	@ManyToOne
	@JoinColumn(name = "ITEM_COPY_STATUS_ID", referencedColumnName = "ITEM_COPY_STATUS_ID")
	private ItemCopyStatus status;

	// Location of the item copy in the library
	@Column(name = "LOCATION", length = 100, nullable = false)
	private String location;
	
	 
	public Integer getCopyNumber() {
		return id;
	}
}
