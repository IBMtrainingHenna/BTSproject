package com.ibm.bugBts;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;
	
	public String createBug(@Valid Bug bug) {
		bugRepository.save(bug);
		return bug.getId();
	}

//	public List<Bug> getBugs() {
//		return bugRepository.findAll();
//	}
////
	public Optional<Bug> getBug(String bugId) {
		return bugRepository.findById(bugId);
	}

	public void updateBug(@RequestBody Bug bug) {
		bugRepository.save(bug);
	}
	
	
	public BugRepository getBugRepository() {
		return bugRepository;
	}
	
	public void setBugrepository( BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

}
