package com.example.RegisterLogin.Dto;

import com.example.RegisterLogin.Entity.ResponsesData;

import java.util.Base64;

public class ResponseDataDTO {

    private Long id;
    private Long eventId;
    private boolean attendFlag;
    private String customResponse;
    private String response1;
    private String response2;
    private String response3;
    private String response4;
    private String response5;
    private String customAnswer;
    private String inviteeName;
    private String inviteeImageUrl;
    private String invitationImageBase64;

    private String eventTitle;

    // Constructors
    public ResponseDataDTO() {}

    public ResponseDataDTO(ResponsesData data) {
        this.id = data.getId();
        this.attendFlag = data.isAttendFlag();
        this.customResponse = data.getCustomResponse();
        this.response1 = data.getResponse1();
        this.response2 = data.getResponse2();
        this.response3 = data.getResponse3();
        this.response4 = data.getResponse4();
        this.response5 = data.getResponse5();
        this.customAnswer = data.getCustomAnswer();
        this.inviteeName = data.getInviteeName();
        this.inviteeImageUrl = data.getInviteeImageUrl();
        if (data.getInvitationImageData() != null) {
            this.invitationImageBase64 = Base64.getEncoder().encodeToString(data.getInvitationImageData());
        }
        if (data.getEventData() != null) {
            this.eventTitle = data.getEventData().getEventTitle();
        }
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public String getInvitationImageBase64() {
        return invitationImageBase64;
    }

    public void setInvitationImageBase64(String invitationImageBase64) {
        this.invitationImageBase64 = invitationImageBase64;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public boolean isAttendFlag() {
        return attendFlag;
    }

    public void setAttendFlag(boolean attendFlag) {
        this.attendFlag = attendFlag;
    }

    public String getCustomResponse() {
        return customResponse;
    }

    public void setCustomResponse(String customResponse) {
        this.customResponse = customResponse;
    }

    public String getResponse1() {
        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getResponse4() {
        return response4;
    }

    public void setResponse4(String response4) {
        this.response4 = response4;
    }

    public String getResponse5() {
        return response5;
    }

    public void setResponse5(String response5) {
        this.response5 = response5;
    }

    public String getCustomAnswer() {
        return customAnswer;
    }

    public void setCustomAnswer(String customAnswer) {
        this.customAnswer = customAnswer;
    }

    public String getInviteeName() {
        return inviteeName;
    }

    public void setInviteeName(String inviteeName) {
        this.inviteeName = inviteeName;
    }

    public String getInviteeImageUrl() {
        return inviteeImageUrl;
    }

    public void setInviteeImageUrl(String inviteeImageUrl) {
        this.inviteeImageUrl = inviteeImageUrl;
    }
}