package com.el.ally.wimp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.ally.wimp.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
