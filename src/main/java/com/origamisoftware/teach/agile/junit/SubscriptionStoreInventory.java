/**
 *   Kurt Johnson
 * 90.308 Software Development Best Practices with Java and Test Driven Development
 */


package com.origamisoftware.teach.agile.junit;

import java.util.ArrayList;
import java.util.List;



/**
 * Class to for an inventory list filled with magazine subscription prices
 */
public class SubscriptionStoreInventory {

    private List<String> subscriptionTitles;
    private List<Subscription> inventoryList;
    private SubscriptionQuery sq;

    /**
     * constructor, sets up titles for inventory and the query service to get pricing from
     * @param subscriptionTitles
     * @param sq
     */
    public SubscriptionStoreInventory(List<String> subscriptionTitles, SubscriptionQuery sq){
        this.subscriptionTitles = subscriptionTitles;
        this.sq = sq;
    }

    /**
     * Get current pricing information for list of magazine titles in inventory. various periods listed.
     * @return list of various subscription titles & period lengths with current pricing info.
     */
    public List<Subscription> getInventory(){
        List<Subscription> list;
        inventoryList = new ArrayList<>();

        for(String title: subscriptionTitles){
            list =sq.getInfo(title);
            inventoryList.addAll(list);
        }

        return inventoryList;

    }

}
