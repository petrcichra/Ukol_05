package com.engeto.jenTak;

import java.util.*;

public class Main {

    public static List<Integer> selectOddOnly(List<Integer> seznam) {
        List<Integer> list = new ArrayList<>();
        double result;
        for (Integer polozka : seznam) {
            result = polozka % 2;
            if (result == 0) {
                list.add(polozka);
            }
        }
        return list;
    }


    public static void main(String[] args) {
	    // LIST
        List<Integer> seznamCisel;
        seznamCisel = new ArrayList<>(Arrays.asList(1,3,5,7,9,2,4,6,8));
        System.out.println(selectOddOnly(seznamCisel));

        List<Item> items = new ArrayList<>();
        Item screw1 = new Item("Šroub M12×50", 10, "0.6");
        Item screw2 = new Item("Šroub M20×30", 15, "0.3");
        Item screw3 = new Item("Šroub M40×45", 30, "1.2");

        items.add(screw1);
        items.add(screw2);
        items.add(screw3);
        items.add(screw1);

        items.forEach(System.out::println);

        System.out.println(items.size());
        System.out.println(items.get(0));

        // kopie listu
        List<Item> itemsCopy = new ArrayList<>(items);

        // mnoziny SET
        Set setOfName = new HashSet();
        setOfName.add("Karla");
        setOfName.add("Petr");
        setOfName.add("Kofi");

        System.out.println(setOfName.size());
        System.out.println(setOfName.contains("Petr"));
        setOfName.remove("Karla");
        System.out.println(setOfName.size());
        setOfName.clear();
        System.out.println(setOfName.size());

    }
}
