package com.example.projects.task_mannager;

import java.sql.Date;
import java.sql.Timestamp;

public class task {
    int ID;
    String TASK;
    String DESCRIPTION;
    Date DUE_DATE;
    Timestamp START_DATE;
    Timestamp END_DATE;
    String STATUS;
    String PRIORITY;

    // Constructor
    public task(int ID, String TASK, String DESCRIPTION, Date DUE_DATE, Timestamp START_DATE, Timestamp END_DATE, String STATUS, String PRIORITY) {
        this.ID = ID;
        this.TASK = TASK;
        this.DESCRIPTION = DESCRIPTION;
        this.DUE_DATE = DUE_DATE;
        this.START_DATE = START_DATE;
        this.END_DATE = END_DATE;
        this.STATUS = STATUS;
        this.PRIORITY = PRIORITY;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTASK() {
        return TASK;
    }

    public void setTASK(String TASK) {
        this.TASK = TASK;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Date getDUE_DATE() {
        return DUE_DATE;
    }

    public void setDUE_DATE(Date DUE_DATE) {
        this.DUE_DATE = DUE_DATE;
    }

    public Timestamp getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Timestamp START_DATE) {
        this.START_DATE = START_DATE;
    }

    public Timestamp getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Timestamp END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(String PRIORITY) {
        this.PRIORITY = PRIORITY;
    }
}
