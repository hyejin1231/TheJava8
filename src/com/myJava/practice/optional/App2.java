package com.myJava.practice.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Optional API
public class App2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream().filter(s -> s.getTitle().startsWith("spring")).findFirst();

        boolean present = spring.isPresent();
        System.out.println("present = " + present);


        Optional<OnlineClass> jpa = springClasses.stream().filter(s -> s.getTitle().startsWith("jpa")).findFirst();

        boolean empty = jpa.isEmpty();
        System.out.println("empty = " + empty);

        OnlineClass onlineClass = spring.get();
        System.out.println("onlineClass.getTitle() = " + onlineClass.getTitle());

//        OnlineClass onlineClass1 = jpa.get(); // 없으면 null (확인한번 해야함)
//        System.out.println("onlineClass1.getTitle() = " + onlineClass1.getTitle());
        
        jpa.ifPresent(j -> System.out.println("j.getTitle() = " + j.getTitle()));

        // .orElse()
        OnlineClass onlineClass1 = jpa.orElse(createNewClasses()); // jpa가 없기 때문에 새로운 클래스를 만들었음
        System.out.println("onlineClass1.getTitle() = " + onlineClass1.getTitle());

        // . orElseGet() 있으면 가져오고 없으면~~
        OnlineClass onlineClass2 = spring.orElseGet(App2::createNewClasses);
        System.out.println("onlineClass2.getTitle() = " + onlineClass2.getTitle());

        OnlineClass onlineClass3 = jpa.orElseGet(App2::createNewClasses);
        System.out.println("onlineClass3.getTitle() = " + onlineClass3.getTitle());

        // .orElseThrow : 대안이 없는 경우에는 throw
        OnlineClass onlineClass4 = jpa.orElseThrow(IllegalStateException::new);
        System.out.println("onlineClass4.getTitle() = " + onlineClass4.getTitle());
    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "NEW CLASSES", false);
    }
}
