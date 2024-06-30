package com.client.challenge.ec.ws.common;

public class StandardApiExceptionResponse {


    private String title;

    private String code;

    private String detail;


    public StandardApiExceptionResponse(String title, String code, String detail) {
        super();
        this.title = title;
        this.code = code;
        this.detail = detail;
    }       
       
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return code;
    }

    public void setStatus(String status) {
        this.code = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
