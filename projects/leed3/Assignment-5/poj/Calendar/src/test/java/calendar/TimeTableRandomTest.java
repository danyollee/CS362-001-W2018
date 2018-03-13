package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
	private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");


		 try {

		 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				//Creates random variables for 4 new appointments
				int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 24); //Randomizes input for the start hour to include values out of bounds
				int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 60);
				int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 29);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party";
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //Construcrt a new Appointment object with the initial data
				if (startHour < 0) {
					appt = null;
				}

				int startHour2 = ValuesGenerator.getRandomIntBetween(random, -10, 24); //Randomizes input for the start hour to include values out of bounds
				int startMinute2 = ValuesGenerator.getRandomIntBetween(random, 0, 60);
				int startDay2 = ValuesGenerator.getRandomIntBetween(random, 0, 29);
				int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2 = ValuesGenerator.RandInt(random);
				String title2 = "Birthday Party two";
				String description2 = "This is my second birthday party";
				Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2); //Construcrt a new Appointment object with the initial data

				int startHour3 = ValuesGenerator.getRandomIntBetween(random, -10, 24); //Randomizes input for the start hour to include values out of bounds
				int startMinute3 = ValuesGenerator.getRandomIntBetween(random, 0, 60);
				int startDay3 = ValuesGenerator.getRandomIntBetween(random, 0, 29);
				int startMonth3 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear3 = ValuesGenerator.RandInt(random);
				String title3 = "Birthday Party three";
				String description3 = "This is my third birthday party";
				Appt appt3 = new Appt(startHour3, startMinute3, startDay3, startMonth3, startYear3, title3, description3); //Construcrt a new Appointment object with the initial data

				int startHour4 = ValuesGenerator.getRandomIntBetween(random, 1, 23); //Randomizes input for the start hour to include values out of bounds
				int startMinute4 = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				int startDay4 = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth4 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear4 = ValuesGenerator.RandInt(random);
				String title4 = "Birthday Party four";
				String description4 = "This is my fourth birthday party";
				Appt appt4 = new Appt(startHour4, startMinute4, startDay4, startMonth4, startYear4, title4, description4); //Construcrt a new Appointment object with the initial data
				assertTrue(appt4.getValid());

				//Creates a new timetable object
				LinkedList<Appt> appts = new LinkedList<Appt>();
				TimeTable tt = new TimeTable();

				appts.add(appt4);
				appts.add(appt);
				appts.add(appt2);
				appts.add(appt3);

				tt.deleteAppt(appts, appt4);
				if ((startHour < 0) && (startHour2 < 0) && (startHour3 < 0)) {
					appts = null;
				}
				tt.deleteAppt(appts, appt);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);


			}






		 } catch(NullPointerException e) {

		 }

		 System.out.println("Done testing...");
		 
	 }

	 @Test
	public void getApptRangeTest() throws Throwable {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 try {

		 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		 		long randomseed = System.currentTimeMillis();
		 		Random random = new Random(randomseed);

				//Creates random variables for 4 new appointments
				int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 23); //Randomizes input for the start hour to include values out of bounds
				int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party";
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description); //Construcrt a new Appointment object with the initial data
				assertTrue(appt.getValid());

				int startHour2 = ValuesGenerator.getRandomIntBetween(random, 1, 23); //Randomizes input for the start hour to include values out of bounds
				int startMinute2 = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				int startDay2 = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear2 = ValuesGenerator.RandInt(random);
				String title2 = "Birthday Party two";
				String description2 = "This is my second birthday party";
				Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2); //Construcrt a new Appointment object with the initial data
				assertTrue(appt2.getValid());

				int startHour3 = ValuesGenerator.getRandomIntBetween(random, 1, 23); //Randomizes input for the start hour to include values out of bounds
				int startMinute3 = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				int startDay3 = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth3 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear3 = ValuesGenerator.RandInt(random);
				String title3 = "Birthday Party three";
				String description3 = "This is my third birthday party";
				Appt appt3 = new Appt(startHour3, startMinute3, startDay3, startMonth3, startYear3, title3, description3); //Construcrt a new Appointment object with the initial data
				assertTrue(appt3.getValid());

				int startHour4 = ValuesGenerator.getRandomIntBetween(random, 1, 23); //Randomizes input for the start hour to include values out of bounds
				int startMinute4 = ValuesGenerator.getRandomIntBetween(random, 1, 59);
				int startDay4 = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int startMonth4 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear4 = ValuesGenerator.RandInt(random);
				String title4 = "Birthday Party four";
				String description4 = "This is my fourth birthday party";
				Appt appt4 = new Appt(startHour4, startMinute4, startDay4, startMonth4, startYear4, title4, description4); //Construcrt a new Appointment object with the initial data
				assertTrue(appt4.getValid());


				//Creates a new timetable object
				LinkedList<Appt> appts = new LinkedList<Appt>();
				appts.add(appt);
				appts.add(appt2);
				appts.add(appt3);
				appts.add(appt4);


				TimeTable tt = new TimeTable();

				int day1 = 1;
				int month1 = 1;
				int year1 = 1;
				GregorianCalendar gregcal1 = new GregorianCalendar(year1, month1, day1);

				int day2 = 3;
				int month2 = 3;
				int year2 = 3;
//				while(year2 < year1){
//					year2 = ValuesGenerator.RandInt(random);
//				}
				GregorianCalendar gregcal2 = new GregorianCalendar(year2, month2, day2);



				tt.getApptRange(appts, gregcal1, gregcal2);





				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		 } catch (NullPointerException e) {

		 }

		 System.out.println("Done testing...");



	 }


	
}
