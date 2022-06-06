package com.nojong.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
*   JpaRepository<Entity Class, PrimaryKey Type>
* */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECt p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
