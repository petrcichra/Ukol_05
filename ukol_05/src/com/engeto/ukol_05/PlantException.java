package com.engeto.ukol_05;

public class PlantException extends Exception {
    public PlantException(String exceptionMessage) {
        // make it super public to use it in all project
        super(exceptionMessage);
    }
}
