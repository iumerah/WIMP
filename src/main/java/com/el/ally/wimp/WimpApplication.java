package com.el.ally.wimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;

@SpringBootApplication
public class WimpApplication {

	@Autowired
    private MovieRepository movieRepository;
	
	@Autowired
    private ActorRepository actorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WimpApplication.class, args);
	}
}
