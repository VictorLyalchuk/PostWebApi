package org.example.repositories;

import org.example.entities.TagEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
    TagEntity findByName(String name);
}
