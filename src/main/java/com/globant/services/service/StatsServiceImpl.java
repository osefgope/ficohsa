package com.globant.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.services.model.Stats;
import com.globant.services.repository.StatsRepository;

@Service
public class StatsServiceImpl implements StatsService  {
	@Autowired
StatsRepository stats;

public void saveSuccessful_escape(){
	Stats aux=stats.findById((long) 1).orElse(null);
	aux.setCount_successful_escape(aux.getCount_successful_escape()+1);
	aux.setRatio();
	stats.save(aux);
}

@Override
public void saveUnSuccessful_escape() {
	Stats aux=stats.findById((long) 1).orElse(null);
	aux.setCount_unsuccessful_escape(aux.getCount_unsuccessful_escape()+1);
	aux.setRatio();
	stats.save(aux);
}

@Override
public Stats getStats() {
	 Stats aux=stats.findById((long) 1).orElse(null);
	return aux;
}

}
