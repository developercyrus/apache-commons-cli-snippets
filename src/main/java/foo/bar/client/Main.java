package foo.bar.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
	public static void daily(LocalDate d, int daysToAdd) {
		LocalDate date = d.plusDays(daysToAdd);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("today         = " + dtf.format(d));
		System.out.println("required date = " + dtf.format(date));  
	}
	
	public static void monthly(LocalDate d, int monthsToAdd) {
		// first day of n month 
		LocalDate startDate = d.plusMonths(monthsToAdd).withDayOfMonth(1);	
		// first day of n+1 month
		LocalDate endDate = d.plusMonths(monthsToAdd).withDayOfMonth(startDate.lengthOfMonth()).plusDays(1);	

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("today         = " + dtf.format(d));
		System.out.println("start date    = " + dtf.format(startDate));  
		System.out.println("end ate       = " + dtf.format(endDate)); 		
	}
}
