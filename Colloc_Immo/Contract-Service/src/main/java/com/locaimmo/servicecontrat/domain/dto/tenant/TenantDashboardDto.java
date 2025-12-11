package com.locaimmo.servicecontrat.domain.dto.tenant;

import com.locaimmo.servicecontrat.domain.dto.rent.RentSummaryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantDashboardDto {

    // Tenant basic info
    private Long tenantId;
    private String nom;
    private String prenom;
    private String email;

    // Current contract info
    private Long currentContractId;
    private Long propertyId;
    private String propertyAddress;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private BigDecimal monthlyRent;
    private Integer daysRemainingInContract;

    // Payment information
    private RentSummaryDto nextPaymentDue;
    private List<RentSummaryDto> recentPayments;
    private BigDecimal totalPaid;
    private BigDecimal totalOutstanding;
    private Integer overduePaymentsCount;

    // Deposit information
    private BigDecimal depositAmount;
    private LocalDate depositPaidDate;

    // Alerts
    private List<String> alerts;
    private Boolean hasOverduePayments;
    private Boolean contractExpiringSoon;
}
