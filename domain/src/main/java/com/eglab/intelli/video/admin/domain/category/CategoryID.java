package com.eglab.intelli.video.admin.domain.category;

import java.util.Objects;
import java.util.UUID;

import com.eglab.intelli.video.admin.domain.Identifier;

public class CategoryID extends Identifier{

    private final String value;

    private CategoryID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique(){
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(final String anId){
        return new CategoryID(anId);
    }

    public static CategoryID from(final UUID anId){
        return new CategoryID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final CategoryID other = (CategoryID) obj;
        return value.equals(other.getValue());
    }


}
