package com.app.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SpringController {
	
	@Autowired
	TaskRepository repository;
    
    @RequestMapping(value = "/api/get/{id}", method =  RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable("id") String id) {
     
    	Task taskFromDB = repository.findOne(id);
        
        return new ResponseEntity<Task>(taskFromDB, HttpStatus.OK) ;
    }
    
    @RequestMapping(value = "/api/getAll", method =  RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTask() {
     
    	List<Task> taskList = repository.findAll();
    	System.out.println(taskList);
        
        return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/api/create", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
		
		task.setStatus("pending");
		// save a couple of customers
		repository.save(task);
		       
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/api/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task) {
		
		Task oldTask = repository.findOne(id);
		if(repository.exists(id)) {
		// update the task
			task.setDescription(oldTask.getDescription());
			task.setStatus("completed");
			repository.delete(oldTask);
			
			repository.save(task);
		}
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask(@PathVariable("id") String id) {
		
		Task task = repository.findOne(id);
		// delete task
		if(null != task) {
		repository.delete(task);
		}
        return new ResponseEntity<String>("success", HttpStatus.NO_CONTENT);
    }
}