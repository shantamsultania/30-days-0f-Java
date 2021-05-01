package com.example.day15java;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

@RestController
public class Service {

    @Autowired
    private Storage storage;

    @GetMapping("/getgcp")
    public String getGcpData() {

        StringBuilder stringBuilder = new StringBuilder();
        try (ReadChannel readChannel = storage.reader("testsetup", "test.txt")) {
            ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
            while (readChannel.read(bytes) > 0) {
                bytes.flip();
                String data = new String(bytes.array(), 0, bytes.limit());
                stringBuilder.append(data);
                bytes.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
