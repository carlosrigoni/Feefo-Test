package com.feefo.demo.domain.jobtitle;

import com.feefo.demo.domain.validation.Error;
import com.feefo.demo.domain.validation.ValidationHandler;
import com.feefo.demo.domain.validation.Validator;

public class JobTitleValidator extends Validator {

  public static final int TITLE_MAX_LENGTH = 255;
  public static final int TITLE_MIN_LENGTH = 3;
  private final JobTitle jobTitle;

  public JobTitleValidator(final JobTitle aJobTitle, final ValidationHandler aHandler) {
    super(aHandler);
    this.jobTitle = aJobTitle;
  }

  @Override
  public void validate() {
    checkTitleConstraints();
  }

  private void checkTitleConstraints() {
    final var title = this.jobTitle.getTitle();
    if (title == null) {
      this.validationHandler().append(new Error("'title' should not be null"));
      return;
    }

    if (title.isBlank()) {
      this.validationHandler().append(new Error("'title' should not be empty"));
      return;
    }

    final int length = title.trim().length();
    if (length > TITLE_MAX_LENGTH || length < TITLE_MIN_LENGTH) {
      this.validationHandler().append(new Error("'title' must be between 3 and 255 characters"));
    }
  }
}
