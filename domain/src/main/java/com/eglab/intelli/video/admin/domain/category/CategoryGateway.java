package com.eglab.intelli.video.admin.domain.category;

import java.util.Optional;

import com.eglab.intelli.video.admin.domain.exceptions.Pagination;

public interface CategoryGateway {

    Category create(Category aCategory);

    void deleteById(CategoryID anId);

    Optional<Category> findById(CategoryID anId);

    Category update(Category aCategory);

    Pagination<Category> findAll(CategorySearchQuery aQuery);
}
