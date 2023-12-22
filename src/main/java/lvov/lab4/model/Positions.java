package lvov.lab4.model;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2),
    HR(1.2),
    TL(2.6);
    private final double positionCoefficient;
    Positions(double positionCoefficient){
        this.positionCoefficient = positionCoefficient;
    }
}
