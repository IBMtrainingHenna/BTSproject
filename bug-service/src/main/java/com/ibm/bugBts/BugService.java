package com.ibm.bugBts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService implements IBugService {
	@Autowired
	BugRepository bugRepository;
	
	@Override
	public int save(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

//	public List<Bug> getBugs() {
//		return bugRepository.findAll();
//	}
//
//	public Optional<Bug> getBug(String bugId) {
//		return bugRepository.findById(bugId);
//	}
//
//	public void updateBug(@RequestBody Bug bug) {
//		bugRepository.save(bug);
//	}
	
	public void setBugrepository( BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}


}
