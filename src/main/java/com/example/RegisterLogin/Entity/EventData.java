package com.example.RegisterLogin.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class EventData {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String eventTitle;
    private String eventVenue;
    private Date dateTime;
    private String customMessage;
    private String customQuestion;
    private String eventDetails;
    private boolean question1;
    private boolean question2;
    private boolean question3;
    private boolean question4;
    private boolean question5;

    private String invitationImageUrl; // For predefined theme images

    @Lob
    @Column(name = "invitation_image_data")
    private byte[] invitationImageData;


    public String getInvitationImageUrl() {
        return invitationImageUrl;
    }

    public void setInvitationImageUrl(String invitationImageUrl) {
        this.invitationImageUrl = invitationImageUrl;
    }

    public byte[] getInvitationImageData() {
        return invitationImageData;
    }

    public void setInvitationImageData(byte[] invitationImageData) {
        this.invitationImageData = invitationImageData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomQuestion() {
        return customQuestion;
    }

    public void setCustomQuestion(String customQuestion) {
        this.customQuestion = customQuestion;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public boolean isQuestion1() {
        return question1;
    }

    public void setQuestion1(boolean question1) {
        this.question1 = question1;
    }

    public boolean isQuestion2() {
        return question2;
    }

    public void setQuestion2(boolean question2) {
        this.question2 = question2;
    }

    public boolean isQuestion3() {
        return question3;
    }

    public void setQuestion3(boolean question3) {
        this.question3 = question3;
    }

    public boolean isQuestion4() {
        return question4;
    }

    public void setQuestion4(boolean question4) {
        this.question4 = question4;
    }

    public boolean isQuestion5() {
        return question5;
    }

    public void setQuestion5(boolean question5) {
        this.question5 = question5;
    }
}
