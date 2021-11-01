package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    void testHasCity(){
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        list.addCity(charlottetown);
        assertTrue(list.hasCity(charlottetown));
        City toronto = new City("Toronto", "Ontario");
        assertFalse(list.hasCity(toronto));
    }
}
