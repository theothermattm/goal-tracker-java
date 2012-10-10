package com.theothermattm.goal.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theothermattm.goal.domain.Goal;
import com.theothermattm.goal.service.GoalService;

@Controller
public class GoalController extends BaseController {

	private static final Logger LOG = Logger.getLogger(GoalController.class);

	@Autowired
	private GoalService goalService;

	
	@RequestMapping("hello")
	public @ResponseBody String hello(){
		return "hello, world!";
	}
	
	@RequestMapping(value = URI_SERVICES_BASE + "/" + URI_GOAL_BASE, method = RequestMethod.POST)
	public String addGoal(@RequestBody Goal goal){
		LOG.debug("In GoalController.addGoal()");
		
		goalService.addGoal(goal);
		
		return "redirect:" + URI_GOALS_BASE;
	}
	
	@RequestMapping(value = URI_SERVICES_BASE + "/" + URI_GOALS_BASE, method = RequestMethod.GET)
	public @ResponseBody
	List<Goal> getAllGoals() {

		LOG.debug("In GoalController.getAllGoals()");
		
		List<Goal> goals = goalService.getGoals();

		return goals;

	}

}
