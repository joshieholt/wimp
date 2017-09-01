
package com.libertymutual.goforcode.wimp.api;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.AwardRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/actors")
@Api(description="Use this to get and create actors and add awards to actors.")
public class ActorApiController {

    private ActorRepository actorRepo;
    private AwardRepository awardRepo;
    
    public ActorApiController(ActorRepository actorRepo, AwardRepository awardRepo) {
        this.actorRepo = actorRepo;
        this.awardRepo = awardRepo;
        
        actorRepo.save(new Actor("Marky", "Mark", 1994l, new Date(Date.parse("01/01/1970")), null, null));
        actorRepo.save(new Actor("Donnie", "Wahlberg", 1989l, new Date(Date.parse("01/01/1967")), null, null));
        actorRepo.save(new Actor("Keanu", "Reeves", 1992l, new Date(Date.parse("01/01/1972")), null, null));
        
    }
    
    @ApiOperation(value = "Get all of the actors")
    @GetMapping("")
    public List<Actor> getAll() {
        return actorRepo.findAll();
    }
    
    @ApiOperation(value="Get an actor by its Id")
    @GetMapping("{id}")
    public Actor getOne(@PathVariable long id) throws StuffNotFoundException {
        Actor actor = actorRepo.findOne(id);
        if (actor == null) {
            throw new StuffNotFoundException();
        }

        return actor;
    }
    
    @ApiOperation(value="Delete an actor by its Id")
    @DeleteMapping("{id}")
    public Actor deleteOne(@PathVariable long id) {
        try {
            Actor actor = actorRepo.findOne(id);
            actorRepo.delete(id);
            return actor;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }
    
    @ApiOperation(value="Create a new actor")
    @PostMapping("")
    public Actor createOne(@RequestBody Actor actor) {
        return actorRepo.save(actor);
    }
    
    @ApiOperation(value="Update an actor using its Id")
    @PutMapping("{id}")
    public Actor update(@RequestBody Actor actor, @PathVariable long id) {
        actor.setId(id);
        return actorRepo.save(actor);
    }
    
    @ApiOperation(value="Create an award and associate it with an actor using actor's Id")
    @PostMapping("{actorId}/awards")
    public Actor associateAnAward(@PathVariable long actorId, @RequestBody Award award) {
        Award newAward = new Award(award.getTitle(), award.getOrganization(), award.getYear());
        awardRepo.save(newAward);
        Actor actor = actorRepo.findOne(actorId);
        actor.addAward(newAward);
        actorRepo.save(actor);
        return actor;
    }
}
