   package com.eglab.intelli.video.admin.domain.validation.handler;

import java.util.List;

import com.eglab.intelli.video.admin.domain.exceptions.DomainException;
import com.eglab.intelli.video.admin.domain.validation.Error;
import com.eglab.intelli.video.admin.domain.validation.ValidationHandler;

public class ThrowsValidationHandler implements ValidationHandler{

    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Error(ex.getMessage()));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getErrors'");
    }

}
