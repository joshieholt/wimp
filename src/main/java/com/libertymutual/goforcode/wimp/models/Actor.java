
package com.libertymutual.goforcode.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(length=75, nullable=false)
    private String firstName;
    
    @Column(length=75, nullable=false)
    private String lastName;
    
    private Long activeSinceYear;
    
    private Date birthDate;
    
    @JsonIgnore
    @ManyToMany(mappedBy="actors")
    private List<Movie> movies;

    public Actor() {}
    
    public Actor(String firstName, String lastName, long activeSinceYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeSinceYear = activeSinceYear;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the activeSinceYear
     */
    public Long getActiveSinceYear() {
        return activeSinceYear;
    }

    /**
     * @param activeSinceYear the activeSinceYear to set
     */
    public void setActiveSinceYear(Long activeSinceYear) {
        this.activeSinceYear = activeSinceYear;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies the movies to set
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
