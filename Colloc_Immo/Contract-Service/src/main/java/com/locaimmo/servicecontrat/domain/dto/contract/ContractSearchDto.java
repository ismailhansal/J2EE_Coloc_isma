package com.locaimmo.servicecontrat.domain.dto.contract;

import com.locaimmo.servicecontrat.domain.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractSearchDto {

    private Long propertyId;
    private Long tenantId;
    private Long proprietaireId;
    private Contract.ContractStatus statut;

    // Date range filters
    private LocalDate dateDebutFrom;
    private LocalDate dateDebutTo;
    private LocalDate dateFinFrom;
    private LocalDate dateFinTo;

    // Price range filters
    private BigDecimal loyerMensuelMin;
    private BigDecimal loyerMensuelMax;

    // Pagination
    private Integer page = 0;
    private Integer size = 10;

    // Sorting
    private String sortBy = "createdAt";
    private String sortDirection = "DESC";

    // Additional filters
    private Boolean activeOnly;
    private Boolean expiringWithinDays;
    private Integer daysUntilExpiry;
}
