package com.locaimmo.servicecontrat.domain.dto.rent;

import com.locaimmo.servicecontrat.domain.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentSummaryDto {

    private Long id;
    private Long contractId;
    private Integer mois;
    private Integer annee;
    private BigDecimal montant;
    private LocalDate dateEcheance;
    private LocalDate datePaiement;
    private Rent.PaymentStatus statutPaiement;
    private String modePaiement;

    // Computed fields
    private Boolean isOverdue;
    private Integer daysOverdue;
    private BigDecimal penaltyAmount;
    private String period; // e.g., "January 2024"
}
