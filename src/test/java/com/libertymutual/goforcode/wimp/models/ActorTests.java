
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ActorTests {

    private Actor actor;
    private List<Movie> movies;
    private List<Award> awards;
    
    @Before
    public void setUp() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie());
        movies.add(new Movie());
        awards = new ArrayList<Award>();
        awards.add(new Award());
        awards.add(new Award());
        actor = new Actor("First", "Last", 1995l, new Date(Date.parse("01/01/1970")), movies, awards);
    }
    
    @Test
    public void test_that_getFirstName_returns_firstname_of_actor() {
        // Arrange
        
        // Act
        String firstName = actor.getFirstName();
        
        // Assert
        assertThat(firstName).isEqualTo("First");
    }
    
    @Test
    public void test_that_setFirstName_sets_firstname_of_actor() {
        // Arrange
        
        // Act
        actor.setFirstName("New First");
        
        // Assert
        assertThat(actor.getFirstName()).isEqualTo("New First");
    }
    
    @Test
    public void test_that_getLastName_returns_lastname_of_actor() {
        // Arrange
        
        // Act
        String lastName = actor.getLastName();
        
        // Assert
        assertThat(lastName).isEqualTo("Last");
    }
    
    @Test
    public void test_that_setLastName_sets_lastname_of_actor() {
        // Arrange
        
        // Act
        actor.setLastName("New Last");
        
        // Assert
        assertThat(actor.getLastName()).isEqualTo("New Last");
    }
    
    @Test
    public void test_that_getActiveSinceYear_returns_activesinceyear_of_actor() {
        // Arrange
        
        // Act
        long activeSinceYear = actor.getActiveSinceYear();
        
        // Assert
        assertThat(activeSinceYear).isEqualTo(1995l);
    }
    
    @Test
    public void test_that_setActiveSinceYear_sets_activesinceyear_of_actor() {
        // Arrange
        
        // Act
        actor.setActiveSinceYear(2000l);
        
        // Assert
        assertThat(actor.getActiveSinceYear()).isEqualTo(2000l);
    }
    
    @Test
    public void test_that_getBirthDate_returns_birthdate_of_actor() {
        // Arrange
        
        // Act
        Date birthDate = actor.getBirthDate();
        
        // Assert
        assertThat(birthDate).isEqualTo(new Date(Date.parse("01/01/1970")));
    }

    @Test
    public void test_that_setBirthDate_sets_birthdate_of_actor() {
        // Arrange
        
        // Act
        actor.setBirthDate(new Date(Date.parse("12/31/9999")));
        
        // Assert
        assertThat(actor.getBirthDate()).isEqualTo(new Date(Date.parse("12/31/9999")));
    }
    
    @Test
    public void test_that_getMovies_returns_list_of_movies() {
        // Arrange
        
        // Act
        List<Movie> actualMovies = actor.getMovies();
        
        // Assert
        assertThat(actualMovies.size()).isEqualTo(2);
        assertThat(actualMovies.get(0)).isSameAs(movies.get(0));
    }
    
    @Test
    public void test_that_setMovies_sets_list_of_movies_for_actor() {
        // Arrange
        movies = new ArrayList<Movie>();
        movies.add(new Movie());
        movies.add(new Movie());
        movies.add(new Movie());
        
        // Act
        actor.setMovies(movies);
        
        // Assert
        assertThat(actor.getMovies().size()).isEqualTo(3);
        assertThat(actor.getMovies().get(0)).isSameAs(movies.get(0));
    }
    
    @Test
    public void test_that_getAwards_returns_list_of_awards() {
        // Arrange
        
        // Act
        List<Award> actualAwards = actor.getAwards();
        
        // Assert
        assertThat(actualAwards.size()).isEqualTo(2);
        assertThat(actualAwards.get(0)).isSameAs(awards.get(0));
    }
    
    @Test
    public void test_that_setAwards_sets_list_of_awards_for_actor() {
        // Arrange
        awards = new ArrayList<Award>();
        awards.add(new Award());
        awards.add(new Award());
        awards.add(new Award());
        
        // Act
        actor.setAwards(awards);
        
        // Assert
        assertThat(actor.getAwards().size()).isEqualTo(3);
        assertThat(actor.getAwards().get(0)).isSameAs(awards.get(0));
    }
}
