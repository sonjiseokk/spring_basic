package hello2.core2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    //  클래스 레벨에 올라가는거라 싱글톤
    
    public static SingletonService getInstance(){
        return instance;
    }

    /***
     *  생성은 외부에서 하지 못하게 제한해둠
     *  new 로 외부에서 만들면 싱글톤을 충족하지 못하기 때문에
     */

    private SingletonService() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
