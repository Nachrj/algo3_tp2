package edu.fiuba.algo3.manejoarchivos;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;

public class ManejoDeArchivos {
    public void guardarDatos(String nombre, int cantidadDeMovimientos) {
        ArrayList<ArrayList> datos = cargarDatos();
        for(int i = 0; i < datos.get(0).size(); i++) {
            System.out.println(datos.get(1).get(i).getClass());
            if ((int)datos.get(1).get(i) > cantidadDeMovimientos) {
                datos.get(1).add(i, cantidadDeMovimientos);
                datos.get(0).add(i, nombre);
                break;
            }
        }

        try {
            FileWriter myWriter = new FileWriter("highscores.txt");
            for(int i = 0; i < datos.get(0).size(); i++) {
                myWriter.write(datos.get(0).get(i) + "," + datos.get(1).get(i)+ "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error guardar");
        }
    }

    public ArrayList cargarDatos() {
        File f = new File("highscores.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();

            } catch(IOException e) {
                System.out.println("No se pudo crear el archivo.");
            }
        }
        ArrayList<String> nombreScores = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] score = line.split(",");
                String nombreScore = score[0];
                int puntosScore = Integer.parseInt(score[1]);

                scores.add(puntosScore);
                nombreScores.add(nombreScore);
            }
            for(int i = 0; i < scores.size(); i++) {

            }
        } catch(FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ArrayList> returnList = new ArrayList<ArrayList>();
        returnList.add(nombreScores);
        returnList.add(scores);

        return returnList;
    }
}
