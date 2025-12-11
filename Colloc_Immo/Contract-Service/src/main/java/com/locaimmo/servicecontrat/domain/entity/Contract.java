package com.locaimmo.servicecontrat.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_id", nullable = false)
    private Long propertyId;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(name = "proprietaire_id", nullable = false)
    private Long proprietaireId;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "loyer_mensuel", nullable = false, precision = 10, scale = 2)
    private BigDecimal loyerMensuel;

    @Column(name = "depot_garantie", nullable = false, precision = 10, scale = 2)
    private BigDecimal depotGarantie;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ContractStatus statut;

    @Column(columnDefinition = "TEXT")
    private String conditions;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public enum ContractStatus {
        ACTIF,
        TERMINE,
        RESILIE,
        EN_ATTENTE
    }
}