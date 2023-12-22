package lvov.lab4.model;

import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays, int year) {
        int daysInYear = Year.of(year).isLeap() ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    @Override
    public double calculateQuarterlyBonus(Positions positions, double salary, double bonus, int workDays) {
        if (positions.isManager()) {
            // Квартальный коэффициент для менеджеров и управленцев
            double quarterlyCoefficient = 0.2; // Пример, вы можете задать свое значение
            return salary * bonus * 365 * positions.getPositionCoefficient() * quarterlyCoefficient / workDays;
        } else {
            // Для всех остальных возвращаем 0
            return 0;
        }
    }
}
