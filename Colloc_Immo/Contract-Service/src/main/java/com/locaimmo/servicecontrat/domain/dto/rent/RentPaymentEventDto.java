package com.locaimmo.servicecontrat.domain.dto.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentPaymentEventDto {

    private Long rentId;
    private Long contractId;
    private Long tenantId;
    private Long proprietaireId;
    private BigDecimal montant;
    private LocalDate datePaiement;
    private String modePaiement;
    private String reference;
    private Integer mois;
    private Integer annee;
    private LocalDateTime eventTime;
    private String eventType = "RENT_PAYMENT_RECEIVED";
    private String eventId;
}
