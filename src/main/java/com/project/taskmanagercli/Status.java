package com.project.taskmanagercli;

public enum Status {
    TODO("todo"),
    MARK_IN_PROGRESS("masrk_in_progess") ,
    DONE("done");

    private final String value;

    Status(String value) {

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Status{" +
                "value='" + value + '\'' +
                '}';
    }

//    Status(String todo) {
//    }
//        @Override
//    public String toString() {
//        return "Status{}";
//    }
}
