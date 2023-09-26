package com.examples.movies.pojos;

import java.util.Objects;

import javax.persistence.Column;

public class MovieNamesResponse {
	
	private String id;

	private String type;
	

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieNamesResponse other = (MovieNamesResponse) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "MovieNamesResponse [id=" + id + ", type=" + type + "]";
	}

	public MovieNamesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

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

}
