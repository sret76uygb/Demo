package com.examples.movies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

import javax.persistence.Column;

@Entity
@NamedStoredProcedureQuery(name = "mov.getAllMovies",procedureName = "public.usp_temp",resultClasses = {MovieNamesEntity.class},
parameters = {
		@StoredProcedureParameter(mode= ParameterMode.REF_CURSOR,type=void.class),
		@StoredProcedureParameter(mode= ParameterMode.IN,type=String.class)
})
public class MovieNamesEntity {
	
	public MovieNamesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "MovieNamesEntity [id=" + id + ", type=" + type + ", name=" + name + "]";
	}


	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	

	

	
}
