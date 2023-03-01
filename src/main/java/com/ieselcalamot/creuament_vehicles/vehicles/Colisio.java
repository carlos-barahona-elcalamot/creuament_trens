package com.ieselcalamot.creuament_vehicles.vehicles;

public class Colisio {
    public final float distanciaMin, distanciaMax, tMin, tMax;
    public final float distancia, t, errorDistancia, errorT;

    public Colisio(float distanciaMin, float distanciaMax, float tMin, float tMax) {
        this.distanciaMin = distanciaMin;
        this.distanciaMax = distanciaMax;
        this.tMin = tMin;
        this.tMax = tMax;
        errorDistancia = Math.abs((distanciaMax - distanciaMin) / 2);
        distancia = distanciaMin + errorDistancia;
        errorT = Math.abs((tMax - tMin) / 2);
        t = tMin + errorT;
    }
}
