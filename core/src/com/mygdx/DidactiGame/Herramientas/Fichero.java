package com.mygdx.DidactiGame.Herramientas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;

public class Fichero {

    FileHandle fichero;
    public String contenido;

    public Fichero (String direccion) {
        fichero = Gdx.files.absolute(Gdx.files.getLocalStoragePath() + direccion);
        contenido = fichero.readString();
    }

    public void escribir(ArrayList<ArrayList<String[]>> descripciones_entrada) {

        contenido = "";

        if (!descripciones_entrada.isEmpty() && !descripciones_entrada.get(0).isEmpty()) {
            contenido += descripciones_entrada.get(0).get(0)[0] + " " + descripciones_entrada.get(0).get(0)[1] + "\n";
            descripciones_entrada.get(0).remove(0);
        }

        while (!descripciones_entrada.isEmpty()) {
            while (!descripciones_entrada.get(0).isEmpty()) {
                if (!contenido.contains(descripciones_entrada.get(0).get(0)[1]))
                    contenido += descripciones_entrada.get(0).get(0)[0] + " " + descripciones_entrada.get(0).get(0)[1] + "\n";
                descripciones_entrada.get(0).remove(0);
            }
            descripciones_entrada.remove(0);
        }

        fichero.writeString(contenido, false);
    }

    public void escribir (String contenido) { fichero.writeString(contenido, false); }

    public void leer(ArrayList<ArrayList<String[]>> descripciones) {

        String[] letras = {"aA","bB","cC","dD","eE","fF","gG","hH","iI","jJ","kK","lL","mM",
                           "nN","oO","pP","qQ","rR","sS","tT","uU","vV","wW","xX","yY","zZ"};
        String palabra, descripcion;

        contenido = fichero.readString();
        String[] lineas = contenido.split("\n"); //leo el fichero entero y lo almaceno en lineas
        if (lineas.length > 1)
            for (int i = 0, j = 0; i < lineas.length; ++i, j = 0) {
                while (!letras[j].contains(Character.toString(lineas[i].charAt(0))))
                    //mientras que la primera letra de la linea no coincide con alguna del vector de letras
                    //o pueda existir la primera letra de la linea
                    ++j;

                if (lineas[i].contains(" ")) {
                    palabra = lineas[i].substring(0, lineas[i].indexOf(" "));
                    descripcion = lineas[i].substring(lineas[i].indexOf(" ") + 1);
                    descripciones.get(j).add(new String[]{palabra, descripcion});
                }
            }
    }

    public String[] leer() { return fichero.readString().split("\n"); }
}