package org.sri.javaInterview;

import java.util.Date;

public class ImmutableReminderImpl {
	
	public static void main(String [] args){
		ImmutableReminder ir = new ImmutableReminder(new Date());
		Date remind = ir.getRemindingDate();
		System.out.println(remind);
	}
}
