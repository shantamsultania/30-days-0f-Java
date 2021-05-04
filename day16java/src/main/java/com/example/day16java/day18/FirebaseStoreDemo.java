package com.example.day16java.day18;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Service
@Slf4j
public class FirebaseStoreDemo {

    Firestore firestore = FirestoreClient.getFirestore();
    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getDataAllCollections() throws ExecutionException, InterruptedException {

        CollectionReference collectionReference = firestore.collection("employee");
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionReference.get();
        for (QueryDocumentSnapshot queryDocumentSnapshot : querySnapshotApiFuture.get()) {
            Employee employee = queryDocumentSnapshot.toObject(Employee.class);
            log.info("data = Employee " + employee);
            employeeList.add(employee);
        }

        return employeeList;
    }

    public Employee getDocumentData() throws ExecutionException, InterruptedException {
        DocumentReference employeeDataReference = firestore.collection("employee").document("Shantam");
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = employeeDataReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Employee employee = new Employee();
        if (documentSnapshot.exists()) {
            employee = documentSnapshot.toObject(Employee.class);
            log.info("data = Employee " + employee);
        } else {
            log.error("error in getting employee ");
        }
        return employee;
    }

    public void addDocument() throws ExecutionException, InterruptedException {

        Map<String, Employee> employeeMap = new HashMap<>();

        Employee employee = new Employee();
        employee.setEmployeeId("001");
        employee.setEmployeeLocation("asdad");
        employee.setEmployeeDepartment("csa");
        employee.setEmployeeName("asd");

        employeeMap.put("test", employee);

        ApiFuture<WriteResult> document = firestore.collection("employee").document("new document").set(employee);
        System.out.println(document.get().getUpdateTime());
    }


}
