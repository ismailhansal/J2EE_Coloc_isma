package com.locaimmo.servicecontrat.domain.dto.rent;

import com.locaimmo.servicecontrat.domain.entity.Rent;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

    private Long id;

    @NotNull(message = "Contract ID is required")
    private Long contractId;

    @NotNull(message = "Mois is required")
    @Min(value = 1, message = "Mois must be between 1 and 12")
    @Max(value = 12, message = "Mois must be between 1 and 12")
    private Integer mois;

    @NotNull(message = "Annee is required")
    @Min(value = 2000, message = "Annee must be valid")
    private Integer annee;

    @NotNull(message = "Montant is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Montant must be positive")
    private BigDecimal montant;

    @NotNull(message = "Date echeance is required")
    private LocalDate dateEcheance;

    private LocalDate datePaiement;

    @NotNull(message = "Statut paiement is required")
    private Rent.PaymentStatus statutPaiement;

    @Size(max = 50, message = "Mode paiement must not exceed 50 characters")
    private String modePaiement;

    @Size(max = 100, message = "Reference must not exceed 100 characters")
    private String reference;

    private LocalDateTime createdAt;
}