package com.rms.workerservice.core;

public class State {
    private final long id;
    private final String content;

    public State(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
