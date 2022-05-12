package com.engeto.ukol_05;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfwatering;

    // fill all atributtes
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfwatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        wrongDate(watering);
        wrongFrequency(frequencyOfwatering);
    }
    // set default value to planted, watering and notes
    public Plant(String name, int frequencyOfwatering) throws PlantException {
        this.name = name;
        notes = "";
        planted = LocalDate.now();
        watering = LocalDate.now();
        wrongFrequency(frequencyOfwatering);
    }

    // set default value to planted, watering, notes and frequencyOfwatering
    public Plant(String name) {
        this.name = name;
        notes = "";
        planted = LocalDate.now();
        watering = LocalDate.now();
        frequencyOfwatering = 7;
    }

    // methods
    // getWateringInfo()
    public String getWateringInfo() {
        return  "Název květiny: " + name + "\n" +
                "Datum poslední zálivky: " + watering + "\n" +
                "Doporučená frekvence: " + frequencyOfwatering;
    }

    //exceptions
    public void wrongDate(LocalDate dateOfWatering) throws PlantException {
        if (dateOfWatering.isBefore(planted)) {
            throw new PlantException("Nemůžeš zalét kytku " + watering + ", když se ju chystáš zasadit " + planted);
        }

        watering = dateOfWatering;
    }

    public void wrongFrequency(int numOfFreq) throws PlantException {
        if (numOfFreq <= 0) {
            throw new PlantException(
                    "Frenkvence zalévání nesmí být menší než 0, jinak ti květina umře. " + "Zadal si: " + frequencyOfwatering);
        }
        frequencyOfwatering = numOfFreq;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfwatering() {
        return frequencyOfwatering;
    }

    public void setFrequencyOfwatering(int frequencyOfwatering) {
        this.frequencyOfwatering = frequencyOfwatering;
    }

    // toString method
    @Override
    public String toString() {
        return getWateringInfo();
    }
}
