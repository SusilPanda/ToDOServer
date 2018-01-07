/**
 * 
 */
package com.app.todo;

import org.springframework.data.mongodb.repository.MongoRepository;

/** Implementation will automatically generated at runtime by Spring Data JPA
 * @author esusich
 *
 */
public interface TaskRepository extends  MongoRepository<Task, String> {

	// custom DB query methods can be added.
}
