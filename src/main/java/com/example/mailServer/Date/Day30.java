package com.example.mailServer.Date;
import com.example.mailServer.Modules.Mail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import java.time.LocalDateTime;

public class Day30 {
   public JSONArray filter30days(JSONArray array) {
      ObjectMapper mapper = new ObjectMapper();
      DateAdapter dateAdapter = new DateAdapter();
      Mail[] Array = mapper.convertValue(array, Mail[].class);
      LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
      JSONArray filteredArray = new JSONArray();
      for (int i = 0; i < array.size(); i++) {
         LocalDateTime date = dateAdapter.aetDate(Array[i].getDate());
         if (date.isAfter(thirtyDaysAgo)) {
            filteredArray.add(array.get(i));}}
      System.out.println(filteredArray);
      return filteredArray;
   }
}
