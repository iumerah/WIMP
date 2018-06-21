package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("api/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;

	public MovieController() {
	}
	
	@GetMapping
	public List<Movie> getMovies() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

    @PostMapping
	public Movie createMovie(@RequestBody Movie movie) {

        //save movie to database
		Movie newMovie = movieRepository.save(movie);

        //take me back to the add page
		return newMovie;
	}

	@DeleteMapping("{id}")
	public Movie deleteMovie(@PathVariable int id) {

		//get the original movie from db
		Movie originalMovie = movieRepository.findOne(id);

        //delete movie to database
		movieRepository.delete(originalMovie);

        //take me back to the add page
		return originalMovie;
	}

	@GetMapping("{id}")
	public Movie getSpecificMovie(@PathVariable int id) {

		//get the original movie from db
		Movie movie = movieRepository.findOne(id);

        //take me back to the add page
		return movie;
	}
	
	@PostMapping("{movieId}/actors")
	public Movie create(@PathVariable int movieId, @RequestBody int actorId) {
		Movie movie = movieRepository.findOne(movieId);
		Actor actor = actorRepository.findOne(actorId);
		movie.getActors().add(actor);
		movieRepository.save(movie);
		return movie;
	}

	@PutMapping("{id}")
	public Movie getSpecificMovie(@PathVariable int id, @RequestBody Movie movie) {

        //set the id on the movie just sent in
		movie.setId(id);
         
		//get the original movie from db
		Movie updatedMovie = movieRepository.save(movie);

        //take me back to the add page
		return updatedMovie;
	}


}
