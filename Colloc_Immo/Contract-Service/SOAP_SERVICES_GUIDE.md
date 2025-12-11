# SOAP Services Guide

This project provides SOAP web services for managing Contracts, Deposits, Rents, and Tenants.

## WSDL Endpoints

After starting the application, access the WSDL files at:

- **Contract**: http://localhost:8083/ws/contract.wsdl
- **Deposit**: http://localhost:8083/ws/deposit.wsdl
- **Rent**: http://localhost:8083/ws/rent.wsdl
- **Tenant**: http://localhost:8083/ws/tenant.wsdl

## SOAP Endpoint

All SOAP services are exposed at: **http://localhost:8083/ws**

## Available Operations

### Contract Service

#### GetContractRequest
Retrieves a contract by ID.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:GetContractRequest>
         <con:id>1</con:id>
      </con:GetContractRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### CreateContractRequest
Creates a new contract.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:CreateContractRequest>
         <con:propertyId>1</con:propertyId>
         <con:tenantId>1</con:tenantId>
         <con:proprietaireId>1</con:proprietaireId>
         <con:dateDebut>2024-01-01</con:dateDebut>
         <con:dateFin>2024-12-31</con:dateFin>
         <con:loyerMensuel>850.00</con:loyerMensuel>
         <con:depotGarantie>1700.00</con:depotGarantie>
         <con:statut>ACTIF</con:statut>
         <con:conditions>Standard rental conditions</con:conditions>
      </con:CreateContractRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Deposit Service

#### GetDepositRequest
Retrieves a deposit by ID.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:dep="http://locaimmo.com/deposit">
   <soapenv:Header/>
   <soapenv:Body>
      <dep:GetDepositRequest>
         <dep:id>1</dep:id>
      </dep:GetDepositRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### CreateDepositRequest
Creates a new deposit.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:dep="http://locaimmo.com/deposit">
   <soapenv:Header/>
   <soapenv:Body>
      <dep:CreateDepositRequest>
         <dep:contractId>1</dep:contractId>
         <dep:montant>1700.00</dep:montant>
         <dep:dateVersement>2024-01-01</dep:dateVersement>
         <dep:statut>VERSE</dep:statut>
      </dep:CreateDepositRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Rent Service

#### GetRentRequest
Retrieves a rent by ID.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rent="http://locaimmo.com/rent">
   <soapenv:Header/>
   <soapenv:Body>
      <rent:GetRentRequest>
         <rent:id>1</rent:id>
      </rent:GetRentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### CreateRentRequest
Creates a new rent.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rent="http://locaimmo.com/rent">
   <soapenv:Header/>
   <soapenv:Body>
      <rent:CreateRentRequest>
         <rent:contractId>1</rent:contractId>
         <rent:mois>1</rent:mois>
         <rent:annee>2024</rent:annee>
         <rent:montant>850.00</rent:montant>
         <rent:dateEcheance>2024-01-05</rent:dateEcheance>
         <rent:statutPaiement>EN_ATTENTE</rent:statutPaiement>
      </rent:CreateRentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Tenant Service

#### GetTenantRequest
Retrieves a tenant by ID.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ten="http://locaimmo.com/tenant">
   <soapenv:Header/>
   <soapenv:Body>
      <ten:GetTenantRequest>
         <ten:id>1</ten:id>
      </ten:GetTenantRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### CreateTenantRequest
Creates a new tenant.

**Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ten="http://locaimmo.com/tenant">
   <soapenv:Header/>
   <soapenv:Body>
      <ten:CreateTenantRequest>
         <ten:userId>1</ten:userId>
         <ten:nom>Dupont</ten:nom>
         <ten:prenom>Jean</ten:prenom>
         <ten:email>jean.dupont@example.com</ten:email>
         <ten:telephone>0123456789</ten:telephone>
      </ten:CreateTenantRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## Test Data

The application automatically initializes test data on startup if the database is empty:

- **2 Tenants**: Jean Dupont and Marie Martin
- **2 Contracts**: Active contracts for the tenants
- **2 Deposits**: One for each contract
- **3 Rents**: Various payment statuses

## Status Values

### Contract Status
- `ACTIF` - Active contract
- `TERMINE` - Terminated contract
- `RESILIE` - Cancelled contract
- `EN_ATTENTE` - Pending contract

### Deposit Status
- `VERSE` - Paid
- `RESTITUE` - Refunded
- `RETENU_PARTIELLEMENT` - Partially retained

### Rent Payment Status
- `EN_ATTENTE` - Pending payment
- `PAYE` - Paid
- `EN_RETARD` - Overdue
- `ANNULE` - Cancelled

## Building the Project

1. Generate JAXB classes from XSD files:
   ```bash
   mvn clean generate-sources
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Using SOAP UI

1. Import the WSDL files from the URLs above
2. SOAP UI will automatically generate test requests
3. Customize the requests with your data
4. Execute to test the services

## Notes

- All dates should be in format: `YYYY-MM-DD` (e.g., "2024-01-01")
- Decimal values should be numbers (e.g., 850.00)
- The `id` field is auto-generated for create operations
- Test data is only created if the database is empty

