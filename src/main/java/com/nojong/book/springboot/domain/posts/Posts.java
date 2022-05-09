package com.nojong.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/*
*   @Entity
*   - JPA 어노테이션
*   - 테이블과 링크될 클래스임을 나타낸다.
*   - Default : 클래스의 카멜케이스 이름을 언더스코어(_) 네이밍으로 테이블 이름을 매칭한다.
*       => ContractInfo.java -> contract_info table
* */
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    /*
    *   @Id
    *   - PK 필드를 가리킨다.
    *
    *   @GeneratedValue
    *   - PK의 생성 규칙을 가리킨다.
    *   - Spring Boot 2.0 Ver. 에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 된다.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
