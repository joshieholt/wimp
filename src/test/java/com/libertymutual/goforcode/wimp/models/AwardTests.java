
package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.Before;

public class AwardTests {

    private Award award;
    
    @Before
    public void setUp() {
        award = new Award("Title", "Organization", 2000);
    }
    
    @Test
    public void test_that_getId_returns_id_of_award() {
        // Arrange
        award.setId(1l);
        
        // Act
        long id = award.getId();
        
        // Assert
        assertThat(id).isEqualTo(1l);
    }
    
    @Test
    public void test_that_getTitle_returns_title_of_award() {
        // Arrange
        
        // Act
        String title = award.getTitle();
        
        // Assert
        assertThat(title).isEqualTo("Title");
    }
    
    @Test
    public void test_that_setTitle_sets_title_of_award() {
        // Arrange
        
        // Act
        award.setTitle("New Title");
        
        // Assert
        assertThat(award.getTitle()).isEqualTo("New Title");
    }
    
    @Test
    public void test_that_getOrganization_returns_organization_of_award() {
        // Arrange
        
        // Act
        String organization = award.getOrganization();
        
        // Assert
        assertThat(organization).isEqualTo("Organization");
    }
    
    @Test
    public void test_that_setOrganization_sets_organization_of_award() {
        // Arrange
        
        // Act
        award.setOrganization("New Organization");
        
        // Assert
        assertThat(award.getOrganization()).isEqualTo("New Organization");
    }
    
    @Test
    public void test_that_getYear_returns_year_of_award() {
        // Arrange
        
        // Act
        long year = award.getYear();
        
        // Assert
        assertThat(year).isEqualTo(2000);
    }

    @Test
    public void test_that_setYear_sets_year_of_award() {
        // Arrange
        
        // Act
        award.setYear(3000);
        
        // Assert
        assertThat(award.getYear()).isEqualTo(3000);
    }
}
