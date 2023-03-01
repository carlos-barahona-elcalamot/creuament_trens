package com.ieselcalamot.creuament_vehicles.vehicles;

public class Tren {

    private float velocitat;

    public Tren() {
        velocitat = 0;
    }

    public Tren(float velocitat) {
        this.velocitat = velocitat;
    }

    public float distanciaRecorreguda(float temps) {
        return getVelocitat() * temps;
    }

    public float getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(float velocitat) {
        this.velocitat = velocitat;
    }

}
