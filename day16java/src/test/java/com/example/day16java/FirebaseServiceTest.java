package com.example.day16java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;

class FirebaseServiceTest {

    FirebaseService firebaseService = new FirebaseService();

    @Test
    public void testFirebaseService()
    {
        try {
            firebaseService.getAllData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}