package com.nojong.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*       @SpringBootApplication
*       - SpringBoot Auto Config, Bean Auto Read and Create
*       - 해당 어노테이션이 위치하는 곳부터 설정을 읽어가기 때문에 항상 최상단에 위치해야 함.
*/

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
        *   SpringApplication.run
        *   - SpringBoot 내장 WAS로 서버를 실행.
        *   - 이점 : 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있다.
        *           외장 WAS를 사용하는 경우 모든 서버는 항상 같은 WAS의 종류와 버전 설정을 일치시켜야만 함.
        *           ** 성능 상 전혀 이슈 없음.
        * */
        SpringApplication.run(Application.class, args);
    }
}
