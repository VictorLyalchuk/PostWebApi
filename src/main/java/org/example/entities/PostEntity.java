package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 500)
    private String shortDescription;

    @Column(length = 4000)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;

    private boolean isPublished;

    private boolean isPosted;

    private boolean isModified;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CategoryEntity category;

    @OneToMany(mappedBy="post")
    private List<PostImageEntity> postImages;

    @OneToMany(mappedBy = "post")
    private List<TagEntity> tags;
}
