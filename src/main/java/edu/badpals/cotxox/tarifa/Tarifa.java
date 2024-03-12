package edu.badpals.cotxox.tarifa;

import edu.badpals.cotxox.carrera.Carrera;

public class Tarifa {
    public static final double COSTE_MILLA = 1.35;
    public static final double COSTE_MINUTO = 0.35;
    public static final double COSTE_MINIMO = 5;
    public static final byte PORCENTAJE_COMISION = 20;

    public Tarifa() {}

    public static double getCosteDistancia(double distancia) {
        return COSTE_MILLA * distancia;
    }

    public static double getCosteTiempo(int tiempoMinutos) {
        return COSTE_MINUTO * tiempoMinutos;
    }

    public static double getCosteTotalEsperado(Carrera carrera) {
        return Math.max(COSTE_MINIMO, getCosteDistancia(carrera.getDistancia()) + getCosteTiempo(carrera.getTiempoEsperado()));
    }
}
