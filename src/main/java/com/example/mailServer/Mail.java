package com.example.mailServer;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Mail {
   private String from;
   private String  to;
   private String subject;
   private String body;
   private int priority;

   private String [] attachment;

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }

   public String[] getAttachment() {
      return attachment;
   }

   public void setAttachment(String[] attachment) {
      this.attachment = attachment;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   private Date date;


   public Mail() {
   }


}
