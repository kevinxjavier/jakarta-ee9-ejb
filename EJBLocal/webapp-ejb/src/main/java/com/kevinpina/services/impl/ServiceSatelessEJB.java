package com.kevinpina.services.impl;

import jakarta.ejb.Stateless;

@Stateless // An EJB always manage by default transactionality
public class ServiceSatelessEJB {

    private int count;

    public String greetings(String name) {
        String greetings = "Hi " + name;

        System.out.println("Printing ServiceSatelessEJB Object instance " + this);
        //this will print com.kevinpina.services.impl.ServiceSatelessEJB@728059bb and this @728059bb is the hashCode

        System.out.println(greetings + " | count value = " + count++);

        /*
        17:54:08,739 INFO  [stdout] (default task-1) Is serviceSatelessEJB1 equals to serviceSatelessEJB2 true
        17:54:08,765 INFO  [stdout] (default task-1) Printing ServiceSatelessEJB Object instance com.kevinpina.services.impl.ServiceSatelessEJB@5b2de357
        17:54:08,766 INFO  [stdout] (default task-1) Hi kevin | count value = 0
        17:54:08,767 INFO  [stdout] (default task-1) Printing ServiceSatelessEJB Object instance com.kevinpina.services.impl.ServiceSatelessEJB@5b2de357
        17:54:08,767 INFO  [stdout] (default task-1) Hi javier | count value = 1

        17:54:15,494 INFO  [stdout] (default task-1) Is serviceSatelessEJB1 equals to serviceSatelessEJB2 true
        17:54:15,495 INFO  [stdout] (default task-1) Printing ServiceSatelessEJB Object instance com.kevinpina.services.impl.ServiceSatelessEJB@5b2de357
        17:54:15,495 INFO  [stdout] (default task-1) Hi kevin | count value = 2
        17:54:15,497 INFO  [stdout] (default task-1) Printing ServiceSatelessEJB Object instance com.kevinpina.services.impl.ServiceSatelessEJB@5b2de357
        17:54:15,497 INFO  [stdout] (default task-1) Hi javier | count value = 3
         */

        return greetings;
    }

}