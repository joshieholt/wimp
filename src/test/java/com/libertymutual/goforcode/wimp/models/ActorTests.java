
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ActorTests {

    private Actor actor;
    
    @Before
    public void setUp() {
        actor = new Actor();
    }
    
    @Test
    public void test_that_getFirstName_returns_firstname_of_actor() {
        // Arrange
        actor.setFirstName("John");
        
        // Act
        String firstName = actor.getFirstName();
        
        // Assert
        assertThat(firstName).isEqualTo("John");
    }
    
    @Test
    public void test_that_getLastName_returns_lastname_of_actor() {
        // Arrange
        actor.setLastName("Malkovich");
        
        // Act
        String lastName = actor.getLastName();
        
        // Assert
        assertThat(lastName).isEqualTo("Malkovich");
    }
    
    @Test
    public void test_that_getActiveSinceYear_returns_activesinceyear_of_actor() {
        // Arrange
        actor.setActiveSinceYear(1978l);
        
        // Act
        long activeSinceYear = actor.getActiveSinceYear();
        
        // Assert
        assertThat(activeSinceYear).isEqualTo(1978l);
    }
    
    @Test
    public void test_that_getBirthDate_returns_birthdate_of_actor() {
        // Arrange
        actor.setBirthDate(new Date(Date.parse("12/09/1953")));
        
        // Act
        Date birthDate = actor.getBirthDate();
        
        // Assert
        assertThat(birthDate).isEqualTo(new Date(Date.parse("12/09/1953")));
    }

    @Test
    public void test_that_getMovies_returns_list_of_movies() {
        // Arrange
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie());
        movies.add(new Movie());
        actor.setMovies(movies);
        
        // Act
        List<Movie> actualMovies = actor.getMovies();
        
        // Assert
        assertThat(actualMovies.size()).isEqualTo(2);
        assertThat(actualMovies.get(0)).isSameAs(movies.get(0));
    }
    
    @Test
    public void test_that_getAwards_returns_list_of_awards() {
        // Arrange
        List<Award> awards = new ArrayList<Award>();
        awards.add(new Award());
        awards.add(new Award());
        actor.setAwards(awards);
        
        // Act
        List<Award> actualAwards = actor.getAwards();
        
        // Assert
        assertThat(actualAwards.size()).isEqualTo(2);
        assertThat(actualAwards.get(0)).isSameAs(awards.get(0));
    }
}
