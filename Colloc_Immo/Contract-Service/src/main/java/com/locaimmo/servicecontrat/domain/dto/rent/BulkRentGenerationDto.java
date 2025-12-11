package com.locaimmo.servicecontrat.domain.dto.rent;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulkRentGenerationDto {

    @NotNull(message = "Contract ID is required")
    private Long contractId;

    @NotNull(message = "Start year is required")
    @Min(value = 2000, message = "Start year must be valid")
    private Integer startYear;

    @NotNull(message = "Start month is required")
    @Min(value = 1, message = "Start month must be between 1 and 12")
    @Max(value = 12, message = "Start month must be between 1 and 12")
    private Integer startMonth;

    @NotNull(message = "Number of months is required")
    @Min(value = 1, message = "Number of months must be at least 1")
    @Max(value = 60, message = "Number of months cannot exceed 60")
    private Integer numberOfMonths;

    @NotNull(message = "Day of month is required for due date")
    @Min(value = 1, message = "Day of month must be between 1 and 31")
    @Max(value = 31, message = "Day of month must be between 1 and 31")
    private Integer dayOfMonth;

    private Boolean skipExisting = true;
}