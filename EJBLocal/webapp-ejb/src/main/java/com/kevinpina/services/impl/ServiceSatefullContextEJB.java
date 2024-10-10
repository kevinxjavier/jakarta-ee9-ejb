package com.kevinpina.services.impl;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@Stateful // An EJB always manage by default transactionality
public class ServiceSatefullContextEJB {

    private int count;

    public String greetings(String name) {
        String greetings = "Hi " + name;

        System.out.println("Printing ServiceSatefullContextEJB Object instance " + this);
        //this will print com.kevinpina.services.impl.ServiceSatefullEJB@728059bb and this @728059bb is the hashCode

        System.out.println(greetings + " | count value = " + count++);

        /*
        18:19:48,677 INFO  [stdout] (default task-1) Is ServiceSatefullContextEJB1 equals to ServiceSatefullContextEJB2 true
        18:19:48,693 INFO  [stdout] (default task-1) Printing ServiceSatefullContextEJB Object instance com.kevinpina.services.impl.ServiceSatefullContextEJB@4fd699af
        18:19:48,693 INFO  [stdout] (default task-1) Hi kevin | count value = 0
        18:19:48,694 INFO  [stdout] (default task-1) Printing ServiceSatefullContextEJB Object instance com.kevinpina.services.impl.ServiceSatefullContextEJB@4fd699af
        18:19:48,695 INFO  [stdout] (default task-1) Hi javier | count value = 1

        18:19:54,030 INFO  [stdout] (default task-1) Is ServiceSatefullContextEJB1 equals to ServiceSatefullContextEJB2 true
        18:19:54,033 INFO  [stdout] (default task-1) Printing ServiceSatefullContextEJB Object instance com.kevinpina.services.impl.ServiceSatefullContextEJB@1fbecf7e
        18:19:54,034 INFO  [stdout] (default task-1) Hi kevin | count value = 0
        18:19:54,036 INFO  [stdout] (default task-1) Printing ServiceSatefullContextEJB Object instance com.kevinpina.services.impl.ServiceSatefullContextEJB@1fbecf7e
        18:19:54,036 INFO  [stdout] (default task-1) Hi javier | count value = 1
         */

        return greetings;
    }
}
