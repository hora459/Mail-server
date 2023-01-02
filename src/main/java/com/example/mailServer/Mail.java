package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Mail {
   private String from;
   private String  to;
   private String subject;

   public Mail(String from, String to, String subject, String body) {
      this.from = from;
      this.to = to;
      this.subject = subject;
      this.body = body;
   }

   private String body;
   private int priority;

   private String [] attachment;
   private String date;

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

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }


   public Mail() {
   }


}
