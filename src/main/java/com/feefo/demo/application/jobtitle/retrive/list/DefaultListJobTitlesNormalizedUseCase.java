package com.feefo.demo.application.jobtitle.retrive.list;

import com.feefo.demo.domain.jobtitle.JobTitleGateway;

public class DefaultListJobTitlesNormalizedUseCase extends ListJobTitlesNormalizedUseCase {
  private final JobTitleGateway jobTitleGateway;

  public DefaultListJobTitlesNormalizedUseCase(JobTitleGateway jobTitleGateway) {
    this.jobTitleGateway = jobTitleGateway;
  }

  @Override
  public String execute(String jobTitle) {
    return jobTitleGateway.normalizeJobTitle(jobTitle);
  }
}
