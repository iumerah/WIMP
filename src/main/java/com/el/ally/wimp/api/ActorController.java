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
@RequestMapping("api/actors")
public class ActorController {//how to update
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MovieRepository movieRepository;

	public ActorController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@GetMapping
	public List<Actor> getActors() {
		List<Actor> actors = actorRepository.findAll();
		return actors;
	}

    @PostMapping
	public Actor createActor(@RequestBody Actor actor) {

        //save actor to database
		Actor newActor = actorRepository.save(actor);

        //take me back to the add page
		return newActor;
	}

	@DeleteMapping("{id}")
	public Actor deleteJoke(@PathVariable int id) {

		//get the original actor from db
		Actor originalActor = actorRepository.findOne(id);

        //delete actor from database
		actorRepository.delete(originalActor);

        //take me back to the add page
		return originalActor;
	}

	@GetMapping("{id}")
	public Actor getSpecificActor(@PathVariable int id) {

		//get the original actor from db
		Actor actor = actorRepository.findOne(id);

        //take me back to the add page
		return actor;
		
	}

	@PutMapping("{id}")
	public Actor getSpecificActor(@PathVariable int id, @RequestBody Actor actor) {

        //set the id on the actor just sent in
		actor.setId(id);
         
		//get the original actor from db
		Actor updatedActor = actorRepository.save(actor);

        //take me back to the add page
		return updatedActor;
	}
	
	@PostMapping("/{actorId}/movies")
	public Actor create(@PathVariable int actorId, @RequestBody int movieId) {
		Actor actor = actorRepository.findOne(actorId);
		Movie movie = movieRepository.findOne(movieId);
		actor.setMovie(movie);
		actorRepository.save(actor);
		return actor;
	}


}