package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  { //Tests the ceration of the timetable and the appt range
		 Appt appt = new Appt(1, 1, 1, 1, 2018, "test", "desk");
		 Appt appt2 = new Appt(2, 2, 2, 2, 2018, "test", "desk");
		 GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 2);
		 LinkedList<Appt> appts = new LinkedList();
		 TimeTable tt = new TimeTable();
		 tt.getApptRange(appts, gregcal, gregcal2);
	 }
	 @Test
	  public void test02()  throws Throwable  { //Tests to see if the second day is before the first day inputted
		 GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 2);
		 LinkedList<Appt> appts = new LinkedList();
		 TimeTable tt = new TimeTable();
		 try {
		 	tt.getApptRange(appts, gregcal2, gregcal);
		 } catch (DateOutOfRangeException e) {

		 }
	 }
//add more unit tests as you needed
	@Test
	public void test03() throws Throwable { //Tests to delete the appts from the linked list
	 	Appt appt = new Appt(-1, 1, 1, 1, 2018, "test", "desk");
		LinkedList<Appt> appts = new LinkedList<Appt>();
	 	TimeTable tt = new TimeTable();
	 	assertEquals(null, tt.deleteAppt(appts, appt));

	 	//Sends null values to the function
	 	LinkedList<Appt> appts2 = null;
		Appt appt2 = null;
		assertEquals(null, tt.deleteAppt(appts2, appt2));

		Appt appt3 = new Appt(1, 1, 1, 1, 1, "test", "desk");
		Appt appt4 = new Appt(2, 2, 2, 2, 2, "test", "desk");
		Appt appt5 = new Appt(3, 3, 3, 3, 3, "test", "desk");
		LinkedList<Appt> appts3 = new LinkedList<Appt>();
		appts3.add(appt3);
		appts3.add(appt4);
		appts3.add(appt5);
		tt.deleteAppt(appts3, appt4);
		assertEquals(2, appts3.size());
	}

	@Test
	public void test04() throws Throwable {
	 	TimeTable tt = new TimeTable();
		GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 16);
		LinkedList<Appt> appts = new LinkedList<Appt>();

		Appt appt = new Appt(1, 1, 2, 1, 2018, "test", "desk");
		Appt appt2 = new Appt(-1, 5, 4, 1, 2018, "test", "desk");
		Appt appt3 = new Appt(1, 10, 6, 1, 2018, "test", "desk");
		appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);

		tt.getApptRange(appts, gregcal, gregcal2);


	}

	@Test
	public void test05() throws Throwable {
		TimeTable tt = new TimeTable();
	 	LinkedList<Appt> appts = new LinkedList<Appt>();
		GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 16);

		Appt appt = new Appt(1, 1, 2, 2, 2018, "test", "desk");
		Appt appt2 = new Appt(1, 5, 4, 2, 2018, "test", "desk");
		Appt appt3 = new Appt(1, 10, 6, 2, 2018, "test", "desk");
		appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);

		int[] permute = {2, 1, 0};

		tt.permute(appts, permute);

		int[] permute2 = {2, 1, 0, 2};
		try {
			tt.permute(appts, permute2);
		} catch (IllegalArgumentException e) {

		}

	}

	@Test
	public void test06() throws Throwable { //Tests the recurring days
	 	TimeTable tt = new TimeTable();
	 	Appt appt = new Appt(1, 1, 1, 1, 2018, "test", "desk");
		GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 16);
		LinkedList<Appt> appts = new LinkedList<Appt>();

		int[] recurringDay = {2};
		appt.setRecurrence(recurringDay, 1, 1, 1);

		appts.add(appt);

		tt.getApptRange(appts, gregcal, gregcal2);
	}

	@Test
	public void test07() throws Throwable {
		Appt appt = new Appt(42, 1, 1, 1, 2018, "test", "desk");
		Appt appt2 = new Appt(2, 2, 2, 2, 2018, "test", "desk");
		GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 2);
		LinkedList<Appt> appts = new LinkedList();
		TimeTable tt = new TimeTable();

		appts.add(appt);
		appts.add(appt2);

		tt.getApptRange(appts, gregcal, gregcal2);
//		assertFalse(appt.g);
	}

	@Test
	public void test08() throws Throwable {
	 	Appt appt = new Appt(1, 1, 1, 1, 2018, "test", "desk");
	 	Appt appt2 = new Appt(1, 1, 2, 1, 2018, "test", "desk");
	 	LinkedList<Appt> appts = new LinkedList<Appt>();
	 	GregorianCalendar gregcal = new GregorianCalendar(2018, 1, 1);
	 	GregorianCalendar gregcal2 = new GregorianCalendar(2018, 1, 2);
	 	TimeTable tt = new TimeTable();

	 	appts.add(appt2);
	 	appts.add(appt);

	 	tt.getApptRange(appts, gregcal, gregcal2);
//	 	assertFalse(tt.getApptRange(appts, gregcal, gregcal2));
	}

	@Test
	public void test09() throws Throwable {
	 	Appt appt = new Appt(1, 1, 1, 1, 2018, "test", "desk");
		int[] recurringDay = {0};
		appt.setRecurrence(recurringDay, 0, 0, 0);
		assertFalse(appt.isRecurring());
	}
}
