package com.ieselcalamot.creuament_vehicles.simuladors;

import com.ieselcalamot.creuament_vehicles.vehicles.Colisio;
import com.ieselcalamot.creuament_vehicles.vehicles.Via;

public class Simulador {

    private float tStep = 0.01f;
    private float tmax = 24 * 60 * 60;
    private Via laVia = new Via();

    public Simulador(float velocitatTren1, float velocitatTren2, float distanciaTrens) {
        laVia.afegirTren(velocitatTren1, 0);
        laVia.afegirTren(velocitatTren2, distanciaTrens);
    }

    public Colisio run() {
        Colisio dadesColisio = null;
        float t = 0;
        boolean colisio = false;
        while (!colisio && t <= tmax) {
            colisio = laVia.isColisio(t, t + tStep);
            // System.out.println("t="+t+" p0="+laVia.getPosicio(0, t)+" p1="+laVia.getPosicio(1, t)+" colisió: "+colisio);
            t += tStep;
        }
        if (colisio) {
            // System.out.println("Colisió entre t="+(t-tStep)+" y t="+t);
            float dMin = laVia.getPosicio(0, t - tStep);
            float dMax = laVia.getPosicio(0, t);
            dadesColisio = new Colisio(dMin, dMax, t - tStep, t);
        }
        return dadesColisio;
    }

    public float getTMax() {
        return tmax;
    }
}
