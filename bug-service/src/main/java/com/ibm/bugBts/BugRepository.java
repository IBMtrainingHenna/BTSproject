package com.ibm.bugBts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BugRepository extends MongoRepository<Bug,String>{

	Optional<Bug> findByName(String bugName);

	List<Bug> findByStatus(String bugStatus);

	@Query("{name:{$regex:?0,'$options':'i'}}")
	List<Bug> getByStatusAndNameIgnoreCase(String bugName, String bugStatus);

	@Query("{name:{$regex:?0,'$options':'i'}}")
	List<Bug> findNameIgnoreCase(String bugName);

}
