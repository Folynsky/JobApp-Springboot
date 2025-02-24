package com.foly.jobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Job findById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @PostMapping
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created";
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJob(id, updatedJob);
        return updated ? "Job updated" : "Job not found";
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        return deleted ? "Job deleted" : "Job not found";
    }
}
