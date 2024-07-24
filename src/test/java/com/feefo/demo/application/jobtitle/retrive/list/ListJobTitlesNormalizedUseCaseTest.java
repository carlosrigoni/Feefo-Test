package com.feefo.demo.application.jobtitle.retrive.list;

import com.feefo.demo.domain.jobtitle.JobTitleGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ListJobTitlesNormalizedUseCaseTest {

        private JobTitleGateway jobTitleGateway;
        private DefaultListJobTitlesNormalizedUseCase useCase;

        @BeforeEach
        void setUp() {
                jobTitleGateway = Mockito.mock(JobTitleGateway.class);
                useCase = new DefaultListJobTitlesNormalizedUseCase(jobTitleGateway);
        }

        @Test
        void testExecuteWithExactMatch() {
                // Arrange
                when(jobTitleGateway.normalizeJobTitle("Architect")).thenReturn("Architect");

                // Act
                String result = useCase.execute("Architect");

                // Assert
                assertEquals("Architect", result);
                verify(jobTitleGateway, times(1)).normalizeJobTitle("Architect");
        }

        @Test
        void testExecuteWithSimilarMatch() {
                // Arrange
                when(jobTitleGateway.normalizeJobTitle("software Engineer")).thenReturn("Software engineer");

                // Act
                String result = useCase.execute("software Engineer");

                // Assert
                assertEquals("Software engineer", result);
                verify(jobTitleGateway, times(1)).normalizeJobTitle("software Engineer");
        }

        @Test
        void testExecuteWithDifferentTitle() {
                // Arrange
                when(jobTitleGateway.normalizeJobTitle("Chief Accountant")).thenReturn("Accountant");

                // Act
                String result = useCase.execute("Chief Accountant");

                // Assert
                assertEquals("Accountant", result);
                verify(jobTitleGateway, times(1)).normalizeJobTitle("Chief Accountant");
        }

        @Test
        void testExecuteWithNoMatch() {
                // Arrange
                when(jobTitleGateway.normalizeJobTitle("Random Title")).thenReturn(null);

                // Act
                String result = useCase.execute("Random Title");

                // Assert
                assertNull(result);
                verify(jobTitleGateway, times(1)).normalizeJobTitle("Random Title");
        }

        @Test
        void testExecuteWithEmptyTitle() {
                // Arrange
                when(jobTitleGateway.normalizeJobTitle("")).thenReturn(null);

                // Act
                String result = useCase.execute("");

                // Assert
                assertNull(result);
                verify(jobTitleGateway, times(1)).normalizeJobTitle("");
        }
}
