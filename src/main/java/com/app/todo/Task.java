/**
 * 
 */
package com.app.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author esusich
 *
 */
@Document
public class Task {

	
	@Id
	public String id;
	
	public String taskId;
	public String description;
	public String status;
	
	/**
	 * @param description
	 * @param status
	 */
	public Task (){}
	public Task(String taskId, String description, String status) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.status = status;
	}
	
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	
	
	
}
