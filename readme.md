# Job Title Normalization and Quality Scoring

This project involves a system for normalizing job titles and calculating their quality scores. The provided tests validate the functionality of the normalization and scoring processes.

## Unit Tests

### `ListJobTitlesNormalizedUseCaseTest`

This class tests the `DefaultListJobTitlesNormalizedUseCase` which is responsible for normalizing job titles.

- **testExecuteWithExactMatch**: Verifies that an exact match returns the same title.
- **testExecuteWithSimilarMatch**: Verifies that a similar match returns a normalized title.
- **testExecuteWithDifferentTitle**: Verifies that a different title returns a normalized job category.
- **testExecuteWithNoMatch**: Verifies that a title with no match returns `null`.
- **testExecuteWithEmptyTitle**: Verifies that an empty title returns `null`.

### `JobTitleTest`

This class tests the `JobTitle` class which represents a job title and includes methods for normalization and quality scoring.

- **testGetTitle**: Verifies the title getter method.
- **testNormalizeExactMatch**: Verifies that an exact match returns the same title.
- **testNormalizeSimilarTitle**: Verifies that a similar title is normalized.
- **testNormalizeDifferentTitle**: Verifies that a different title is normalized to a job category.
- **testNormalizeNoMatch**: Verifies that a title with no match returns `null`.
- **testCalculateQualityScoreExactMatch**: Verifies the quality score calculation for an exact match.
- **testCalculateQualityScorePartialMatch**: Verifies the quality score calculation for a partial match.
- **testCalculateQualityScoreNoMatch**: Verifies the quality score calculation for no match.

## Running Tests

To run the tests, use the following command:

```sh
mvn test
```

**Ensure that the project is correctly set up with all necessary dependencies before running the tests.**

##Conclusion
his project provides a comprehensive solution for normalizing job titles and calculating their quality scores.