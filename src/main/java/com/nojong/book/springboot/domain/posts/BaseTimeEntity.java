package com.nojong.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
*   @MappedSuperclass
*   - JPA Entity 클래스가 해당 클래스를 상속하는 경우 해당 클래스에 선언된 필드들도 컬럼으로 인식하게 하는 어노테이션.
*
*   @EntityListeners(AuditingEntityListener.class)
*   - 해당 어노테이션이 선언된 클래스에 Auditing 기능을 포함시킨다.
*
* */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /*
    *   @CreatedDate
    *   - Entity가 생성되어 저장될 때 시간이 자동으로 저장된다.
    * */
    @CreatedDate
    private LocalDateTime createdDate;

    /*
    *   @LastModifiedDate
    *   - 조회한 Entity의 값을 변경할 때 시간이 자동으로 저장된다.
    *
    * */
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
