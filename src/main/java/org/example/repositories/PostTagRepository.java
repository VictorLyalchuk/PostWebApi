package org.example.repositories;

import org.example.entities.PostTagMapEntity;
import org.example.entities.PostTagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository extends JpaRepository<PostTagMapEntity, PostTagPK> {
}
