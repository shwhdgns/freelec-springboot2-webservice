package com.nojong.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
*   JpaRepository<Entity Class, PrimaryKey Type>
* */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
