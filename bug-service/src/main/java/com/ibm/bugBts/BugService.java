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

	public STATUS updateBug(@RequestBody Bug bug) {
		STATUS status = bug.getStatus();
		Optional<Bug> currentBug = bugRepository.findById(bug.getId());
		currentBug.ifPresent(currentbug -> {
			STATUS currentstatus = currentbug.getStatus();

			if (currentstatus == STATUS.NEW) {
				if (status == STATUS.ASSIGNED || status == STATUS.NEW) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.ASSIGNED) {
				if (status == STATUS.OPEN || status == STATUS.ASSIGNED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.OPEN) {
				if (status == STATUS.OPEN || status == STATUS.FIXED || status == STATUS.DEFERRED
						|| status == STATUS.DUPLICATE || status == STATUS.REJECTED || status == STATUS.NOT_A_BUG
						|| status == STATUS.COULD_NOT_REPRODUCE || status == STATUS.NEED_MORE_INFO
						|| status == STATUS.WONT_FIX) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.FIXED) {
				if (status == STATUS.FIXED || status == STATUS.PENDING_RETEST) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.PENDING_RETEST) {
				if (status == STATUS.PENDING_RETEST || status == STATUS.RETEST) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.RETEST) {
				if (status == STATUS.RETEST || status == STATUS.REOPEN || status == STATUS.VERIFIED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.REOPEN) {
				if (status == STATUS.REOPEN || status == STATUS.FIXED || status == STATUS.DEFERRED
						|| status == STATUS.DUPLICATE || status == STATUS.REJECTED || status == STATUS.NOT_A_BUG
						|| status == STATUS.COULD_NOT_REPRODUCE || status == STATUS.NEED_MORE_INFO
						|| status == STATUS.WONT_FIX) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.DUPLICATE) {
				if (status == STATUS.DUPLICATE || status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.REJECTED) {
				if (status == STATUS.REJECTED || status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.NOT_A_BUG) {
				if (status == STATUS.NOT_A_BUG || status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.WONT_FIX) {
				if (status == STATUS.WONT_FIX || status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.VERIFIED) {
				if (status == STATUS.VERIFIED || status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.COULD_NOT_REPRODUCE) {
				if (status == STATUS.COULD_NOT_REPRODUCE || status == STATUS.DEFERRED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.NEED_MORE_INFO) {
				if (status == STATUS.NEED_MORE_INFO || status == STATUS.DEFERRED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.DEFERRED) {
				if (status == STATUS.DEFERRED || status == STATUS.ASSIGNED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else if (currentstatus == STATUS.CLOSED) {
				if (status == STATUS.CLOSED) {
					bugRepository.save(bug);
				} else {
					throw new IllegalArgumentException("Status change not allowed");
				}
			}

			else {
				bugRepository.save(bug);
			}

		});

		return bug.getStatus();
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public void setBugrepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public Optional<Bug> getBugbyName(String bugName) {
		return bugRepository.findByName(bugName);
	}

	public List<Bug> getBugbyStatus(String bugStatus) {
		return bugRepository.findByStatus(bugStatus);
	}

	public void deleteBug(String bugId) {
		bugRepository.deleteById(bugId);

	}

	public List<Bug> getByStatusAndName(String bugName, String bugStatus) {
		return bugRepository.getByStatusAndNameIgnoreCase(bugName, bugStatus);
	}

	public List<Bug> getBugbyPartialName(String bugName) {
		return bugRepository.findNameIgnoreCase(bugName);
	}

}
