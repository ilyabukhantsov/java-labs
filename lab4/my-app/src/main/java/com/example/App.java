package com.example;

import com.example.Animal.Birds;
import com.example.Enclosure.BirdsEnclosure;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BirdsEnclosure birdsEnclosure = new BirdsEnclosure(2);
        Birds bird1 = new Birds();
        Birds bird2 = new Birds();

        try {
            birdsEnclosure.addAnimal(bird1);
            birdsEnclosure.addAnimal(bird2); 
        } catch (Exception e) {
            System.out.println("Bug somewhere");
        }
    }
}
