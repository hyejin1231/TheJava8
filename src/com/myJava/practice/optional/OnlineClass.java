package com.myJava.practice.optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    private Progress progress;

//    private Optional<Progress> progress; 이렇게 사용하는건 권장 X


    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    // 어떻게 보면 null을 리턴하는 것 자체가 문제다.
    public Progress getProgress() {
        if (this.progress == null) {
            throw new IllegalStateException(); // null을 체크해서 Exception을 발생시킨다.
        }
        return progress;
    }

    // Optional 이용 -> 리턴 타입으로만 쓰는것이 좋다!
    // .of() 안에 들어오는 건 null 이 아닐 경우라고 가정! -> null 이면 NPE 발생
//    public Optional<Progress> getProgress() {
//        return Optional.ofNullable(progress);
//    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
