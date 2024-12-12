package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

public class Event {

    // task 0

    private Integer eventId; 
    private String eventName; 
    private Integer eventSize; 
    private Integer eventDate; 
    private Integer participants;

    private Date newDate;
    
    // constructors
    public Event() {
    }

    public Event(Integer eventId, String eventName, Integer eventSize, Integer eventDate, Integer participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;

        // this.newDate = newDate;

    }


    // getter setters 
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventSize() {
        return eventSize;
    }

    public void setEventSize(Integer eventSize) {
        this.eventSize = eventSize;
    }

    public Integer getEventDate() {
        return eventDate;
    }

    public void setEventDate(Integer eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }


    // new date in Date format
    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }


    // toString()
    @Override
    public String toString() {
        return eventId + "," + eventName + "," + eventSize + "," + eventDate + "," + participants;
    }

     
}
