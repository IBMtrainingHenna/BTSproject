package com.ibm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.bugBts.Bug;
import com.ibm.bugBts.BugRepository;
import com.ibm.bugBts.BugService;
import com.ibm.bugBts.STATUS;

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

	
	@Test
	void testUpdateBug() {
		BugService bugservice = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		BugService 	bugService.setBugrepository(dummyRepo);
		Bug bug = new Bug();
		String bug = bugService.updateBug(bug);
		assertNotNull(status);
		assertEquals(STATUS.VERIFIED,status);
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


	//@Test
	//void testGetBugs() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetBug() {
//		fail("Not yet implemented");
//	}
//
//	
//
}
