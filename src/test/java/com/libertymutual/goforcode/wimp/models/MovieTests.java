
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MovieTests {

    private Movie movie;
    private List<Actor> actors;
    
    @Before
    public void setUp() {
        actors = new ArrayList<Actor>();
        actors.add(new Actor());
        actors.add(new Actor());
        movie = new Movie("Title", new Date(Date.parse("01/01/2000")), 1000000, "Warner Bros", actors); 
    }
    
    @Test
    public void test_that_getTitle_returns_title_of_movie() {
        // Arrange
        
        // Act
        String title = movie.getTitle();
        
        // Assert
        assertThat(title).isEqualTo("Title");
    }
    
    @Test
    public void test_that_setTitle_sets_title_of_movie() {
        // Arrange
        
        // Act
        movie.setTitle("New Title");
        
        // Assert
        assertThat(movie.getTitle()).isEqualTo("New Title");
    }
    
    @Test
    public void test_that_getReleaseDate_returns_releaseDate_of_movie() {
        // Arrange
        
        // Act
        Date releaseDate = movie.getReleaseDate();
        
        // Assert
        assertThat(releaseDate).isEqualTo(new Date(Date.parse("01/01/2000")));
    }
    
    @Test
    public void test_that_setReleaseDate_sets_releaseDate_of_movie() {
        // Arrange
        
        // Act
        movie.setReleaseDate(new Date(Date.parse("12/31/9999")));
        
        // Assert
        assertThat(movie.getReleaseDate()).isEqualTo(new Date(Date.parse("12/31/9999")));
    }
    
    @Test
    public void test_that_getBudget_returns_budget_of_movie() {
        // Arrange
        
        // Act
        long budget = movie.getBudget();
        
        // Assert
        assertThat(budget).isEqualTo(1000000);
    }  
    
    @Test
    public void test_that_setBudget_sets_budget_of_movie() {
        // Arrange
        
        // Act
        movie.setBudget(25l);
        
        // Assert
        assertThat(movie.getBudget()).isEqualTo(25l);
    }
    
    @Test
    public void test_that_getDistributor_returns_distributor_of_movie() {
        // Arrange
        
        // Act
        String dist = movie.getDistributor();
        
        // Assert
        assertThat(dist).isEqualTo("Warner Bros");
    }
    
    @Test
    public void test_that_setDistributor_sets_distributor_of_movie() {
        // Arrange
        
        // Act
        movie.setDistributor("LionsGate");
        
        // Assert
        assertThat(movie.getDistributor()).isEqualTo("LionsGate");
    }
    
    @Test
    public void test_that_getActors_returns_list_of_actors() {
        // Arrange
        
        // Act
        List<Actor> actualActors = movie.getActors();
        
        // Assert
        assertThat(actualActors.size()).isEqualTo(2);
        assertThat(actualActors.get(0)).isSameAs(actors.get(0));
    }
    
    @Test
    public void test_that_add_actor_returns_list_of_actors_with_new_actor() {
        // Arrange
        Actor actor = new Actor();
        
        // Act
        movie.addActor(actor);
        
        // Assert
        assertThat(movie.getActors().get(2)).isSameAs(actor);
    }
    
    @Test
    public void test_that_add_actor_returns_list_when_list_is_initially_null() {
        // Arrange
        movie.setActors(null);
        Actor actor = new Actor();
        
        // Act
        movie.addActor(actor);
        
        // Assert
        assertThat(movie.getActors().get(0)).isSameAs(actor);
    }


    
  
    

}
