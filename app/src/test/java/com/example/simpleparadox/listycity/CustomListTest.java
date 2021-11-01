package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Edmonton","Alberta"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void testHasCity(){
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        list.addCity(charlottetown);
        assertTrue(list.hasCity(charlottetown));
        City toronto = new City("Toronto", "Ontario");
        assertFalse(list.hasCity(toronto));
    }

    @Test
    public void testDeleteCity(){
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        list.addCity(charlottetown);
        list.deleteCity(charlottetown);
        assertFalse(list.hasCity(charlottetown));
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(charlottetown);
        });
    }

    @Test
    public void testCountCities(){
        assertEquals(0,list.countCities());
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        list.addCity(charlottetown);
        assertEquals(1,list.countCities());
        list.deleteCity(charlottetown);
        assertEquals(0,list.countCities());
    }
}
