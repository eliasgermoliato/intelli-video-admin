package com.eglab.intelli.video.admin.application.category.create;

import com.eglab.intelli.video.admin.domain.category.Category;
import com.eglab.intelli.video.admin.domain.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {

    public static CreateCategoryOutput from(final Category aCategory){
        return new CreateCategoryOutput(aCategory.getId());
    }
}
