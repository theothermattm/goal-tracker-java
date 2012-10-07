package com.theothermattm.goal.domain;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Represents a simple goal
 * 
 * @author mattm
 * 
 */
public class Goal {

	/**
	 * A unique identifier for the goal.
	 */
	private String id;

	/**
	 * The name of the goal
	 */
	private String name;

	/**
	 * The due date for the goal, optional.
	 */
	private Date dueDate;

	/**
	 * Additional information about the goal, optional
	 */
	private String notes;

	/**
	 * The "weight"of the goal. Meaning, for example, a positive goal might be
	 * "Run 3 miles" and have a value of 2. A negative goal might be
	 * "Eat McDonald's"and have a weight of -5.
	 */
	private int weight;

	/**
	 * Creates a basic goal with a name and no dueDate.
	 * 
	 * @param name
	 */
	public Goal(String name) {
		Validate.notNull("Name cannot be null", name);
		this.name = name;
		this.dueDate = null;
	}

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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goal other = (Goal) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
