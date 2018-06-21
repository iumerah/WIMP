package com.el.ally.wimp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.wimp.api.ActorController;
import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.repositories.ActorRepository;

public class ActorApiControllerTests {

    private ActorController controller;

    @Mock
    private ActorRepository actorRepo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new ActorController(actorRepo);
    }

    @Test
    public void getAll_actors() {
        // Arrange
        ArrayList<Actor> actors = new ArrayList<Actor>();
        when(actorRepo.findAll()).thenReturn(actors);

        // Act
        List<Actor> actual = controller.getActors();

        // Assert
        assertThat(actual).hasSize(actors.size());
        verify(actorRepo).findAll();
    }

    @Test
    public void getOne_actor() {
        // Arrange
        Actor actor = new Actor();
        when(actorRepo.findOne((int) 1L)).thenReturn(actor);

        // Act
        Actor actual = controller.getSpecificActor((int) 1L);

        // Assert
        assertThat(actual).isSameAs(actor);
        verify(actorRepo).findOne((int) 1L);
    }

    @Test
    public void create_actor_and_return_it() {
        // Arrange
        Actor actor = new Actor();
        when(actorRepo.save(actor)).thenReturn(actor);

        // Act
        Actor actual = controller.createActor(actor);

        // Assert
        assertThat(actual).isSameAs(actor);
        verify(actorRepo).save(actor);
    }

}