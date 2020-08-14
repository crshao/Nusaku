package com.example.nusaku.manager;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class DefaultResponse {
    @SerializedName("msg")
    private String msg;

    @SerializedName("code")
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DefaultResponse{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
