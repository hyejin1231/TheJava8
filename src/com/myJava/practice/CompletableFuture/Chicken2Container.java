package com.myJava.practice.CompletableFuture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE) // 타입 사용하는 모든 곳에 사용 가능
public @interface Chicken2Container {

    Chicken2[] value();
}
