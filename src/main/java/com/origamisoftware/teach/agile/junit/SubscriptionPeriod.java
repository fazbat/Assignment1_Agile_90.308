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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple Date Range Class
 *
 * @author Spencer A Marks
 */
public class SubscriptionPeriod {

    private Date startDate;
    private Date endDate;
    private final int MSECONDS_PER_DAY = (1000 * 60 * 60 * 24);

    /**
     * Creates a  SubscriptionPeriod instance
     *
     * @param startDate the starting date of the subscription period
     * @param endDate   the end date of the subscription period
     */
    public SubscriptionPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @return the the start date of the subscription
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the the end date of the subscription
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the total Days in the subscription
     */
    public int getTotalDays() {
        return (int) ((endDate.getTime() - startDate.getTime())/MSECONDS_PER_DAY);
    }

    /**
     * @return the total months on the subscription
     */
    public int getTotalMonths() {
        Calendar stop = Calendar.getInstance();
        stop.setTime(endDate);
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        //pulled code from test(in Agile project). Hope that's okay.
        int stopYear = stop.get(Calendar.YEAR);
        int startYear = start.get(Calendar.YEAR);
        int stopMonth = stop.get(Calendar.MONTH);
        int startMonth = start.get(Calendar.MONTH);
        return (stopYear - startYear) * 12 + (stopMonth - startMonth);


    }

    /**
     * Given a date return true if the date comes after the expiration date of this
     * subscription period or false otherwise.
     *
     * @param date a date to consider
     * @return true if true if the date comes after the expiration date of this
     * subscription period or false otherwise.
     */
    public boolean hasExpired(Date date) {
        // todo implement method

        return date.after(endDate);

    }

    /**
     *
     * @param date
     * @return int representing number of days left in subscription after supplied date
     */
    public int daysLeft(Date date){

        return (int) ((endDate.getTime() - date.getTime()) / MSECONDS_PER_DAY);
    }

}
