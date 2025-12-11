package com.locaimmo.servicecontrat.mapper;
import com.locaimmo.servicecontrat.domain.dto.rent.RentSummaryDto;
import com.locaimmo.servicecontrat.domain.entity.Rent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Component
public class RentSummaryMapper {

    private static final BigDecimal DAILY_PENALTY_RATE = new BigDecimal("0.01"); // 1% per day

    public RentSummaryDto toSummaryDto(Rent entity) {
        if (entity == null) {
            return null;
        }

        RentSummaryDto dto = new RentSummaryDto();
        dto.setId(entity.getId());
        dto.setContractId(entity.getContractId());
        dto.setMois(entity.getMois());
        dto.setAnnee(entity.getAnnee());
        dto.setMontant(entity.getMontant());
        dto.setDateEcheance(entity.getDateEcheance());
        dto.setDatePaiement(entity.getDatePaiement());
        dto.setStatutPaiement(entity.getStatutPaiement());
        dto.setModePaiement(entity.getModePaiement());

        // Computed fields
        dto.setIsOverdue(isOverdue(entity));
        dto.setDaysOverdue(calculateDaysOverdue(entity));
        dto.setPenaltyAmount(calculatePenalty(entity));
        dto.setPeriod(formatPeriod(entity.getMois(), entity.getAnnee()));

        return dto;
    }

    private Boolean isOverdue(Rent rent) {
        if (rent.getStatutPaiement() == Rent.PaymentStatus.PAYE) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return rent.getDateEcheance() != null && rent.getDateEcheance().isBefore(today);
    }

    private Integer calculateDaysOverdue(Rent rent) {
        if (!isOverdue(rent)) {
            return 0;
        }
        LocalDate today = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(rent.getDateEcheance(), today);
    }

    private BigDecimal calculatePenalty(Rent rent) {
        if (!isOverdue(rent)) {
            return BigDecimal.ZERO;
        }
        int daysOverdue = calculateDaysOverdue(rent);
        return rent.getMontant()
                .multiply(DAILY_PENALTY_RATE)
                .multiply(BigDecimal.valueOf(daysOverdue));
    }

    private String formatPeriod(Integer mois, Integer annee) {
        if (mois == null || annee == null) {
            return "";
        }
        String monthName = java.time.Month.of(mois).getDisplayName(TextStyle.FULL, Locale.FRENCH);
        return monthName + " " + annee;
    }
}
