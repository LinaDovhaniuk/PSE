package com.company;

public class lab_2 {


    static void sort_selection(String[] array, boolean asc){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                /* compares the strings */
                if (asc) {
                    if (array[j].compareTo(array[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
                else {
                    if (array[j].compareTo(array[minIndex]) > 0) {
                        minIndex = j;
                    }
                }
            }

            String temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    static void array_print(String array[]){
        int i=0;
        for(String str: array){
            System.out.println(++i + ". " + str);
        }
    }

}
