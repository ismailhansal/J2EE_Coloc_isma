package com.locaimmo.servicecontrat.config;

import com.locaimmo.servicecontrat.domain.entity.Contract;
import com.locaimmo.servicecontrat.domain.entity.Deposit;
import com.locaimmo.servicecontrat.domain.entity.Rent;
import com.locaimmo.servicecontrat.domain.entity.Tenant;
import com.locaimmo.servicecontrat.repository.ContractRepository;
import com.locaimmo.servicecontrat.repository.DepositRepository;
import com.locaimmo.servicecontrat.repository.RentRepository;
import com.locaimmo.servicecontrat.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ContractRepository contractRepository;
    private final DepositRepository depositRepository;
    private final RentRepository rentRepository;
    private final TenantRepository tenantRepository;

    @Autowired
    public DataInitializer(ContractRepository contractRepository,
                          DepositRepository depositRepository,
                          RentRepository rentRepository,
                          TenantRepository tenantRepository) {
        this.contractRepository = contractRepository;
        this.depositRepository = depositRepository;
        this.rentRepository = rentRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) {
        // Only initialize if database is empty
        if (contractRepository.count() == 0) {
            initializeTestData();
        }
    }

    private void initializeTestData() {
        // Create Tenants
        Tenant tenant1 = new Tenant();
        tenant1.setUserId(1L);
        tenant1.setNom("Dupont");
        tenant1.setPrenom("Jean");
        tenant1.setEmail("jean.dupont@example.com");
        tenant1.setTelephone("0123456789");
        tenant1.setDateNaissance(LocalDate.of(1990, 5, 15));
        tenant1.setProfession("Ingénieur");
        tenant1.setRevenuMensuel(new BigDecimal("3500.00"));
        tenant1 = tenantRepository.save(tenant1);

        Tenant tenant2 = new Tenant();
        tenant2.setUserId(2L);
        tenant2.setNom("Martin");
        tenant2.setPrenom("Marie");
        tenant2.setEmail("marie.martin@example.com");
        tenant2.setTelephone("0987654321");
        tenant2.setDateNaissance(LocalDate.of(1988, 8, 22));
        tenant2.setProfession("Avocate");
        tenant2.setRevenuMensuel(new BigDecimal("4500.00"));
        tenant2 = tenantRepository.save(tenant2);

        // Create Contracts
        Contract contract1 = new Contract();
        contract1.setPropertyId(1L);
        contract1.setTenantId(tenant1.getId());
        contract1.setProprietaireId(1L);
        contract1.setDateDebut(LocalDate.of(2024, 1, 1));
        contract1.setDateFin(LocalDate.of(2024, 12, 31));
        contract1.setLoyerMensuel(new BigDecimal("850.00"));
        contract1.setDepotGarantie(new BigDecimal("1700.00"));
        contract1.setStatut(Contract.ContractStatus.ACTIF);
        contract1.setConditions("Standard rental conditions apply");
        contract1 = contractRepository.save(contract1);

        Contract contract2 = new Contract();
        contract2.setPropertyId(2L);
        contract2.setTenantId(tenant2.getId());
        contract2.setProprietaireId(1L);
        contract2.setDateDebut(LocalDate.of(2024, 2, 1));
        contract2.setDateFin(LocalDate.of(2025, 1, 31));
        contract2.setLoyerMensuel(new BigDecimal("1200.00"));
        contract2.setDepotGarantie(new BigDecimal("2400.00"));
        contract2.setStatut(Contract.ContractStatus.ACTIF);
        contract2.setConditions("Premium rental conditions");
        contract2 = contractRepository.save(contract2);

        // Create Deposits
        Deposit deposit1 = new Deposit();
        deposit1.setContractId(contract1.getId());
        deposit1.setMontant(new BigDecimal("1700.00"));
        deposit1.setDateVersement(LocalDate.of(2024, 1, 1));
        deposit1.setStatut(Deposit.DepositStatus.VERSE);
        deposit1 = depositRepository.save(deposit1);

        Deposit deposit2 = new Deposit();
        deposit2.setContractId(contract2.getId());
        deposit2.setMontant(new BigDecimal("2400.00"));
        deposit2.setDateVersement(LocalDate.of(2024, 2, 1));
        deposit2.setStatut(Deposit.DepositStatus.VERSE);
        deposit2 = depositRepository.save(deposit2);

        // Create Rents
        Rent rent1 = new Rent();
        rent1.setContractId(contract1.getId());
        rent1.setMois(1);
        rent1.setAnnee(2024);
        rent1.setMontant(new BigDecimal("850.00"));
        rent1.setDateEcheance(LocalDate.of(2024, 1, 5));
        rent1.setDatePaiement(LocalDate.of(2024, 1, 3));
        rent1.setStatutPaiement(Rent.PaymentStatus.PAYE);
        rent1.setModePaiement("Virement bancaire");
        rent1.setReference("RENT-2024-01-001");
        rentRepository.save(rent1);

        Rent rent2 = new Rent();
        rent2.setContractId(contract1.getId());
        rent2.setMois(2);
        rent2.setAnnee(2024);
        rent2.setMontant(new BigDecimal("850.00"));
        rent2.setDateEcheance(LocalDate.of(2024, 2, 5));
        rent2.setStatutPaiement(Rent.PaymentStatus.EN_ATTENTE);
        rentRepository.save(rent2);

        Rent rent3 = new Rent();
        rent3.setContractId(contract2.getId());
        rent3.setMois(2);
        rent3.setAnnee(2024);
        rent3.setMontant(new BigDecimal("1200.00"));
        rent3.setDateEcheance(LocalDate.of(2024, 2, 5));
        rent3.setDatePaiement(LocalDate.of(2024, 2, 1));
        rent3.setStatutPaiement(Rent.PaymentStatus.PAYE);
        rent3.setModePaiement("Carte bancaire");
        rent3.setReference("RENT-2024-02-002");
        rentRepository.save(rent3);
    }
}

