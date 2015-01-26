/**
 * Kurt Johnson
 * 90.308 Software Development Best Practices with Java and Test Driven Development
 * 1/24/2015
 *
 * Modified SubscriptionPeriodTest Class
 * -fixed TODOs
 * -added two tests. Thought I should do something extra since so much of the work
 * was done for me in the Advanced Java assignment
 * -NOTE; also added a new method (daysLeft()) in the SubscriptionPeriod class
 *
 */

package com.origamisoftware.teach.agile.junit;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.*;

/**
 * @author Spencer A Marks
 */
public class SubscriptionPeriodTest {

    private Calendar now;
    private Calendar sixthMonthsFromNow;

    /**
     * This code is used to setup a known state or baseline
     * It is executed before every test
     */
    @Before
    public void setup() {
        // create a known state (also known as a baseline)
        now = Calendar.getInstance();
        sixthMonthsFromNow = Calendar.getInstance();
        sixthMonthsFromNow.add(Calendar.MONTH, 6);
    }

    @Test
    public void testConstruction() {

        // The basic anatomy of a test is this:

        // create a known state - this is done for us already in the setup method

        // change the state, in this case create a new object
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());

        // verify (assert) the change did what we expect
        assertEquals("start date", now.getTime(), subscriptionPeriod.getStartDate());
        assertEquals("end date", sixthMonthsFromNow.getTime(), subscriptionPeriod.getEndDate());
    }


    /**
     * TODO Currently, this test fails, it is your job to make it pass.
     */
    @Test
    public void testTotalDays() {
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());
        int totalDays = subscriptionPeriod.getTotalDays();
        long differenceInDays = (sixthMonthsFromNow.getTime().getTime() - now.getTime().getTime()) / (1000 * 60 * 60 * 24);
        assertEquals("totalDays Test",totalDays, differenceInDays);
    }


    /**
     * TODO Currently, this test fails, it is your job to make it pass.
     */
    @Test
    public void testTotalMonths() {
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());
        int totalMonths = subscriptionPeriod.getTotalMonths();
        long differenceInMonth = differenceInMonths(now, sixthMonthsFromNow);
        assertEquals("totalMonths Test:",totalMonths, differenceInMonth);
    }

    /**
     *  TODO fix this test
     */
    @Test
    public void testHasExpired() {
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());
        Calendar testDate = Calendar.getInstance();
        testDate.setTime(sixthMonthsFromNow.getTime());
        testDate.add(Calendar.MONTH,1); //one month past end date should be expired
        assertTrue("hasExpired-TRUE:", subscriptionPeriod.hasExpired(testDate.getTime()));

    }

    /**
     * EXTRA TEST: to make up for the fact that I had some extra help from Advanced Java Assignment 1
     * False test for hasExpired
     */
    @Test
    public void testHasExpiredNegative() {
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());
        Calendar testDate = Calendar.getInstance();
        testDate.setTime(sixthMonthsFromNow.getTime());
        testDate.add(Calendar.MONTH,-1); //one month before end date should NOT be expired
        assertFalse("hasExpired-FALSE:", subscriptionPeriod.hasExpired(testDate.getTime()));
    }

    /**
     * EXTRA TEST: to make up for the fact that I had some extra help from Advanced Java Assignment 1
     * Equals test for daysLeft (a new method)
     */
    @Test
    public void testDaysLeft(){
        SubscriptionPeriod subscriptionPeriod = new SubscriptionPeriod(now.getTime(), sixthMonthsFromNow.getTime());
        Calendar testDay = Calendar.getInstance();
        testDay.setTime(sixthMonthsFromNow.getTime());
        int daysBefore = 25;
        testDay.add(Calendar.DAY_OF_MONTH, -daysBefore);
        assertEquals("daysLeft:", daysBefore, subscriptionPeriod.daysLeft(testDay.getTime()));
    }


    // it is perfectly fine to have helper methods in test code.

    /**
     * This helper method returns the number of months in the range.
     *
     * @param start starting date
     * @param stop  end date
     * @return  returns the number of months in specified period
     */
    private int differenceInMonths(Calendar start, Calendar stop) {
        int stopYear = stop.get(Calendar.YEAR);
        int startYear = start.get(Calendar.YEAR);
        int stopMonth = stop.get(Calendar.MONTH);
        int startMonth = start.get(Calendar.MONTH);
        return (stopYear - startYear) * 12 + (stopMonth - startMonth);

    }


}
