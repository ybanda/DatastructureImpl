/**
 * 
 */
package com.ocajp8.ch4.arrays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

/**
 * @author Yashwanth
 *
 */
public class CalendarImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//localDateImpl();
		//localTimeImpl();

		//periodImpl();
		dateTimeFormatterImpl();
	}

	/**
	 * 
	 */
	public static void localDateImpl(){

		LocalDate localDate = LocalDate.of(1991,4, 2);
		System.out.println("Date 1 :: "+localDate.toString()+"\t Day of Month ::"
		+localDate.get(ChronoField.DAY_OF_MONTH)+"\t Day of Month ::"+localDate.getDayOfMonth()
		+"\t Day of Year::"+localDate.getDayOfYear()+"\t Month::"+localDate.getMonthValue()
		+"\t"+localDate.lengthOfYear() +" Current DAte :: "+LocalDate.now());
		
		LocalDate localDate1 = LocalDate.parse("2071-08-09");
		System.out.println(localDate1.toString());
	
		LocalDate yBDay = LocalDate.parse("1991-04-02");
		LocalDate xBDay = LocalDate.parse("1990-04-02");
		System.out.println("yBDay is After xBDay::"+yBDay.isAfter(xBDay));
		System.out.println("yBDay is Before xBDay::"+yBDay.isBefore(xBDay));
		System.out.println("----------------Local Date ---------   ::"+localDate.toString());
		System.out.println("Local Date - 10 days   ::"+localDate.minusDays(10));
		System.out.println("Local Date - 10 mONTHS ::"+localDate.minusMonths(10));
		System.out.println("Local Date - 10 Weeks  ::"+localDate.minusWeeks(10));
		System.out.println("Local Date - 10 Years  ::"+localDate.minusYears(10));
		
		System.out.println("++++++++++++++++Local Date +++++++++   ::"+localDate.toString());
		System.out.println("Local Date + 10 days   ::"+localDate.plusDays(10));
		System.out.println("Local Date + 10 mONTHS ::"+localDate.plusMonths(10));
		System.out.println("Local Date + 10 Weeks  ::"+localDate.plusWeeks(10));
		System.out.println("Local Date + 10 Years  ::"+localDate.plusYears(10));
		
		LocalDate localDate2 = LocalDate.parse("2071-08-09");
		System.out.println(localDate2.withDayOfMonth(1));
		System.out.println(localDate2.withDayOfYear(1));
		System.out.println(localDate2.withMonth(1));
		System.out.println(localDate2.withYear(1999));
		System.out.println(localDate2.toEpochDay());
		System.out.println(localDate2.atTime(14,33,33,300));
	}
	
	/**
	 * 
	 */
	public static void localTimeImpl(){

		LocalTime localTime = LocalTime.of(12, 12,11,12222);
		System.out.println("Local Time :: "+localTime.of(19,12,11,2222));
		LocalTime localTime1 = LocalTime.parse("15:11:59");
		System.out.println(localTime1.toString() +" Local Time :: Min ::"+
		LocalTime.MIN +" Max :: "+LocalTime.MAX+":: Mid ::"+LocalTime.MIDNIGHT+" :: Noon :: "+LocalTime.NOON);
		System.out.println(" Hours :: "+localTime1.getHour()+"\t Minutes ::"+localTime1.getMinute()+"\t Seconds ::"+localTime1.getSecond()+" \t Nano :: "+localTime1.getNano());

		System.out.println(" Hours -1 :: "+localTime1.minusHours(1)+"\t Minutes -10 ::"+localTime1.minusMinutes(10)+
				"\t Seconds -10 ::"+localTime1.minusSeconds(10)+" \t Nano - 100:: "+localTime1.minusMinutes(-100));

		LocalDateTime dateTime = localTime.atDate(LocalDate.now());
		System.out.println(dateTime.toString());
		System.out.println("Local Date Time :: Now :: "+LocalDateTime.now());
		
	}
	
	/**
	 * 
	 */
	public static void periodImpl(){

		Period period1 = Period.of(1, 9, 9);
		System.out.println(period1.toString());
		period1=period1.minusDays(15).multipliedBy(10);
		System.out.println(period1.toString());
		Period period2 = Period.ofYears(2);
		System.out.println(period2.toString());
		Period period3 = Period.ofMonths(23);
		System.out.println(period3.toString());
		Period period4 = Period.ofWeeks(-59);
		System.out.println(period4.toString());
		Period period5 = Period.ofDays(-32);
		System.out.println(period5.toString());

		Period p5yrs1 = Period.parse("P5Y");
		Period p5yrs2 = Period.parse("-p-5y");
		Period p5yrs3 = Period.parse("p-5y1M2D");
		System.out.println(" .. "+p5yrs1 +" .. "+p5yrs2+" .. "+p5yrs3);
		
		LocalDate yDay = LocalDate.of(1991, 4, 2);
		
		Period periodBtw = Period.between(yDay,LocalDate.now());
		System.out.println(periodBtw);
		System.out.println(periodBtw.toTotalMonths());

		System.out.println(periodBtw.negated());
	
	}
	
	/**
	 * 
	 */
	public static void dateTimeFormatterImpl(){

		DateTimeFormatter format_medium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter format_full = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter format_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		DateTimeFormatter format_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		
		DateTimeFormatter format_medium_Time = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		DateTimeFormatter format_full_Time = DateTimeFormatter.ofPattern("yyyy-MM-dd hh");
		DateTimeFormatter format_long_Time = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
		DateTimeFormatter format_short_Time = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		
		DateTimeFormatter format_medium_DateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,FormatStyle.MEDIUM);
		DateTimeFormatter format_full_DateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.FULL);
		DateTimeFormatter format_long_DateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG,FormatStyle.LONG);
		DateTimeFormatter format_short_DateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT);
				
//		DateTimeFormatter format_short_time = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
//		DateTimeFormatter format_short_datetime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT);

		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println("Local Date :: format_medium ::  "+localDate.format(format_medium));
		System.out.println("Local Date :: format_full   ::  "+localDate.format(format_full));
		System.out.println("Local Date :: format_long   ::  "+localDate.format(format_long));
		System.out.println("Local Date :: format_short  ::  "+localDate.format(format_short));

		
		System.out.println("localTime :: format_medium ::  "+format_medium_Time.format(localTime));
		System.out.println("localTime :: format_full   ::  "+format_full_Time.format(localDate));
	//	System.out.println("localTime :: format_long   ::  "+localTime.format(format_long_Time));
	//	System.out.println("localTime :: format_short  ::  "+localTime.format(format_short_Time));
		
		System.out.println("localDateTime:: format_medium ::  "+localDateTime.format(format_medium_DateTime));
//		System.out.println("localDateTime :: format_full   ::  "+localDateTime.format(format_full_DateTime));
//		System.out.println("localDateTime:: format_long   ::  "+localDateTime.format(format_long_DateTime));
//		System.out.println("localDateTime:: format_short  ::  "+localDateTime.format(format_short_DateTime));
//		
		
	}

}
