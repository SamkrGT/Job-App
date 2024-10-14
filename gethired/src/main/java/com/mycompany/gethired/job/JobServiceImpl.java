package com.mycompany.gethired.job;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
	
	// List<Job> jobs = new ArrayList<>();
	JobRepository jobRepository;
	
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		if(jobRepository.findById(id).isPresent()) {
				jobRepository.deleteById(id);
				return true;
		}
		return false;
	}

	@Override
	public boolean updateJobById(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if(jobOptional.isPresent()) {
				Job localJob = jobOptional.get();
				localJob.setTitle(updatedJob.getTitle());
				localJob.setDescription(updatedJob.getDescription());
				localJob.setLocation(updatedJob.getLocation());
				localJob.setMaxSalary(updatedJob.getMaxSalary());
				localJob.setMinSalary(updatedJob.getMinSalary());
				jobRepository.save(localJob);
				return true;
			}
		
		return false;
	}

}
