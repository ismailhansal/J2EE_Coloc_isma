package com.locaimmo.servicecontrat.domain.dto.contract;

import com.locaimmo.servicecontrat.domain.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponseDto {

    private Long id;
    private Long propertyId;
    private Long tenantId;
    private Long proprietaireId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private BigDecimal loyerMensuel;
    private BigDecimal depotGarantie;
    private Contract.ContractStatus statut;
    private String conditions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Additional computed fields
    private Long durationInMonths;
    private BigDecimal totalCost;
    private Boolean isActive;
    private Integer daysRemaining;
}
