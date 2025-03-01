package com.foly.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findById(Long id);
    boolean updateJob(Long id, Job updatedJob);
    boolean deleteJob(Long id);
}
