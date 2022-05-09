package com.nojong.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
*   @RunWith
*   - JUnit 내장된 실행자 외 다른 실행자를 실행시킨다.
*   - SpringBootTest와 JUnit 사이에 연결자 역할을 한다.
*
*   @WebMvcTest
*   - Web에 집중할 수 있는 어노테이션.
*   - @Controller, @controllerAdvice 등 사용 가능하지만, @Service, @Component, @Repository 사용 불가.
* */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    /*
    *   MockMvc
    *   - Web API 테스트 시 사용
    *   - Spring MVC Test의 시작점
    *   - 해당 클래스로 HTTP GET, POST 등에 대한 API Test 가능.
    * */
    @Autowired
    private MockMvc mvc;

    @Test
    public void Hello_Return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void HelloDto_Return() throws Exception {
        String name = "hello";
        int amount = 1000;

        /*
        *   param()
        *   - String만 허용.
        *   jsonPath()
        *   - JSON 응답값을 필드별로 검증할 수 있는 메소드.
        *   - $를 기준으로 필드명을 명시.
        *       => $.name -> name
        * */
        mvc.perform(get("/hello/dto")
                            .param("name", name)
                            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}