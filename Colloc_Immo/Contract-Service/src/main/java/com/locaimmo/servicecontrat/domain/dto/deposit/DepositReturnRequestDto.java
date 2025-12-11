package com.locaimmo.servicecontrat.domain.dto.deposit;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositReturnRequestDto {

    @NotNull(message = "Deposit ID is required")
    private Long depositId;

    @NotNull(message = "Date restitution is required")
    private LocalDate dateRestitution;

    @NotNull(message = "Montant retenu is required")
    @DecimalMin(value = "0.0", message = "Montant retenu must be zero or positive")
    private BigDecimal montantRetenu;

    @Size(max = 5000, message = "Motif retenue must not exceed 5000 characters")
    private String motifRetenue;

    @Size(max = 1000, message = "Notes must not exceed 1000 characters")
    private String notes;

    // Validation: montantRetenu should not exceed original deposit
    private BigDecimal originalDepositAmount;

    @AssertTrue(message = "Montant retenu cannot exceed original deposit amount")
    public boolean isMontantRetenuValid() {
        if (montantRetenu == null || originalDepositAmount == null) {
            return true;
        }
        return montantRetenu.compareTo(originalDepositAmount) <= 0;
    }
}