package com.grx10.solar.model;

public class LeadCaptureResponse {

    private String message;

//    public LeadCaptureResponse(String message) {
//        this.message = message;
//    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LeadCaptureResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
