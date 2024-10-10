package com.kevinpina.services.impl;

import jakarta.ejb.Stateful;

@Stateful // An EJB always manage by default transactionality
public class ServiceSatefullEJB {

    private int count;

    public String greetings(String name) {
        String greetings = "Hi " + name;

        System.out.println("Printing ServiceSatefullEJB Object instance " + this);
        //this will print com.kevinpina.services.impl.ServiceSatefullEJB@728059bb and this @728059bb is the hashCode

        System.out.println(greetings + " | count value = " + count++);

        /*
        17:51:11,525 INFO  [stdout] (default task-1) Is serviceSatefullEJB1 equals to serviceSatefullEJB2 false
        17:51:11,545 INFO  [stdout] (default task-1) Printing ServiceSatefullEJB Object instance com.kevinpina.services.impl.ServiceSatefullEJB@75995b10
        17:51:11,545 INFO  [stdout] (default task-1) Hi kevin | count value = 0
        17:51:11,553 INFO  [stdout] (default task-1) Printing ServiceSatefullEJB Object instance com.kevinpina.services.impl.ServiceSatefullEJB@390a3ab3
        17:51:11,553 INFO  [stdout] (default task-1) Hi javier | count value = 0

        17:51:28,332 INFO  [stdout] (default task-1) Is serviceSatefullEJB1 equals to serviceSatefullEJB2 false
        17:51:28,333 INFO  [stdout] (default task-1) Printing ServiceSatefullEJB Object instance com.kevinpina.services.impl.ServiceSatefullEJB@75995b10
        17:51:28,334 INFO  [stdout] (default task-1) Hi kevin | count value = 1
        17:51:28,336 INFO  [stdout] (default task-1) Printing ServiceSatefullEJB Object instance com.kevinpina.services.impl.ServiceSatefullEJB@390a3ab3
        17:51:28,336 INFO  [stdout] (default task-1) Hi javier | count value = 1
         */

        return greetings;
    }
}
