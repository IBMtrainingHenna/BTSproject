  
package com.ibm.bugBts;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BugRepository extends MongoRepository<Bug,String>{

}