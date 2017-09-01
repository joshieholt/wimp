
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class AwardTests {

    private Award award;
    
    @Before
    public void setUp() {
        award = new Award();
    }
    
    @Test
    public void test_that_getId_returns_id_of_award() {
        // Arrange
        award.setId(3l);
        
        // Act
        long id = award.getId();
        
        // Assert
        assertThat(id).isEqualTo(3l);
    }
    
    @Test
    public void test_that_getTitle_returns_title_of_award() {
        // Arrange
        award.setTitle("new title");
        
        // Act
        String title = award.getTitle();
        
        // Assert
        assertThat(title).isEqualTo("new title");
    }
    
    @Test
    public void test_that_getOrganization_returns_organization_of_award() {
        // Arrange
        award.setOrganization("organization");
        
        // Act
        String organization = award.getOrganization();
        
        // Assert
        assertThat(organization).isEqualTo("organization");
    }
    
    @Test
    public void test_that_getYear_returns_year_of_award() {
        // Arrange
        award.setYear(2006);
        
        // Act
        long year = award.getYear();
        
        // Assert
        assertThat(year).isEqualTo(2006);
    }
    
    public void test_that_getActors_returns_list_of_actors() {
        // Arrange
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(new Actor());
        actors.add(new Actor());
        award.setActors(actors);
        
        // Act
        List<Actor> actualActors = award.getActors();
        
        // Assert
        assertThat(actualActors.size()).isEqualTo(2);
        assertThat(actualActors.get(0)).isSameAs(actors.get(0));
    }

}
