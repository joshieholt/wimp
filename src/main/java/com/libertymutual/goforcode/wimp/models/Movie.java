
package com.libertymutual.goforcode.wimp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(length=300, nullable=false)
    private String title;
    
    private Date releaseDate;
    
    private Long budget;
    
    @Column(length=500, nullable=false)
    private String distributor;

    @ManyToMany
    private List<Actor> actors;
    
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the budget
     */
    public Long getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(Long budget) {
        this.budget = budget;
    }

    /**
     * @return the distributor
     */
    public String getDistributor() {
        return distributor;
    }

    /**
     * @param distributor the distributor to set
     */
    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    /**
     * @return the actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

}
