package lvov.lab4.model;

import org.springframework.stereotype.Service;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays){
        return salary * bonus * 365 * positions.getPositionCoefficient() / workDays;
    }
}
