package com.edvin.projects.bookstore.entity.dao;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4690182142129759636L;
	
	private Integer id;
	private String code;
	private String name; 
	private String status; 

}
