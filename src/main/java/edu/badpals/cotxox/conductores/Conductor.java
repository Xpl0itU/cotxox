package edu.badpals.cotxox.conductores;

import java.util.ArrayList;
import java.util.Optional;

public class Conductor {
    public String nombre;
    public String modelo;
    public String matricula;
    public double valoracionMedia;
    public boolean ocupado;
    public ArrayList<Byte> valoraciones;

    private void populateDummyValues() {
        // Set dummy values
        setNombre("");
        setModelo("");
        setMatricula("");
        valoracionMedia = 0.0;
        ocupado = false;
        valoraciones = new ArrayList<>();
    }

    public Conductor() {
        populateDummyValues();
    }

    public Conductor(String nombre) {
        populateDummyValues();
        this.setNombre(nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValoracion() {
        calcularValoracionMedia();
        return valoracionMedia;
    }

    public int getNumeroValoraciones() {
        return valoraciones.size();
    }

    public void setValoracion(byte valoracion) {
        valoraciones.add(valoracion);
    }

    private void calcularValoracionMedia() {
        Optional<Byte> sumValoracionesOpt = valoraciones.stream().reduce((a, b) -> (byte) (a + b));
        if (sumValoracionesOpt.isEmpty()) {
            return;
        }
        valoracionMedia = (double) sumValoracionesOpt.get() / valoraciones.size();
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
    }
}
