package com.ieselcalamot.creuament_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ieselcalamot.creuament_vehicles.vehicles.Colisio;
import com.simuladors.Simulador;

/**
 * Hello world!
 */
public final class CreuamentTrens {
    private CreuamentTrens() {
    }

    public static float getFloatValue(String missatge, BufferedReader consola) throws IOException {
        float valor = Float.NaN;
        do {
            System.out.println(missatge);
            try {
                valor = Float.parseFloat(consola.readLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Has d'introduir una dada numèrica.");
            }
        } while (valor == Float.NaN);

        return valor;

    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader consola = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Benvingut al simulador per resoldre problemes de creuament de trens.");
        System.out.println("");
        float velocitatTren1 = getFloatValue("Introdueix la velocitat del primer tren (Km/h): ", consola);
        float velocitatTren2 = getFloatValue("Introdueix la velocitat del segon tren (Km/h): ", consola);
        float distanciaTrens = getFloatValue("Introdueix la distancia entre els trens (Km): ", consola);

        Simulador simulador = new Simulador(velocitatTren1, velocitatTren2, distanciaTrens);
        System.out.println("");
        Colisio laColisio = simulador.run();
        if (laColisio != null) {
            System.out.println("S'ha produit la colisió a " + laColisio.distancia
                    + " km del primer tren (amb un error de \u00B1" + laColisio.errorDistancia + " km)");
            System.out.println("La colisió s'ha produit després de " + laColisio.t + " hores ( amb un error de \u00B1"
                    + laColisio.errorT + " hores)");
        } else {
            System.out.println("No s'ha produit cap colisió en " + simulador.getTMax() + " hores");
        }

    }
}
