package com.psl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

       public static void main(String[] args) {
              // TODO Auto-generated method stub
              ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
              Performer p=context.getBean("performer",Performer.class);
              p.perform();

       }

}

