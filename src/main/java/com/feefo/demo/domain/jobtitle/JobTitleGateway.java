package com.feefo.demo.domain.jobtitle;

import java.util.List;

public class JobTitleGateway {
  private List<JobTitle> jobTitles;

  public JobTitleGateway(List<JobTitle> jobTitles) {
    this.jobTitles = jobTitles;
  }

  public List<JobTitle> getJobTitles() {
    return jobTitles;
  }

  public void addJobTitle(JobTitle jobTitle) {
    jobTitles.add(jobTitle);
  }

  public String normalizeJobTitle(String title) {
    JobTitle jobTitle = new JobTitle(title);
    return jobTitle.normalize();
  }
}
