package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
public class ResponsesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private EventData eventData;

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



    @Lob
    @Column(name = "invitee_image_data")
    private byte[] invitationImageData;


    public boolean getAttendFlag() {
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

    public boolean isAttendFlag() {
        return attendFlag;
    }

    public String getInviteeName() {
        return inviteeName;
    }

    public void setInviteeName(String inviteeName) {
        this.inviteeName = inviteeName;
    }

    public byte[] getInvitationImageData() {
        return invitationImageData;
    }

    public void setInvitationImageData(byte[] invitationImageData) {
        this.invitationImageData = invitationImageData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getInviteeImageUrl() {
        return inviteeImageUrl;
    }

    public void setInviteeImageUrl(String inviteeImageUrl) {
        this.inviteeImageUrl = inviteeImageUrl;
    }

    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }
}
