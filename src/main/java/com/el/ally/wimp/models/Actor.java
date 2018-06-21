package com.el.ally.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="actor")
public class Actor {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(max=75)
	@Column(nullable = false)
	private String firstName;
	
	@Size(max=75)
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private Long activeSinceYear;
	
	@Column(nullable = false)
	private Date birthDate; 
	
	@ManyToOne
	private Movie movie;
	
	@OneToMany
	private List<Award> awards;
	
	public Actor() {}
	
	public Actor(String firstName, String lastName, Long activeSinceYear, Date birthDate) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeSinceYear = activeSinceYear;
		this.birthDate = birthDate;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getActiveSinceYear() {
		return activeSinceYear;
	}

	public void setActiveSinceYear(Long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
