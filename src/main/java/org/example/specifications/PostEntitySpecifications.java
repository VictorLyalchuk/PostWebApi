package org.example.specifications;

import org.example.entities.PostEntity;
import org.springframework.data.jpa.domain.Specification;
public class PostEntitySpecifications {
    public static Specification<PostEntity> findByCategoryId(int categoryId) {
        return (root, query, criteriaBuilder) -> {
            //criteriaBuilder.
            if (categoryId == 0) {
                return criteriaBuilder.notEqual(root.get("category").get("id"), 0);
            } else {
                return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
            }
        };
    }

    public static Specification<PostEntity> findByTag(String tag) {
        return (root, query, cb) -> {
            return cb.like(root.get("tag"), "%"+tag+"%");
        };
    }

}
