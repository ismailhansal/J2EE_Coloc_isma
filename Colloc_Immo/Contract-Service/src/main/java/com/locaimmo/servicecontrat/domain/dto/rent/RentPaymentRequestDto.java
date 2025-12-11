package com.locaimmo.servicecontrat.domain.dto.rent;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentPaymentRequestDto {

    @NotNull(message = "Rent ID is required")
    private Long rentId;

    @NotNull(message = "Date paiement is required")
    private LocalDate datePaiement;

    @NotNull(message = "Montant is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Montant must be positive")
    private BigDecimal montant;

    @NotBlank(message = "Mode paiement is required")
    @Size(max = 50, message = "Mode paiement must not exceed 50 characters")
    private String modePaiement;

    @Size(max = 100, message = "Reference must not exceed 100 characters")
    private String reference;

    @Size(max = 500, message = "Notes must not exceed 500 characters")
    private String notes;
}