package com.ibm.bugBts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BugServiceTest {
	
	BugService bugService;
	BugRepository dummyRepo;
	Bug bug;

	@BeforeEach
	void init(){
		bugService = new BugService();
		dummyRepo = new DummyRepository();
		bugService.setBugRepository(dummyRepo);
		bug = new Bug();
	}
		
	@Test
	void testCreateBug() {
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
	}
	
	@Test
	void testGetBugs() {
		List<Bug> bugsList = bugService.getBugs();  
		assertNotNull(bugsList);
 		assertEquals("607525b4a1e25e111299f693", bugsList.get(0).getId());
	}

	@Test
	void testGetBug() {
		Optional<Bug> bug1 = bugService.getBug("607525b4a1e25e111299f693");
		assertNotNull(bug1);
	}

	@Test
	void testUpdateBug() {
		STATUS status = bugService.updateBugStatus(bug);
		assertNotNull(status);
		assertEquals(STATUS.OPEN, status);
	}

}
