package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Message {

    @JsonProperty("message")
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
