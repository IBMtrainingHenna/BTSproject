package com.ibm.bugBts;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Bug {

	@Id
	private String id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String projectId;
	private PRIORITY priority;
	private STATUS status;
	private SEVERITY severity;
	private TYPE type;
	@NotNull
	@NotBlank
	@Size(min = 3, max = 15)
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public PRIORITY getPriority() {
		return priority;
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getDescription() {
		return description.trim();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

}
