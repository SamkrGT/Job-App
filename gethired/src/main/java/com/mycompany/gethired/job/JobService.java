package com.mycompany.gethired.job;

import java.util.List;

interface JobService {
	List<Job> findAllJobs();
	void createJob(Job job);
	Job getJobById(Long id);
	boolean deleteJobById(Long id);
	boolean updateJobById(Long id, Job updatedJob);
}
