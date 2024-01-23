/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Film;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeerCSV {

    public static List<Film> lecturaCSV() {
        ArrayList<Film> lista= new ArrayList<Film>();

        boolean primeralinea = true;
        try (BufferedReader bf = new BufferedReader(new FileReader("./CSV/imdb_data.csv"))) {
            String titulo;
            String year;
           String generos;
            String linea;

            while ((linea = bf.readLine()) != null) {
                if (primeralinea) {
                    primeralinea = false;
                    continue;
                }
                String[] valores = linea.split(";");
                if (valores.length == 4) {
                    titulo = valores[1].toLowerCase();
                    year = valores[2];
                    generos = valores[3];

                    // Crea una película para cada línea del CSV
                    Film film = new Film(titulo, year, generos);
                    lista.add(film);



                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


}