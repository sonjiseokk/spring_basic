package hello2.core2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/**
 * 수동으로 등록 해주는 AppConfig.class와의 충돌을 피하기 위해 필터를 설정해주는 것
 * 거기도 Configuration이 붙어있는데 이것도 Component로 선언되어있음.
 * 실제로는 보통 안해요
 * 기존 코드를 살리기위해 넣은 필터
 */
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,classes = Configuration.class
        )
)

public class AutoAppConfig {

}
