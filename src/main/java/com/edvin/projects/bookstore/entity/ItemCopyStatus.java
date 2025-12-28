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
@Table(name = "ITEM_COPY_STATUS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCopyStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_COPY_STATUS")
	@SequenceGenerator(name = "SEQ_ITEM_COPY_STATUS", allocationSize = 1, sequenceName = "SEQ_ITEM_COPY_STATUS")
	@Column(name = "ITEM_COPY_STATUS_ID")
	private Integer id;
	
	@Column(name = "STATUS_NAME")
	private String statusName;

}
