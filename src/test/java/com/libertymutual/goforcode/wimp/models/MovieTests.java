
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MovieTests {

    private Movie movie;
    
    @Before
    public void setUp() {
        movie = new Movie();
    }
    
    @Test
    public void test_that_getActors_returns_list_of_actors() {
        // Arrange
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(new Actor());
        actors.add(new Actor());
        movie.setActors(actors);
        
        // Act
        List<Actor> actualActors = movie.getActors();
        
        // Assert
        assertThat(actualActors.size()).isEqualTo(2);
        assertThat(actualActors.get(0)).isSameAs(actors.get(0));
    }
    
    @Test
    public void test_that_add_actor_returns_list_of_actors() {
        // Arrange
        Actor actor = new Actor();
        
        // Act
        movie.addActor(actor);
        
        // Assert
        assertThat(movie.getActors().get(0)).isSameAs(actor);
        
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
    
    @Test
    public void test_that_getTitle_returns_title_of_movie() {
        // Arrange
        movie.setTitle("new title");
        
        // Act
        String title = movie.getTitle();
        
        // Assert
        assertThat(title).isEqualTo("new title");
    }

    @Test
    public void test_that_getReleaseDate_returns_releaseDate_of_movie() {
        // Arrange
        movie.setReleaseDate(new Date(Date.parse("08/04/2006")));
        
        // Act
        Date releaseDate = movie.getReleaseDate();
        
        // Assert
        assertThat(releaseDate).isEqualTo(new Date(Date.parse("08/04/2006")));
    }
    
    @Test
    public void test_that_getBudget_returns_budget_of_movie() {
        // Arrange
        movie.setBudget(12345l);
        
        // Act
        long budget = movie.getBudget();
        
        // Assert
        assertThat(budget).isEqualTo(12345l);
    }    
    
    @Test
    public void test_that_getDistributor_returns_distributor_of_movie() {
        // Arrange
        movie.setDistributor("distributor");
        
        // Act
        String dist = movie.getDistributor();
        
        // Assert
        assertThat(dist).isEqualTo("distributor");
    }
}
