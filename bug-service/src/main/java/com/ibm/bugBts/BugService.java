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

	public List<Bug> getBugs() {
		return bugRepository.findAll();
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

	public Optional<Bug> getBugbyName(String bugName) {
		return bugRepository.findByName(bugName);
	}

	public List<Bug> getBugbyStatus(String bugStatus) {
		return bugRepository.findByStatus(bugStatus);
	}

}
