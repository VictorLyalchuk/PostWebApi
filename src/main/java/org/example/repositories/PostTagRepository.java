package org.example.repositories;

import org.example.entities.PostEntity;
import org.example.entities.PostTagMapEntity;
import org.example.entities.PostTagPK;
import org.example.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends JpaRepository<PostTagMapEntity, PostTagPK> {
    List<PostTagMapEntity> findByPost(PostEntity post);
    List<PostTagMapEntity> findByTag(TagEntity tag);
    List<PostTagMapEntity> findByPostIn(List<PostEntity> posts);
    void deleteByPost(PostEntity post);

}
