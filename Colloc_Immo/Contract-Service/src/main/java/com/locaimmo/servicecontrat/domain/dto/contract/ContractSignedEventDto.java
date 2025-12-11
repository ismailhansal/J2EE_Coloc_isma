package com.locaimmo.servicecontrat.domain.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractSignedEventDto {

    private Long contractId;
    private Long propertyId;
    private Long tenantId;
    private Long proprietaireId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private BigDecimal loyerMensuel;
    private BigDecimal depotGarantie;
    private LocalDateTime signedAt;
    private String eventType = "CONTRACT_SIGNED";
    private String eventId;
}