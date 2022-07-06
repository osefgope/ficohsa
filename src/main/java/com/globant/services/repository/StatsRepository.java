package com.globant.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.globant.services.model.Stats;
@Repository
public interface StatsRepository extends MongoRepository<Stats,Long> {
}
