package org.example.Task3;

import java.io.*;

public class CipherService {

    public static void encrypt(String inputPath, String outputPath, char key)
            throws IOException {

        try (
                Reader reader = new BufferedReader(new FileReader(inputPath));
                Writer writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            int character;

            while ((character = reader.read()) != -1) {
                writer.write(character + key);
            }
        }
    }

    public static void decrypt(String inputPath, String outputPath, char key)
            throws IOException {

        try (
                Reader reader = new BufferedReader(new FileReader(inputPath));
                Writer writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            int character;

            while ((character = reader.read()) != -1) {
                writer.write(character - key);
            }
        }
    }
}