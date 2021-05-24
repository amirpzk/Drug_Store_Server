package com.Prana.Latifi.repository.specificactions;

import com.Prana.Latifi.entity.Item;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class ItemSpecification implements Specification<Item> {

  private long id;
  private String title;
  private long lowPrice;
  private long highPrice;
  private List<Long> categoryIds;

  public ItemSpecification(
      long id, String title, long lowPrice, long highPrice, List<Long> categoryIds) {
    this.id = id;
    this.title = title;
    this.lowPrice = lowPrice;
    this.highPrice = highPrice;
    this.categoryIds = categoryIds;
  }

  @Override
  public Predicate toPredicate(
      Root<Item> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    Join categoryJoin = null;
    Predicate result = criteriaBuilder.isNotNull(root.get("id"));
    if (id != 0) {
      result =
          criteriaBuilder.and(
              criteriaBuilder.isNotNull(root.get("id")), criteriaBuilder.equal(root.get("id"), id));
    } else {
      if (title != null && !title.isEmpty())
        result =
            criteriaBuilder.and(result, criteriaBuilder.like(root.get("title"), "%" + title + "%"));
      if (lowPrice != 0 && highPrice != 0) {
        result =
            criteriaBuilder.and(
                result, criteriaBuilder.greaterThanOrEqualTo(root.get("price"), lowPrice));
        result =
                criteriaBuilder.and(
                        result, criteriaBuilder.lessThanOrEqualTo(root.get("price"), highPrice));
      }
      if (categoryIds != null && !categoryIds.isEmpty()) {
        categoryJoin = root.join("categories");
        result =
            criteriaBuilder.and(
                result, JRSpecification.inEqual(categoryIds, "id", categoryJoin, criteriaBuilder));
      }
    }
    return result;
  }
}
