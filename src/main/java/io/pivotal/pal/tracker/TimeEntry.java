package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
        this.projectId = projectId;
        this.userId=userId;
        this.date=parse;
        this.hours=i;
    }
    public TimeEntry(long timeEntryId,long projectId, long userId, LocalDate parse, int i) {
        this.id=timeEntryId;
        this.projectId = projectId;
        this.userId=userId;
        this.date=parse;
        this.hours=i;
    }

    public TimeEntry() {

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object timeEntry){
        return (this.hours==((TimeEntry)timeEntry).hours && this.userId == ((TimeEntry)timeEntry).userId /*&& this.date.equals(((TimeEntry)timeEntry).date) */&& this.projectId == ((TimeEntry)timeEntry).projectId);
    }

}
