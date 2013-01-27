package com.theothermattm.goal.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.theothermattm.goal.domain.Goal;

/**
 * JPA Implementation of {@link GoalRepository}
 * 
 * @author mattm
 * 
 */
@Repository
public class GoalRepositoryJpaImpl implements GoalRepository {

	private static final Logger LOG = Logger
			.getLogger(GoalRepositoryJpaImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void addGoal(Goal goal) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Adding goal to JPA repository:" + goal);
		}

		entityManager.persist(goal);
	}

	@Override
	public List<Goal> getGoals() {
		
		LOG.debug("Retrieving all goals from JPA repository...");
		
		TypedQuery<Goal> query = entityManager.createQuery("from Goal", Goal.class);
		
		List<Goal> goals = query.getResultList();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug("Retrieved " + goals.size() + " goals.");
		}

		return goals;
	}

}
