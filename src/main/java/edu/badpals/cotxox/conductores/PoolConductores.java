package edu.badpals.cotxox.conductores;

import java.util.List;
import java.util.Optional;

public class PoolConductores {
    private List<Conductor> poolConductores;

    public PoolConductores(List<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }

    public List<Conductor> getPoolConductores() {
        return this.poolConductores;
    }

    public Conductor asignarConductor() {
        Optional<Conductor> conductorLibreOpt = getPoolConductores().stream().filter(o -> !o.isOcupado()).findAny();
        if (conductorLibreOpt.isEmpty()) {
            return null;
        }
        Conductor conductorLibre = conductorLibreOpt.get();
        conductorLibre.setOcupado(true);
        return conductorLibre;
    }
}
