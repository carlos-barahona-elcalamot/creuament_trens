package com.ieselcalamot.creuament_vehicles.vehicles;

public class Via {

    private short nombreTrens = 0;
    private Tren[] trens = new Tren[2];
    private float[] posicionsInicials = new float[2];

    public void afegirTren(float velocitat, float posicio) {
        try {
            trens[nombreTrens] = new Tren(velocitat);
            posicionsInicials[nombreTrens++] = posicio;
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfMemoryError("No es poden afegir més de " + trens.length + " trens.");
        }
    }

    public float getPosicio(int nombreTren, float t) {
        return trens[nombreTren].getVelocitat() * t + posicionsInicials[nombreTren];
    }

    public boolean isColisio(float t0, float t1) {
        float d0t0 = getPosicio(0, t0);
        float d1t0 = getPosicio(1, t0);
        float d0t1 = getPosicio(0, t1);
        float d1t1 = getPosicio(1, t1);

        // Detectem si hi ha hagut colisió si els trens han canviat de posició en aquest
        // interval de temps,
        // es a dir, si la posició del tren1 a t0 es més petita que la posició del
        // tren2,
        // a t1, aquesta posició ha de seguir sent més petita (i a la inversa),
        // o si les posicions son iguals en t0 o en t1
        return ((d0t0 > d1t0 && d0t1 < d1t1) || (d0t0 < d1t0 && d0t1 > d1t1) || d0t0 == d1t0 || d0t1 == d1t1);
    }

    public boolean isAllunyantse(float t1, float t0) {
        float d0 = Math.abs(getPosicio(0, t0) - getPosicio(1, t0));
        float d1 = Math.abs(getPosicio(0, t1) - getPosicio(1, t1));
        return d1 > d0;
    }
}
