package com.engeto.ukol_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static final String FILEPATH = "plants.csv";
    public static final String EXPORTFILE = "plantsExport.csv";
    public static final String DELIMITER = ";";
    public static final int STATUS_CANNOT_READ_FILE = 1;

    public static void main(String[] args) {

        System.out.println("FIRST PART"+"\n"+"--------------------------------------");
	    //FIRST PART

        // create new object Plant
        Plant cactus = null;
        try {
            cactus = new Plant(
                    "Kaktus",
                    "Kaktus se nemusí zalévat tak často.",
                    LocalDate.now().minusDays(1),
                    LocalDate.now(),
                    4
                    );
        } catch (PlantException e) {
            e.printStackTrace();
        }
        System.out.println(cactus.getWateringInfo());

        // create new List and add two objects Plant and try get index 3
        ListOfPlants myPlant = new ListOfPlants();
        myPlant.addPlant(cactus);

        try {
            myPlant.getSpecificPlant(0);
        } catch (PlantException e) {
            e.printStackTrace();
        }

        // presentation of data in file
        File fileWithPlantList = new File(FILEPATH);

        // prepare for reading data from it
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(FILEPATH)));
            while (scanFile.hasNext()) {
                System.out.println(scanFile.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("END OF FIRST PART"+"\n"+"--------------------------------------");
	    //END OF FIRST PART

        // PART WITH FILE
        ListOfPlants seznamRostlin = null;
        try {
            seznamRostlin = ListOfPlants.importDataFromFile(FILEPATH,DELIMITER);
        } catch (PlantException e) {
            System.err.println(
                    "Chyba při načtení souboru "+FILEPATH
                    +":\n"+e.getLocalizedMessage());
            System.exit(STATUS_CANNOT_READ_FILE);
        }

        // add and Show on CLI
        try {
            Plant cactus3 = new Plant(
                    "Kaktus 3",
                    "Kaktus se nemusí zalévat tak často.",
                    LocalDate.now().minusDays(1),
                    LocalDate.now(),
                    4
            );
            Plant cactus4 = new Plant(
                    "Kaktus 4",
                    "Kaktus se nemusí zalévat tak často.",
                    LocalDate.now().minusDays(1),
                    LocalDate.now(),
                    4
            );
            seznamRostlin.addPlant(cactus3);
            seznamRostlin.addPlant(cactus4);
            seznamRostlin.removePlant(seznamRostlin.showAllplants().get(0));
        } catch (PlantException e) {
            e.printStackTrace();
        }

        System.out.println("Seznam rostlin:");
        for ( Plant rostlina :
                seznamRostlin.showAllplants()) {
            System.out.println(rostlina);
        }

        seznamRostlin.exportDataToFile(EXPORTFILE,DELIMITER);

    }

}
