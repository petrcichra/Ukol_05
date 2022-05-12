package com.engeto.ukol_05;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {
    private List<Plant> listOfPlants = new ArrayList<>();

    // add and remove methods
    public void addPlant(Plant plevel) {
        listOfPlants.add(plevel);
    }
    public void removePlant(Plant plevel) {
        listOfPlants.remove(plevel);
    }
    // get specific plant, index starts with 0
    public void getSpecificPlant(int index) throws PlantException {
        if (index > listOfPlants.size()) {
            throw new PlantException("Hledáš dle indexu: "+ index + ", který neodpovídá počtu kytek v seznamu.");
        }
        listOfPlants.get(index);
    }

    // import data from file
    public static ListOfPlants importDataFromFile(
            String fileName,
            String delimiter) throws PlantException {
        String nextline = "";
        int lineNumber = 0;

        String[] items;
        String name;
        String notes;
        LocalDate planted;
        LocalDate watering;
        int frequencyOfwatering;

        ListOfPlants result = new ListOfPlants();

        try {
            Scanner scanFile = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
            // proccess open file
            while (scanFile.hasNext()) {
                lineNumber++;
                nextline = scanFile.nextLine();
                // check sout
                //System.out.println(nextline);
                items = nextline.split(delimiter);
                name = items[0];
                notes = items[1];
                frequencyOfwatering = Integer.parseInt(items[2]);
                watering = LocalDate.parse(items[3]);
                planted = LocalDate.parse(items[4]);
                result.addPlant(
                        new Plant(name,notes,planted,watering,frequencyOfwatering)
                );
            }
        } catch (FileNotFoundException e) {
            throw new PlantException(
                    "Soubor "+ fileName +" nebyl nalezen!\n"
                    + e.getLocalizedMessage());
        }
        return result;
    }

    // show actual list
    public List<Plant> showAllplants() {
        List<Plant> result = new ArrayList<>();
        for (Plant plant : listOfPlants) {
            result.add(plant);
        }
        return result;
    }

    // export list to file
    public void exportDataToFile(String filename, String delimiter) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Plant plant : listOfPlants) {
                writer.println(
                        plant.getName()
                        +delimiter
                        +plant.getNotes()
                        +delimiter
                        +plant.getFrequencyOfwatering()
                        +delimiter
                        +plant.getPlanted()
                        +delimiter
                        +plant.getWatering()


                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
