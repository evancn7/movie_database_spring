package com.fdmgroup.movie_database_spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fdmgroup.movie_database_spring.model.Actor;
import com.fdmgroup.movie_database_spring.service.ActorService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class ActorTest {

	@Autowired
	private ActorService actorService;

	@Test
	void test_ThatAnActorCanBePersisted() {
		Actor actor = new Actor("Will", "Smith", 53, "willpower@movie.org");
		boolean created = actorService.create(actor);
		assertTrue(created);
	}

	@Test
	void test_ThatADuplicateEntryCannotBePersisted() {
		Actor duplicateActor = new Actor("Toby", "Maguire", 62, "toebee@movies.org");
		boolean created = actorService.create(duplicateActor);
		assertFalse(created);
	}

	@Test
	void test_ThatAnActorCanBeRetrievedUsingTheirId() {
		Actor actorFromDb = actorService.retrieveOne(1).get();
		assertEquals(1, actorFromDb.getActorId());
	}

	@Test
	void test_ThatAFullListOfActorsCanBeRetrived() {
		List<Actor> allActors = actorService.retrieveAll();
		assertFalse(allActors.isEmpty());
	}

	@Test
	void test_ThatAnActorCanBeUpdated() {
		Actor actorToUpdate = actorService.retrieveOne(1).get();
		String nameBeforeUpdate = actorToUpdate.getFirstname();
		actorToUpdate.setFirstname("James");
		actorService.update(actorToUpdate);
		Actor updatedAuthor = actorService.retrieveOne(1).get();
		String nameAfterUpdate = updatedAuthor.getFirstname();
		assertNotEquals(nameAfterUpdate, nameBeforeUpdate);
	}
	
	@Test
	void test_ThatAnActorCanBeDeleted() {
		Actor actorToDelete = actorService.retrieveOne(3).get();
		boolean deleted = actorService.delete(actorToDelete);
		assertTrue(deleted);
	}
	
	@Test
	void test_ThatAnActorCanNotBeDeleted_IfBelongingToAMovie() {
		Actor actorToDelete = actorService.retrieveOne(1).get();
		boolean deleted = actorService.delete(actorToDelete);
		assertFalse(deleted);
	}
}
