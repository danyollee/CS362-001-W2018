package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  { //Tests to see if the constructor works correctly
	 	Calendar cal = Calendar.getInstance();
	 	int day = cal.get(Calendar.DAY_OF_MONTH);
	 	int month = cal.get(Calendar.MONTH);
	 	int year = cal.get(Calendar.YEAR);

	 	GregorianCalendar gregCal = new GregorianCalendar(year, month, day);

		CalDay calday1 = new CalDay(gregCal);

		assertEquals(true, calday1.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  { //Tests to see if the constructor with empty parameters returns false
		 CalDay calday1 = new CalDay();

		 assertEquals(false, calday1.isValid());
	 }
//add more unit tests as you needed

	@Test
	public void test03() throws Throwable { //Adds appointments to the calday
		int startHour1=3;
		int startMinute1=24;
		int startDay1=19;
		int startMonth1=6;
		int startYear1=1997;
		String title1="This is my birthday";
		String description1="This is the day I was born";
		int day = 19;
		int month = 06;
		int year = 1997;

		GregorianCalendar gregCal = new GregorianCalendar(year, month, day);

		Appt appt = new Appt (3, 24, 19, 6, 1997, "My birthday", "Day i was born");
		Appt appt2 = new Appt(7, 24, 15, 8, 1988, "Bro birthday", "Day brother was born");
		CalDay calday1 = new CalDay(gregCal);

		calday1.addAppt(appt);
		calday1.addAppt(appt2);

		Appt appt3 = new Appt(1, -1, 1, 1, 2016, "test", "desk");
		calday1.addAppt(appt3);


	}

	@Test
	public void test04() throws Throwable {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		GregorianCalendar gregCal = new GregorianCalendar(year, month, day);

		CalDay calday1 = new CalDay(gregCal);

		assertEquals(12, calday1.getDay());
		assertEquals(2, calday1.getMonth());
		assertEquals(2018, calday1.getYear());
		assertEquals(0, calday1.getSizeAppts());
	}

	@Test
	public void test05() throws Throwable {
		Calendar cal = Calendar.getInstance();
		int day = 29;
		int month = 1;
		int year = 2018;

		GregorianCalendar gregCal = new GregorianCalendar(year, month, day);
		LinkedList<Appt> appts = new LinkedList<Appt>();

		Appt appt = new Appt (3, 24, 29, 1, 2018, "My birthday", "Day i was born");
		Appt appt2 = new Appt(7, 24, 29, 1, 2018, "Bro birthday", "Day brother was born");

		appts.add(appt);
		appts.add(appt2);


		CalDay calday1 = new CalDay(gregCal);
		calday1.toString();

	}

	@Test
	public void test06() throws Throwable { //Tests the iterator function
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		GregorianCalendar gregCal = new GregorianCalendar(year, month, day);

		CalDay calday1 = new CalDay(gregCal);

		calday1.iterator();

		GregorianCalendar gregcal2 = new GregorianCalendar();
		CalDay calday2 = new CalDay();
		calday2.iterator();
	}

	@Test
	public void test07() throws Throwable {
		Appt appt = new Appt(50, 1, 1, 1, 1, "test", "desk");
		GregorianCalendar gregCal = new GregorianCalendar(2018, 1, 1);
		CalDay calday = new CalDay();
		calday.addAppt(appt);

		calday.toString();
		assertFalse(appt.getValid());
		assertNotEquals("test", calday.toString());
		assertEquals("", calday.toString());

	}

}
