package com.globant.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="stats")
public class Stats implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
    @Field("id")
	private Long id;
	private Double count_successful_escape;
	private Double count_unsuccessful_escape;
	private Double ratio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCount_successful_escape() {
		return count_successful_escape;
	}
	public void setCount_successful_escape(Double count_successful_escape) {
		this.count_successful_escape = count_successful_escape;
	}
	public Double getCount_unsuccessful_escape() {
		return count_unsuccessful_escape;
	}
	public void setCount_unsuccessful_escape(Double count_unsuccessful_escape) {
		this.count_unsuccessful_escape = count_unsuccessful_escape;
	}
	public Double getRatio() {
		return ratio;
	}
	public void setRatio() {
		this.ratio =count_successful_escape/count_unsuccessful_escape;
	}


	
}
