package com.theothermattm.goal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.theothermattm.goal.domain.Goal;

/**
 * In memory implementation of {@link GoalRepository} which can be used for
 * <em>testing purposes</em>. The thread safety of this repository is sketchy at
 * best.
 * 
 * @author mattm
 * 
 */
@Repository
public class GoalRepositoryInMemoryImpl implements GoalRepository {

	private static final Logger LOG = Logger
			.getLogger(GoalRepositoryInMemoryImpl.class);

	private Set<Goal> goals;

	public GoalRepositoryInMemoryImpl() {
		this.goals = new HashSet<Goal>();
	}

	@Override
	public synchronized void addGoal(Goal goal) {

		LOG.warn("Adding goal {" + goal + "} to IN MEMORY repository");

		this.goals.add(goal);

	}

	@Override
	public List<Goal> getGoals() {

		LOG.warn("Retrieving all goals from IN MEMROY repository...");

		List<Goal> goalList = new ArrayList<Goal>();

		goalList.addAll(this.goals);

		return Collections.unmodifiableList(goalList);
	}

}
