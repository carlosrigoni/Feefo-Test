package com.feefo.demo.jobtitle;

import org.junit.jupiter.api.Test;

import com.feefo.demo.domain.jobtitle.JobTitle;

import static org.junit.jupiter.api.Assertions.*;

class JobTitleTest {

  @Test
  void testGetTitle() {
    JobTitle jobTitle = new JobTitle("Software engineer");
    assertEquals("Software engineer", jobTitle.getTitle());
  }

  @Test
  void testNormalizeExactMatch() {
    JobTitle jobTitle = new JobTitle("Architect");
    assertEquals("Architect", jobTitle.normalize());
  }

  @Test
  void testNormalizeSimilarTitle() {
    JobTitle jobTitle = new JobTitle("software Engineer");
    assertEquals("Software engineer", jobTitle.normalize());
  }

  @Test
  void testNormalizeDifferentTitle() {
    JobTitle jobTitle = new JobTitle("Chief Accountant");
    assertEquals("Accountant", jobTitle.normalize());
  }

  @Test
  void testNormalizeNoMatch() {
    JobTitle jobTitle = new JobTitle("Random Title");
    assertNull(jobTitle.normalize());
  }

  @Test
  void testCalculateQualityScoreExactMatch() {
    JobTitle jobTitle = new JobTitle("Any Title");
    double score = jobTitle.calculateQualityScore("Software engineer", "Software engineer");
    assertEquals(1.0, score);
  }

  @Test
  void testCalculateQualityScorePartialMatch() {
    JobTitle jobTitle = new JobTitle("Any Title");
    double score = jobTitle.calculateQualityScore("Software engineer", "Software architect");
    assertEquals(0.5, score);
  }

  @Test
  void testCalculateQualityScoreNoMatch() {
    JobTitle jobTitle = new JobTitle("Any Title");
    double score = jobTitle.calculateQualityScore("Software engineer", "Doctor");
    assertEquals(0.0, score);
  }
}