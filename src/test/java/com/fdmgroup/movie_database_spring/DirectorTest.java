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

import com.fdmgroup.movie_database_spring.model.Director;
import com.fdmgroup.movie_database_spring.service.DirectorService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class DirectorTest {

	@Autowired
	private DirectorService directorService;


	@Test
	void test_ThatADirectorCanBePersisted() {
		Director director = new Director("Quentin", "Tarantino", 58, "quenten@movie.org");
		boolean created = directorService.create(director);
		assertTrue(created);
	}

	@Test
	void test_ThatADuplicateEntryCannotBePersisted() {
		Director duplicateDirector = new Director("Sam", "Raimi", 62, "spidermansam@movies.org");
		boolean created = directorService.create(duplicateDirector);
		assertFalse(created);
	}

	@Test
	void test_ThatADirectorCanBeRetrievedUsingTheirId() {
		Director directorFromDb = directorService.retrieveOne(1).get();
		assertEquals(1, directorFromDb.getDirectorId());
	}

	@Test
	void test_ThatAFullListOfDirectorsCanBeRetrived() {
		List<Director> allDirectors = directorService.retrieveAll();
		assertFalse(allDirectors.isEmpty());
	}

	@Test
	void test_ThatADirectorCanBeUpdated() {
		Director directorToUpdate = directorService.retrieveOne(1).get();
		String nameBeforeUpdate = directorToUpdate.getFirstname();
		directorToUpdate.setFirstname("James");
		directorService.update(directorToUpdate);
		Director updatedAuthor = directorService.retrieveOne(1).get();
		String nameAfterUpdate = updatedAuthor.getFirstname();
		assertNotEquals(nameAfterUpdate, nameBeforeUpdate);
	}

	@Test
	void test_ThatADirectorCanBeDeleted() {
		Director directorToDelete = directorService.retrieveOne(3).get();
		boolean deleted = directorService.delete(directorToDelete);
		assertTrue(deleted);
	}
	
	@Test
	void test_ThatAnDirectorCanNotBeDeleted_IfDirectedAMovie() {
		Director directorToDelete = directorService.retrieveOne(1).get();
		boolean deleted = directorService.delete(directorToDelete);
		assertFalse(deleted);
	}
}
