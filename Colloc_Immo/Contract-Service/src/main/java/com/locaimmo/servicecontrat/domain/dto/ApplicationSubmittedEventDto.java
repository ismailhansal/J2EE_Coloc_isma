package com.locaimmo.servicecontrat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationSubmittedEventDto {

    private Long applicationId;
    private Long propertyId;
    private Long userId;
    private Long tenantId;
    private String tenantNom;
    private String tenantPrenom;
    private String tenantEmail;
    private BigDecimal revenuMensuel;
    private String profession;
    private String messageProprietaire;
    private LocalDateTime submittedAt;
    private String eventType = "APPLICATION_SUBMITTED";
    private String eventId;
}
