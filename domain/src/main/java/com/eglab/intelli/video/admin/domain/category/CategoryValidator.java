package com.eglab.intelli.video.admin.domain.category;

import com.eglab.intelli.video.admin.domain.validation.ValidationHandler;
import com.eglab.intelli.video.admin.domain.validation.Validator;
import com.eglab.intelli.video.admin.domain.validation.Error;

public class CategoryValidator extends Validator {
    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler){
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate(){
        if (this.category.getName() == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
        }
    }

}
