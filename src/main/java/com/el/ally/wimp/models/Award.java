package com.el.ally.wimp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="award")
public class Award {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=500)
	@Column(nullable = false)
	private String title;
	
	@Size(max=200)
	@Column(nullable=false)
	private String organization;
	
	private int year;
	
	@ManyToOne
	private Actor actor;
	
	public Award() {}
	
	public Award(String title, String organization, int year) {
		this.title = title;
		this.organization = organization;
		this.year = year;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
}
