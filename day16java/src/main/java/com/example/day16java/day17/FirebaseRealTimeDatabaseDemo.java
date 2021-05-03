package com.example.day16java.day17;

import com.google.firebase.database.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FirebaseRealTimeDatabaseDemo {

    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference = firebaseDatabase.getReference("/user");
    List<User> userList = new ArrayList<>();

    public void sendDataToFirebase() {
        User user = new User();
        user.setName("shantam12");
        user.setPhoneNumber("7239811313");
        log.info("User = " + user.getName() + " , " + user.getPhoneNumber());

        DatabaseReference userDatabaseReference = databaseReference.child("/01");
        userDatabaseReference.setValueAsync(user);

    }

    public void sendMultipleDataFirebase() {
        Map<String, User> users = new HashMap<>();
        User user = new User();
        user.setName("shantam12");
        user.setPhoneNumber("7239811313");
        users.put("1", user);
        users.put("2", user);
        DatabaseReference userDatabaseReference = databaseReference.child("/");

        userDatabaseReference.setValueAsync(users);

    }

    public List<User> getDataFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    log.info("data count " + snapshot.getChildrenCount());
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        User user = dataSnapshot.getValue(User.class);
                        userList.add(user);
                    }
                    for (User user : userList) {
                        System.out.println(user);
                    }
                    log.error("user after done " + userList.size());
                } else {
                    log.error("error in getting data snapshot");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                log.error("error while getting the data ");
            }
        });
        return userList;
    }

}
