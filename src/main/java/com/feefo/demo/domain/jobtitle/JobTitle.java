package com.feefo.demo.domain.jobtitle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.feefo.demo.domain.validation.ValidationHandler;

public class JobTitle {
  private final String title;
  private static final Map<String, String> NORMALIZED_TITLES = new ConcurrentHashMap<>();

  static {
    NORMALIZED_TITLES.put("Architect", "Architect");
    NORMALIZED_TITLES.put("Software engineer", "Software engineer");
    NORMALIZED_TITLES.put("Quantity surveyor", "Quantity surveyor");
    NORMALIZED_TITLES.put("Accountant", "Accountant");
  }

  public JobTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void validate(final ValidationHandler handler) {
    new JobTitleValidator(this, handler).validate();
  }

  /**
   * Normalizes the job title by finding the closest match from the predefined
   * list of titles.
   * 
   * @return the normalized job title.
   */
  public String normalize() {
    String normalizedTitle = null;
    double highestScore = 0.0;

    for (Map.Entry<String, String> entry : NORMALIZED_TITLES.entrySet()) {
      double score = calculateQualityScore(this.title, entry.getKey());
      if (score > highestScore) {
        highestScore = score;
        normalizedTitle = entry.getValue();
      }
    }

    return normalizedTitle;
  }

  /**
   * Calculates a quality score based on the similarity between the input title
   * and target title.
   * 
   * @param input  the input job title.
   * @param target the target job title from the predefined list.
   * @return the similarity score between the input and target titles.
   */
  public double calculateQualityScore(String input, String target) {
    String[] inputWords = input.toLowerCase().split(" ");
    String[] targetWords = target.toLowerCase().split(" ");

    int matches = 0;
    for (String inputWord : inputWords) {
      for (String targetWord : targetWords) {
        if (inputWord.equals(targetWord)) {
          matches++;
          break; // Break early to avoid duplicate matching
        }
      }
    }

    return (double) matches / Math.max(inputWords.length, targetWords.length);
  }
}
