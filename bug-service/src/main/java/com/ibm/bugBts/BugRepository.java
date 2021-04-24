package com.ibm.bugBts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BugRepository extends MongoRepository<Bug,String>{
//	@Query("{'name':?0}")
	Optional<Bug> findByName(String bugName);

	List<Bug> findByStatus(String bugStatus);
	
	@Query("{status: ?0,name : {$regex : ?1,'$options':'i'}}")
	List<Bug> getByStatusAndName(STATUS bugStatus, String bugName);

	@Query("{name : {$regex : ?0,'$options':'i'}}")
	List<Bug> findByNameIgnoreCase(String bugName);

}
