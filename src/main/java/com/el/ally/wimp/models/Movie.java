package com.el.ally.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="movie")
public class Movie {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=300)
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	@Column(nullable = false)
	private Long budget;
	
	@Size(max=500)
	@Column(nullable = false)
	private String distributor;

	
	@OneToMany
	private List<Actor> actors;

	
	
	
	public Movie() {}
	
	public Movie(String title, Date releaseDate, Long budget, String distributor) {
		
		this.title = title;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.distributor = distributor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
}
