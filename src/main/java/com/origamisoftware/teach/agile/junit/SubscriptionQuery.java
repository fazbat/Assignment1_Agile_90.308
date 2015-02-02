/**
 *   Kurt Johnson
 * 90.308 Software Development Best Practices with Java and Test Driven Development
 */

package com.origamisoftware.teach.agile.junit;

import java.util.List;

/**
 * Interface for a getting pricing info for magazine subscriptions
 */
public interface SubscriptionQuery {
    /**
     *
     * @param title
     * @return List of subscriptions for the title. Various period lengths & prices
     */
    public List<Subscription> getInfo(String title);


}
