package com.eglab.intelli.video.admin.domain.category;

import com.eglab.intelli.video.admin.domain.validation.ValidationHandler;
import com.eglab.intelli.video.admin.domain.validation.Validator;
import com.eglab.intelli.video.admin.domain.validation.Error;

public class CategoryValidator extends Validator {
    private final Category category;
    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;

    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler){
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate(){
        checkNameConstraints();
    }

    private void checkNameConstraints(){
        final var name = this.category.getName();
        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final int nameLength = name.trim().length();
        if (nameLength > NAME_MAX_LENGTH || nameLength < NAME_MIN_LENGTH){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

}
