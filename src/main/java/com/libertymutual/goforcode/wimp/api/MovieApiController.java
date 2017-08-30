
package com.libertymutual.goforcode.wimp.api;

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

@RestController
@RequestMapping("/api/movies")
public class MovieApiController {

    
    private MovieRepository movieRepo;
    
    private ActorRepository actorRepo;
    
    public MovieApiController(MovieRepository movieRepo, ActorRepository actorRepo) {
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(actorRepo.findOne((long) 1));
        actors.add(actorRepo.findOne((long) 2));
        
        movieRepo.save(new Movie("Wicked Boston, Kid", 100000000, "Warner Bros", actors));
        
        actors = new ArrayList<Actor>();
        actors.add(actorRepo.findOne((long) 3));
        
        movieRepo.save(new Movie("The Matrix", 45000, "MGM", actors));
        
    }
    
    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Movie getOne(@PathVariable long id) throws StuffNotFoundException {
        
        Movie movie = movieRepo.findOne(id);
        
        if (movie == null) {
            throw new StuffNotFoundException();
        }
        
        return movie;
    }
    
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
    
    @PostMapping("")
    public Movie createOne(@RequestBody Movie movie) {
        return movieRepo.save(movie);
    }
    
    @PutMapping("{id}")
    public Movie update(@RequestBody Movie movie, @PathVariable long id) {
        movie.setId(id);
        return movieRepo.save(movie);
    }
    
    @PostMapping("{movieId}/actors")
    public Movie associateAnActor(@PathVariable long movieId, @RequestBody Actor actor) {
        actor = actorRepo.findOne(actor.getId());
        Movie movie = movieRepo.findOne(movieId);
        movie.addActor(actor);
        movieRepo.save(movie);
        return movie;
    }
}
