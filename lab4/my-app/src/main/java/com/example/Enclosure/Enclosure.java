package com.example.Enclosure;

import java.util.ArrayList;

import com.example.Animal.*;

public class Enclosure <T extends Animal>{
    private int capacity;
    private int amount;
    ArrayList<Object> list = new ArrayList<>();

    public Enclosure(int capacity){
        this.capacity = capacity;
        this.amount = 0;
    }

    public int GetСapacity(){
        return this.capacity;
    }

    public int GetAmount(){
        return this.amount;
    }

    public void addAnimal(T animal) throws Exception{
        if (amount >= capacity){
            throw new Exception("Out of bound");
        }
        amount++;
        list.add(animal);
    }

    public void deleteAnimal(T animal) throws Exception{
        if (list.contains(animal)){
            amount--;
            list.remove(animal);
        } else {
            throw new Exception("Element not found");
        }
    }
}
