package com.theothermattm.goal.service;

import java.util.List;

import com.theothermattm.goal.domain.Goal;

/**
 * Repository interface for persistence of {@link Goal}s.
 * 
 * @author mattm
 * 
 */
interface GoalRepository {

	/**
	 * Adds a goal to the underlying repository.
	 * 
	 * @param goal
	 *            , non-null
	 */
	void addGoal(Goal goal);

	/**
	 * Retrieves <em>all</em> goals from the repository as an
	 * {@link UnmodifiableList}. Any modifications to goals should be done
	 * through interface methods.
	 * 
	 * @return {@link List} of {@link Goal}s or empty List if none exist.
	 */
	List<Goal> getGoals();

}
