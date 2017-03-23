package org.sri.javaInterview;

import java.util.Date;
public final class ImmutableReminder{
    
    private final Date remindingDate;
  
    public ImmutableReminder (Date remDate) {
        if(remDate.getTime() < System.currentTimeMillis()){
            throw new IllegalArgumentException("Can’t set reminder for past time: " + remDate);
        }
        this.remindingDate = new Date(remDate.getTime());
    }
  
    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}


