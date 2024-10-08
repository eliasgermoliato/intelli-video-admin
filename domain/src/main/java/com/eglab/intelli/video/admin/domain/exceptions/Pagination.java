package com.eglab.intelli.video.admin.domain.exceptions;

import java.util.List;

public record Pagination<T>(
    int currentPage,
    int perPage,
    long total,
    List<T> items
) {

}
