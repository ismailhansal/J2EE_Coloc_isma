package com.locaimmo.servicecontrat.domain.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractStatisticsDto {

    // Overall statistics
    private Long totalContracts;
    private Long activeContracts;
    private Long expiredContracts;
    private Long terminatedContracts;

    // Financial statistics
    private BigDecimal totalMonthlyRevenue;
    private BigDecimal averageLoyerMensuel;
    private BigDecimal totalDepositsHeld;

    // Tenant statistics
    private Long totalTenants;
    private Long activeTenants;

    // Payment statistics
    private Long totalRentPayments;
    private Long paidPayments;
    private Long overduePayments;
    private BigDecimal totalOverdueAmount;

    // Trends (by month)
    private Map<String, Long> contractsByMonth;
    private Map<String, BigDecimal> revenueByMonth;

    // Property statistics
    private Long totalProperties;
    private Long occupiedProperties;
    private Double occupancyRate;
}