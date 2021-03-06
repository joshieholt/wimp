
package com.libertymutual.goforcode.wimp.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/movies")
@Api(description="Use this to get and create movies and add actors to movies.")
public class MovieApiController {

    
    private MovieRepository movieRepo;
    private ActorRepository actorRepo;
    
    public MovieApiController(MovieRepository movieRepo, ActorRepository actorRepo) {
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(actorRepo.findOne((long) 1));
        actors.add(actorRepo.findOne((long) 2));
        
        movieRepo.save(new Movie("Wicked Boston, Kid", new Date(Date.parse("01/01/2000")), 100000000, "Warner Bros", actors));
        
        actors = new ArrayList<Actor>();
        actors.add(actorRepo.findOne((long) 3));
        
        movieRepo.save(new Movie("The Matrix", new Date(Date.parse("01/01/1999")), 45000, "MGM", actors));
        
    }
    
    @ApiOperation(value="Get all of the movies")
    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }
    
    @ApiOperation(value="Get a movie by its Id")
    @GetMapping("{id}")
    public Movie getOne(@PathVariable long id) throws StuffNotFoundException {
        
        Movie movie = movieRepo.findOne(id);
        
        if (movie == null) {
            throw new StuffNotFoundException();
        }
        
        return movie;
    }
    
    @ApiOperation(value="Delete a movie by its Id")
    @DeleteMapping("{id}")
    public Movie deleteOne(@PathVariable long id) {
        try {
            Movie movie = movieRepo.findOne(id);
            movieRepo.delete(id);
            return movie;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }
    
    @ApiOperation(value="Create a new movie")
    @PostMapping("")
    public Movie createOne(@RequestBody Movie movie) {
        return movieRepo.save(movie);
    }
    
    @ApiOperation(value="Update a movie using its Id")
    @PutMapping("{id}")
    public Movie update(@RequestBody Movie movie, @PathVariable long id) {
        movie.setId(id);
        return movieRepo.save(movie);
    }
    
    @ApiOperation(value="Associate an actor with a movie",
            notes="You only need to POST the \"id\" of the actor")
    @PostMapping("{movieId}/actors")
    public Movie associateAnActor(@PathVariable long movieId, @ApiParam(value="Only the id of this parameter is used", defaultValue="{ \"id\": 1 }")@RequestBody Actor actor) {
        actor = actorRepo.findOne(actor.getId());
        Movie movie = movieRepo.findOne(movieId);
        movie.addActor(actor);
        movieRepo.save(movie);
        return movie;
    }
}
