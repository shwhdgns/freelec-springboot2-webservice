package com.nojong.book.springboot.service.posts;

import com.nojong.book.springboot.domain.posts.Posts;
import com.nojong.book.springboot.domain.posts.PostsRepository;
import com.nojong.book.springboot.web.dto.PostsListResponseDto;
import com.nojong.book.springboot.web.dto.PostsResponseDto;
import com.nojong.book.springboot.web.dto.PostsSaveRequestDto;
import com.nojong.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        return new PostsResponseDto(entity);
    }

    /*
    * readOnly = true : 트랜잭션 범위는 유지하고 조회 기능만 남겨두어 조회 속도가 개선됨.
    * */
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                // .map(PostsListResponseDto::new)
                // => .map(posts -> new PostsListResponseDto(posts))
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
