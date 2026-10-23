package com.example;

import com.example.Enclosure.Enclosure;
import com.example.Animal.Lions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnclosureTest {

    private Enclosure<Lions> zooEnclosure;
    private Lions lion1;
    private Lions lion2;

    @BeforeEach
    void setUp() {
        zooEnclosure = new Enclosure<>(2);
        
        lion1 = new Lions();
        lion2 = new Lions();
    }

    @Test
    void testInitialState() {
        assertEquals(2, zooEnclosure.GetСapacity());
        assertEquals(0, zooEnclosure.GetAmount());
    }

    @Test
    void testAddAnimalSucceeds() throws Exception {
        zooEnclosure.addAnimal(lion1);
        
        assertEquals(1, zooEnclosure.GetAmount());
    }

    @Test
    void testAddAnimalThrowsExceptionWhenFull() throws Exception {
        zooEnclosure.addAnimal(lion1);
        zooEnclosure.addAnimal(lion2);
        
        Lions extraLion = new Lions();

        Exception exception = assertThrows(Exception.class, () -> {
            zooEnclosure.addAnimal(extraLion);
        });

        assertEquals("Out of bound", exception.getMessage());
        assertEquals(2, zooEnclosure.GetAmount(), "Amount should remain maxed out");
    }

    @Test
    void testDeleteExistingAnimal() throws Exception {
        zooEnclosure.addAnimal(lion1);
        zooEnclosure.addAnimal(lion2);

        zooEnclosure.deleteAnimal(lion1);

        assertEquals(1, zooEnclosure.GetAmount());
    }

    @Test
    void testDeleteAnimalThrowsExceptionWhenNotFound() {
        Exception exception = assertThrows(Exception.class, () -> {
            zooEnclosure.deleteAnimal(lion1);
        });

        assertEquals("Element not found", exception.getMessage());
    }
}
