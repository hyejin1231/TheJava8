package com.myJava.practice.CompletableFuture;

import java.util.Arrays;
import java.util.List;

// 중복 어노테이션 사용 가능 (설정만 해주면)
@Chicken2(value = "bbq")
@Chicken2(value = "kyochon")
@Chicken2(value = "bhc")
public class App11 {
    public static void main(String[] args) throws @Chicken RuntimeException{
        Chicken2[] chicken2s = Arrays.class.getAnnotationsByType(Chicken2.class);
        Arrays.stream(chicken2s).forEach(c -> System.out.println(c.value()));

        // 컨테이너로 가져오는 방법
        Chicken2Container chicken2Container = App.class.getAnnotation(Chicken2Container.class);
        Arrays.stream(chicken2Container.value()).forEach(c -> System.out.println(c.value()));
    }

}
