
package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.AwardRepository;

public class ActorApiControllerTests {
    
    private ActorRepository actorRepo;
    private AwardRepository awardRepo;
    private ActorApiController controller;
    
    @Before
    public void setUp() {
        actorRepo = mock(ActorRepository.class);
        awardRepo = mock(AwardRepository.class);
        controller = new ActorApiController(actorRepo, awardRepo);
    }

    @Test
    public void test_getAll_returns_all_Actors_returned_by_the_repo() {
        // Arrange
        ArrayList<Actor> actors = new ArrayList<Actor>();
        actors.add(new Actor());
        actors.add(new Actor());
        
        when(actorRepo.findAll()).thenReturn(actors);
        
        // Act
        List<Actor> actual = controller.getAll();
        
        // Assert
        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual.get(0)).isSameAs(actors.get(0));
        verify(actorRepo).findAll();
    }

    @Test
    public void test_getOne_returns_one_Actor_returned_by_the_repo() throws StuffNotFoundException {
        Actor actor = new Actor();
        when(actorRepo.findOne(1l)).thenReturn(actor);
        
        // Act
        Actor actual = controller.getOne(1l);
        
        // Assert
        assertThat(actual).isSameAs(actor);
        verify(actorRepo).findOne(1l);
    }
    
    @Test
    public void test_getOne_throws_StuffNotFoundException_when_no_Actor_returned_from_repo() {
        try {
            controller.getOne(1l);
            fail("The controller did not throw the StuffNotFoundException");
        } catch(StuffNotFoundException snfe) {}
    }
    
    @Test
    public void test_delete_returns_actor_deleted_when_found() {
        // Arrange
        Actor actor = new Actor();
        when(actorRepo.findOne(1l)).thenReturn(actor);
        
        // Act
        Actor actual = controller.deleteOne(1l);
        
        // Assert
        assertThat(actual).isSameAs(actor);
        verify(actorRepo).delete(1l);
        verify(actorRepo).findOne(1l);
    }
    
    @Test
    public void test_that_null_is_returned_when_findOne_throws_EmptyResultDataAccess() throws StuffNotFoundException {
        // Arrange
        when(actorRepo.findOne(1l)).thenThrow(new EmptyResultDataAccessException(0));
        
        // Act
        Actor actual = controller.deleteOne(1l);
        
        // Assert
        assertThat(actual).isNull();
        verify(actorRepo).findOne(1l);
    }
    
    @Test
    public void test_that_new_Actor_is_created_when_createOne_is_called() {
        // Arrange
        Actor actor = new Actor();
        when(actorRepo.save(actor)).thenReturn(actor);
        
        // Act
        Actor actual = controller.createOne(actor);
        
        // Assert
        assertThat(actual).isSameAs(actor);
        verify(actorRepo).save(actor);
    }
    
    @Test
    public void test_that_Actor_is_updated_when_udpate_is_called() {
        // Arrange
        Actor actor = new Actor();
        when(actorRepo.save(actor)).thenReturn(actor);
        
        // Act
        Actor actual = controller.update(actor, 3l);
        
        // Assert
        assertThat(actual.getId()).isEqualTo(3l);
        verify(actorRepo).save(actor);
    }
    
    @Test
    public void test_that_award_is_associated_with_the_actor_when_associateAnAward_is_called() {
        // Arrange
        Actor actor = new Actor();
        Award award = new Award();
        when(actorRepo.findOne(1l)).thenReturn(actor);
        when(awardRepo.findOne(2l)).thenReturn(award);
        
        // Act
        Award actualAward = awardRepo.findOne(2l);
        Actor actualActor = controller.associateAnAward(1l,  actualAward);
        
        // Assert
        assertThat(actualActor).isSameAs(actor);
        assertThat(actualAward).isSameAs(award);
        verify(actorRepo).save(actor);
    }
}
