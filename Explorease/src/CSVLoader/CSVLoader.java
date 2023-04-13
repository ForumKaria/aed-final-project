/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSVLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {
    public static void main(String[] args) {
        String csvFile = "path/to/your/file.csv"; 
        String line;
        String csvSplitBy = ","; 
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println("Column 1: " + data[0]);
                System.out.println("Column 2: " + data[1]);
                System.out.println("Row 1: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



