package com.myJava.practice.CompletableFuture;

import java.lang.annotation.*;

@Repeatable(Chicken2Container.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE) // 타입 사용하는 모든 곳에 사용 가능
public @interface Chicken2 {
    String value();
}
