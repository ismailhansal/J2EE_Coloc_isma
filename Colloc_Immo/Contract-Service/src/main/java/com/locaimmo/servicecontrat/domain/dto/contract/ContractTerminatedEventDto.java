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
public class ContractTerminatedEventDto {

    private Long contractId;
    private Long propertyId;
    private Long tenantId;
    private Long proprietaireId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateTermination;
    private String terminationReason;
    private BigDecimal depositReturned;
    private BigDecimal depositRetained;
    private LocalDateTime eventTime;
    private String eventType = "CONTRACT_TERMINATED";
    private String eventId;
}