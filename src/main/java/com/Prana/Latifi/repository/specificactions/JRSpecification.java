package com.Prana.Latifi.repository.specificactions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class JRSpecification {

    public static <S> Predicate inNotEqual(List<S> list, String path, From root, CriteriaBuilder builder) {
        Predicate result = builder.isNotNull(root.get("id"));
        for (S s : list)
            result = builder.and(result, builder.notEqual(root.get(path), s));
        return result;
    }

    public static <S> Predicate inEqual(List<S> list, String path, From root, CriteriaBuilder builder) {
        Predicate result = builder.equal(root.get(path), list.get(0));
        for (S s : list)
            result = builder.or(result, builder.equal(root.get(path), s));
        return result;
    }

}