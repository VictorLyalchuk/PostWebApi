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
@Table(name="tbl_posts_images")
public class PostImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 500, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="post_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostEntity post;
}
