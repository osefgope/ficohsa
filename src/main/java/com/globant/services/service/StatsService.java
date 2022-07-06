package com.globant.services.service;

import com.globant.services.model.Stats;

public interface StatsService  {
	public void saveSuccessful_escape();
	public void saveUnSuccessful_escape();
	public Stats getStats();

}
