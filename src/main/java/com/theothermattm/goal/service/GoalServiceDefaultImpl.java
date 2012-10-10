package com.theothermattm.goal.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theothermattm.goal.domain.Goal;

/**
 * Default implementation of {@link GoalService} which uses a
 * {@link GoalRepository} to persist data.
 * 
 * @author mattm
 * 
 */
@Service
public class GoalServiceDefaultImpl implements GoalService {

	private static final Logger LOG = Logger
			.getLogger(GoalServiceDefaultImpl.class);

	private GoalRepository goalRepository;

	@Autowired
	public GoalServiceDefaultImpl(GoalRepository goalRepository) {
		this.goalRepository = goalRepository;
	}

	@SuppressWarnings("unused")
	private GoalServiceDefaultImpl(){
		// for Spring only
	}
	
	private GoalRepository getGoalRepository() {
		return this.goalRepository;
	}

	/*
	 * There's not much here now, admittedly. However, keeping the service layer
	 * here to stick to Domain Driven Design service/repository structure and to
	 * prepare for future manipulation/logic that might need to occur after
	 * pulling out of repository.
	 */

	@Override
	public void addGoal(Goal goal) {

		if (LOG.isDebugEnabled()) {
			LOG.debug("Adding goal {" + goal + "} to repository");
		}

		getGoalRepository().addGoal(goal);
	}

	@Override
	public List<Goal> getGoals() {

		LOG.debug("Retrieving all goals from repository");

		List<Goal> goals = getGoalRepository().getGoals();
		return goals;
	}

}
