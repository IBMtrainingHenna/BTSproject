package com.ibm.bugBts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug,Integer>{

}
