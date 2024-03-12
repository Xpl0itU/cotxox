package edu.badpals.cotxox.carrera;

import edu.badpals.cotxox.conductores.Conductor;
import edu.badpals.cotxox.conductores.PoolConductores;
import edu.badpals.cotxox.tarifa.Tarifa;

public class Carrera {
    public String tarjetaCredito;
    public String origen;
    public String destino;
    public double distancia;
    public int tiempoEsperado;
    public int tiempoCarrera;
    public double costeTotal;
    public int propina;
    private Conductor conductor;

    public Carrera(String tarjetaCredito) {
        this.setTarjetaCredito(tarjetaCredito);
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteTotalEsperado(this);
    }

    public int getTiempoEsperado() {
        return tiempoEsperado;
    }

    public void setTiempoEsperado(int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public int getTiempoCarrera() {
        return tiempoCarrera;
    }

    public void setTiempoCarrera(int tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void asignarConductor(PoolConductores poolConductores) {
        conductor = poolConductores.asignarConductor();
    }

    public void realizarPago(double pago) {
        costeTotal = pago + getPropina();
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public int getPropina() {
        return propina;
    }

    public void recibirPropina(int propina) {
        this.propina = propina;
    }

    public void liberarConductor() {
        getConductor().setOcupado(false);
    }
}
