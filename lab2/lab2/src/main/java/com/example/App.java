package com.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      System.out.println( "Lab2!" );

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      Person person = new Person("Ilya", "Krutoy", 12);
      String jsonOutput = gson.toJson(person);

      System.out.println("--- Serialized JSON Output ---");
      System.out.println(jsonOutput);

      System.out.println("---Deserialized JSON Output ---");
      Person parsedPersonObj = gson.fromJson(jsonOutput, Person.class);
      System.out.println(parsedPersonObj);

      person.equals(parsedPersonObj);

      if (person.equals(parsedPersonObj)){
        System.out.println("Objects are equal!");
      } else {
        System.out.println("Objects are not equal!");
      }

      System.out.println("Lab finishe!d");
    }
}
