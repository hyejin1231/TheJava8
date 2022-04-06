package com.myJava.practice.optional;

import java.util.ArrayList;
import java.util.List;

// Optional
public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
//        System.out.println(studyDuration); // ERROR !  Progress가 null

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Progress progress = spring_boot.getProgress();
        if (progress != null) { // 이런 코드는 에러를 만들기 딱 좋은 코드 null 체크를 까먹을 수 있기 때문이다.
            System.out.println(progress.getStudyDuration());
        }




    }
}
