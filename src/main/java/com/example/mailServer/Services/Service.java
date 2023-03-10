package com.example.mailServer.Services;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Service {
    private int size=0;
    public  void create_file( String path) {
        java.io.File myObj = null;
        try {
            myObj = new java.io.File(path);
            System.out.println(myObj.length());
            System.out.println(myObj);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }} catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        size=(int)myObj.length();
    }
    public void CreateFolder(String path){
            java.io.File f = new java.io.File(path);
        if (f.mkdir()) {
            System.out.println("Folder created: " + f.getName());
        } else {
            System.out.println("Folder already exists.");
        }
    }
    public int getSize(){
        return size;
    }
    public Map<String, Integer> getfiles(String foldername) throws IOException {
        Path folderPath = Paths.get(foldername);
        Map<String, Integer> files = new HashMap<>();
        try (Stream<Path> paths = Files.walk(folderPath)) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .forEach(path -> {
                        try {
                            if(path.toString().contains("contact")){
                                ObjectMapper mapper = new ObjectMapper();
                                Map<String,String[]>m=mapper.readValue(new java.io.File(path.toString()), Map.class);
                                files.put(String.valueOf(path.getFileName()),m.size());
                            }
                            else files.put(String.valueOf(path.getFileName()), (int) load_mails(path.toString()).size());
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        } catch (StreamReadException e) {
                            throw new RuntimeException(e);
                        } catch (DatabindException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
        return files;
    }
    public String get_name(String email) throws Exception {
        String filename = "";
        int index = email.indexOf("@");
        filename = email.substring(0, index);
        return filename;
    }
    public JSONArray load_mails(String filename) throws ParseException {
        try{
            JSONParser parser = new JSONParser();
            org.json.simple.JSONArray array;
            array = (org.json.simple.JSONArray) parser.parse(new FileReader(filename));
            return array;}
        catch(Exception e){
            return new JSONArray();
        }

    }
    public void save_mails(String filename, org.json.simple.JSONArray array) throws IOException {
        FileWriter myWriter = new FileWriter(filename);
        myWriter.write(array.toString());
        myWriter.close();
    }

}

