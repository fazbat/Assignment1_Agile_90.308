/**
 *  * Kurt Johnson
 * 90.308 Software Development Best Practices with Java and Test Driven Development
 */


package com.origamisoftware.teach.agile.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Created by Kurt Johnson on 2/1/2015.
 */
public class SubscriptionStoreInventoryTest {

    List<String> titleList;
    List<Subscription> sublist ;
    SubscriptionPeriod p1;
    Calendar date1, date2;

    @Before
    public void setup() {
        titleList = new ArrayList<>();
        titleList.add("TITLE_1");
        titleList.add("TITLE_2");
        titleList.add("TITLE_3");
        titleList.add("TITLE_4");
        //setup two subscriptions and place in a list
        sublist = new ArrayList<>();
        date1 = Calendar.getInstance();
        date2 = Calendar.getInstance();
        date2.add(Calendar.MONTH,6);
        p1= new SubscriptionPeriod(date1.getTime(), date2.getTime());

        sublist.add(new Subscription(BigDecimal.valueOf(10.00), p1));
        sublist.add(new Subscription(BigDecimal.valueOf(20.00), p1));
    }

    /**
     * test for GetInventory method in SubscriptionStoreInventory. Only tests that returned
     * inventory list is correct size. Leave testing of SubscriptionQuery methods to other tests (ie. if
     * price & title are correct).
     */
    @Test
    public void testGetInventory_size(){

        SubscriptionQuery subQueryMock = Mockito.mock(SubscriptionQuery.class);
        when(subQueryMock.getInfo(any(String.class))).thenReturn(sublist);

        SubscriptionStoreInventory ssi = new SubscriptionStoreInventory(titleList,subQueryMock);

        //there should be 8 entries (2x4:  titles x subscriptions per title
        assertTrue("there should be 8 entries", ssi.getInventory().size() == 8);


    }

    /**
     * Negative test for GetInventory method in SubscriptionStoreInventory. Only tests that returned
     * inventory list is not correct size. Leave testing of SubscriptionQuery methods to other tests (ie. if
     * price & title are correct).
     */
    @Test
    public void testGetInventory_sizeNegative(){

        SubscriptionQuery subQueryMock = Mockito.mock(SubscriptionQuery.class);
        when(subQueryMock.getInfo(any(String.class))).thenReturn(sublist);

        SubscriptionStoreInventory ssi = new SubscriptionStoreInventory(titleList,subQueryMock);

        //there should be 8 entries (2x4:  titles x subscriptions per title
        assertFalse("there should not be 12 entries", ssi.getInventory().size() == 12);

    }
}
