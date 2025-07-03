package com.salomia.zk.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Random;

@Service
public class StoredIntService {

    private static final String file_path = "/tmp/stored-int.txt";
    public boolean storedInInt() {
        File file = new File(file_path);
        String value = "";
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                    value = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            value = String.valueOf(new Random().nextInt(100));
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                    writer.write(value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file.exists();
    }

}
