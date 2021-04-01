package com.ibm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.bugBts.Bug;
import com.ibm.bugBts.BugRepository;
import com.ibm.bugBts.BugService;

class BugServiceTest {

	@Test
	void testCreateBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugrepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
		
	}

//	@Test
//	void testGetBugs() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetBug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateBug() {
//		fail("Not yet implemented");
//	}

}
