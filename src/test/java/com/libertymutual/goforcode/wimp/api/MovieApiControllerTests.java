
package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

public class MovieApiControllerTests {

    private MovieRepository movieRepo;
    private ActorRepository actorRepo;
    private MovieApiController controller;
    
    @Before
    public void setUp() {
        movieRepo = mock(MovieRepository.class);
        actorRepo = mock(ActorRepository.class);
        controller = new MovieApiController(movieRepo, actorRepo);
    }
    
    @Test
    public void test_getAll_returns_all_Movies_returned_by_the_repo() {
        // Arrange
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie());
        movies.add(new Movie());
        
        when(movieRepo.findAll()).thenReturn(movies);
        
        // Act
        List<Movie> actual = controller.getAll();
        
        // Assert
        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(0)).isSameAs(movies.get(0));
        verify(movieRepo).findAll();
    }

    @Test
    public void test_getOne_returns_one_Movie_returned_by_the_repo() throws StuffNotFoundException {
        // Arrange
        Movie movie = new Movie();
        when(movieRepo.findOne(1l)).thenReturn(movie);
        
        // Act
        Movie actual = controller.getOne(1l);
        
        // Assert
        assertThat(actual).isSameAs(movie);
        verify(movieRepo).findOne(1l);
    }
    
    @Test
    public void test_getOne_throws_StuffNotFoundException_when_no_Movie_returned_from_repo() {
        try {
            controller.getOne(1l);
            fail("The controller did not throw the StuffNotFoundException");
        } catch(StuffNotFoundException snfe) {}
    }
    
    @Test
    public void test_delete_returns_movie_deleted_when_found() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepo.findOne(1l)).thenReturn(movie);
        
        // Act
        Movie actual = controller.deleteOne(1l);
        
        // Assert
        assertThat(actual).isSameAs(movie);
        verify(movieRepo).delete(1l);
        verify(movieRepo).findOne(1l);
    }
    
    @Test
    public void test_that_null_is_returned_when_findOne_throws_EmptyResultDataAccess() throws StuffNotFoundException {
        // Arrange
        when(movieRepo.findOne(1l)).thenThrow(new EmptyResultDataAccessException(0));
        
        // Act
        Movie actual = controller.deleteOne(1l);
        
        // Assert
        assertThat(actual).isNull();
        verify(movieRepo).findOne(1l);
    }
    
    @Test
    public void test_that_new_movie_is_created_when_createOne_is_called() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepo.save(movie)).thenReturn(movie);
        
        // Act
        Movie actual = controller.createOne(movie);
        
        // Assert
        assertThat(actual).isSameAs(movie);
        verify(movieRepo).save(movie);
    }
    
    @Test
    public void test_that_movie_is_updated_when_update_is_called() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepo.save(movie)).thenReturn(movie);
        
        // Act
        Movie actual = controller.update(movie, 3l);
        
        // Assert
        assertThat(actual.getId()).isEqualTo(3l);
        verify(movieRepo).save(movie);
    }
    
    @Test
    public void test_that_actor_is_associated_with_the_movie_when_associateAnActor_is_called() {
        // Arrange
        Movie movie = new Movie();
        Actor actor = new Actor();
        when(movieRepo.findOne(1l)).thenReturn(movie);
        when(actorRepo.findOne(2l)).thenReturn(actor);
        
        // Act
        Actor actualActor = actorRepo.findOne(2l);
        Movie actualMovie = controller.associateAnActor(1l, actualActor);
        
        // Assert
        assertThat(actualMovie).isSameAs(movie);
        assertThat(actualActor).isSameAs(actor);
        verify(movieRepo).save(movie);
    }
}
