package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Award;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("api/awards")
public class AwardController {//how to update
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private AwardRepository awardRepository;

	public AwardController(AwardRepository awardRepository) {
		this.awardRepository = awardRepository;
	}
	
	@GetMapping
	public List<Award> getAwards() {
		List<Award> awards = awardRepository.findAll();
		return awards;
	}

    @PostMapping
	public Award createAward(@RequestBody Award award) {

        //save award to database
		Award newAward = awardRepository.save(award);

        //take me back to the add page
		return newAward;
	}

	@DeleteMapping("{id}")
	public Award deleteJoke(@PathVariable int id) {

		//get the original award from db
		Award originalAward = awardRepository.findOne(id);

        //delete award from database
		awardRepository.delete(originalAward);

        //take me back to the add page
		return originalAward;
	}

	@GetMapping("{id}")
	public Award getSpecificAward(@PathVariable int id) {

		//get the original award from db
		Award award = awardRepository.findOne(id);

        //take me back to the add page
		return award;
		
	}

	@PutMapping("{id}")
	public Award getSpecificAward(@PathVariable int id, @RequestBody Award award) {

        //set the id on the award just sent in
		award.setId(id);
         
		//get the original award from db
		Award updatedAward = awardRepository.save(award);

        //take me back to the add page
		return updatedAward;
	}
	
	@PostMapping("/{awardId}/actors")
	public Award create(@PathVariable int awardId, @RequestBody int actorId) {
		Award award = awardRepository.findOne(awardId);
		Actor actor = actorRepository.findOne(actorId);
		award.setActor(actor);
		awardRepository.save(award);
		return award;
	}


}
