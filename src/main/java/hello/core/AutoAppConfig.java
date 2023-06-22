package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 이 경로 하위 패키지부터 찾아감
        // 지정 안하면? 디폴트 -> 이게 위치한 경로부터 하위 패키지 (hello.core.*)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
