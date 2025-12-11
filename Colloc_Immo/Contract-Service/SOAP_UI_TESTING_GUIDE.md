# SOAP UI Testing Guide

Complete guide for testing all SOAP operations using SOAP UI or any SOAP client.

## Base Information

- **SOAP Endpoint**: `http://localhost:8083/ws`
- **WSDL URLs**:
  - Contract: `http://localhost:8083/ws/contract.wsdl`
  - Deposit: `http://localhost:8083/ws/deposit.wsdl`
  - Rent: `http://localhost:8083/ws/rent.wsdl`
  - Tenant: `http://localhost:8083/ws/tenant.wsdl`

## Headers Required

All requests should include:
```
Content-Type: text/xml; charset=utf-8
SOAPAction: ""
```

---

## 1. CONTRACT Operations

### 1.1 GetContractRequest - Retrieve Contract by ID

**Operation**: Get a contract by its ID

**SOAP Request**:
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

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:GetContractResponse xmlns:ns2="http://locaimmo.com/contract">
         <ns2:id>1</ns2:id>
         <ns2:statut>ACTIF</ns2:statut>
         <ns2:loyerMensuel>850.00</ns2:loyerMensuel>
      </ns2:GetContractResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

**Test with different IDs**: Try `1`, `2`, or any ID that exists in your database.

---

### 1.2 CreateContractRequest - Create New Contract

**Operation**: Create a new contract in the database

**SOAP Request**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:CreateContractRequest>
         <con:propertyId>3</con:propertyId>
         <con:tenantId>1</con:tenantId>
         <con:proprietaireId>1</con:proprietaireId>
         <con:dateDebut>2024-03-01</con:dateDebut>
         <con:dateFin>2025-02-28</con:dateFin>
         <con:loyerMensuel>950.00</con:loyerMensuel>
         <con:depotGarantie>1900.00</con:depotGarantie>
         <con:statut>ACTIF</con:statut>
         <con:conditions>New contract with updated conditions</con:conditions>
      </con:CreateContractRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:CreateContractResponse xmlns:ns2="http://locaimmo.com/contract">
         <ns2:id>3</ns2:id>
         <ns2:statut>ACTIF</ns2:statut>
         <ns2:loyerMensuel>950.00</ns2:loyerMensuel>
         <ns2:message>Contract created successfully</ns2:message>
      </ns2:CreateContractResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

**Valid Status Values**: `ACTIF`, `TERMINE`, `RESILIE`, `EN_ATTENTE`

**Example Variations**:
- Create contract with status `EN_ATTENTE`:
```xml
<con:statut>EN_ATTENTE</con:statut>
```

- Create contract without conditions (optional field):
```xml
<con:CreateContractRequest>
   <con:propertyId>4</con:propertyId>
   <con:tenantId>2</con:tenantId>
   <con:proprietaireId>1</con:proprietaireId>
   <con:dateDebut>2024-04-01</con:dateDebut>
   <con:dateFin>2025-03-31</con:dateFin>
   <con:loyerMensuel>1100.00</con:loyerMensuel>
   <con:depotGarantie>2200.00</con:depotGarantie>
   <con:statut>ACTIF</con:statut>
</con:CreateContractRequest>
```

---

## 2. DEPOSIT Operations

### 2.1 GetDepositRequest - Retrieve Deposit by ID

**Operation**: Get a deposit by its ID

**SOAP Request**:
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

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:GetDepositResponse xmlns:ns2="http://locaimmo.com/deposit">
         <ns2:id>1</ns2:id>
         <ns2:contractId>1</ns2:contractId>
         <ns2:montant>1700.00</ns2:montant>
         <ns2:statut>VERSE</ns2:statut>
      </ns2:GetDepositResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### 2.2 CreateDepositRequest - Create New Deposit

**Operation**: Create a new deposit for a contract

**SOAP Request**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:dep="http://locaimmo.com/deposit">
   <soapenv:Header/>
   <soapenv:Body>
      <dep:CreateDepositRequest>
         <dep:contractId>1</dep:contractId>
         <dep:montant>2000.00</dep:montant>
         <dep:dateVersement>2024-03-15</dep:dateVersement>
         <dep:statut>VERSE</dep:statut>
      </dep:CreateDepositRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:CreateDepositResponse xmlns:ns2="http://locaimmo.com/deposit">
         <ns2:id>3</ns2:id>
         <ns2:montant>2000.00</ns2:montant>
         <ns2:statut>VERSE</ns2:statut>
         <ns2:message>Deposit created successfully</ns2:message>
      </ns2:CreateDepositResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

**Valid Status Values**: `VERSE`, `RESTITUE`, `RETENU_PARTIELLEMENT`

**Example Variations**:
- Create deposit with status `RESTITUE`:
```xml
<dep:statut>RESTITUE</dep:statut>
```

- Create deposit with status `RETENU_PARTIELLEMENT`:
```xml
<dep:statut>RETENU_PARTIELLEMENT</dep:statut>
```/

---

## 3. RENT Operations

### 3.1 GetRentRequest - Retrieve Rent by ID

**Operation**: Get a rent payment by its ID

**SOAP Request**:
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

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:GetRentResponse xmlns:ns2="http://locaimmo.com/rent">
         <ns2:id>1</ns2:id>
         <ns2:contractId>1</ns2:contractId>
         <ns2:montant>850.00</ns2:montant>
         <ns2:statutPaiement>PAYE</ns2:statutPaiement>
      </ns2:GetRentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### 3.2 CreateRentRequest - Create New Rent

**Operation**: Create a new rent payment record

**SOAP Request**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rent="http://locaimmo.com/rent">
   <soapenv:Header/>
   <soapenv:Body>
      <rent:CreateRentRequest>
         <rent:contractId>1</rent:contractId>
         <rent:mois>3</rent:mois>
         <rent:annee>2024</rent:annee>
         <rent:montant>850.00</rent:montant>
         <rent:dateEcheance>2024-03-05</rent:dateEcheance>
         <rent:statutPaiement>EN_ATTENTE</rent:statutPaiement>
      </rent:CreateRentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:CreateRentResponse xmlns:ns2="http://locaimmo.com/rent">
         <ns2:id>4</ns2:id>
         <ns2:montant>850.00</ns2:montant>
         <ns2:statutPaiement>EN_ATTENTE</ns2:statutPaiement>
         <ns2:message>Rent created successfully</ns2:message>
      </ns2:CreateRentResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

**Valid Status Values**: `EN_ATTENTE`, `PAYE`, `EN_RETARD`, `ANNULE`

**Example Variations**:
- Create rent with status `PAYE`:
```xml
<rent:statutPaiement>PAYE</rent:statutPaiement>
```

- Create rent for different month/year:
```xml
<rent:mois>6</rent:mois>
<rent:annee>2024</rent:annee>
<rent:dateEcheance>2024-06-05</rent:dateEcheance>
```

- Create overdue rent:
```xml
<rent:statutPaiement>EN_RETARD</rent:statutPaiement>
```

---

## 4. TENANT Operations

### 4.1 GetTenantRequest - Retrieve Tenant by ID

**Operation**: Get a tenant by its ID

**SOAP Request**:
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

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:GetTenantResponse xmlns:ns2="http://locaimmo.com/tenant">
         <ns2:id>1</ns2:id>
         <ns2:nom>Dupont</ns2:nom>
         <ns2:prenom>Jean</ns2:prenom>
         <ns2:email>jean.dupont@example.com</ns2:email>
      </ns2:GetTenantResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### 4.2 CreateTenantRequest - Create New Tenant

**Operation**: Create a new tenant

**SOAP Request**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ten="http://locaimmo.com/tenant">
   <soapenv:Header/>
   <soapenv:Body>
      <ten:CreateTenantRequest>
         <ten:userId>3</ten:userId>
         <ten:nom>Bernard</ten:nom>
         <ten:prenom>Pierre</ten:prenom>
         <ten:email>pierre.bernard@example.com</ten:email>
         <ten:telephone>0147258369</ten:telephone>
      </ten:CreateTenantRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Expected Response**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:CreateTenantResponse xmlns:ns2="http://locaimmo.com/tenant">
         <ns2:id>3</ns2:id>
         <ns2:nom>Bernard</ns2:nom>
         <ns2:prenom>Pierre</ns2:prenom>
         <ns2:email>pierre.bernard@example.com</ns2:email>
         <ns2:message>Tenant created successfully</ns2:message>
      </ns2:CreateTenantResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

**Example Variations**:
- Create tenant without telephone (optional field):
```xml
<ten:CreateTenantRequest>
   <ten:userId>4</ten:userId>
   <ten:nom>Lefebvre</ten:nom>
   <ten:prenom>Sophie</ten:prenom>
   <ten:email>sophie.lefebvre@example.com</ten:email>
</ten:CreateTenantRequest>
```

---

## Testing Workflow Examples

### Workflow 1: Create a Complete Rental Scenario

1. **Create a Tenant**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ten="http://locaimmo.com/tenant">
   <soapenv:Header/>
   <soapenv:Body>
      <ten:CreateTenantRequest>
         <ten:userId>5</ten:userId>
         <ten:nom>Moreau</ten:nom>
         <ten:prenom>Claire</ten:prenom>
         <ten:email>claire.moreau@example.com</ten:email>
         <ten:telephone>0198765432</ten:telephone>
      </ten:CreateTenantRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
Note the returned `id` (e.g., `5`)

2. **Create a Contract for that Tenant**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:CreateContractRequest>
         <con:propertyId>5</con:propertyId>
         <con:tenantId>5</con:tenantId>
         <con:proprietaireId>1</con:proprietaireId>
         <con:dateDebut>2024-05-01</con:dateDebut>
         <con:dateFin>2025-04-30</con:dateFin>
         <con:loyerMensuel>1000.00</con:loyerMensuel>
         <con:depotGarantie>2000.00</con:depotGarantie>
         <con:statut>ACTIF</con:statut>
         <con:conditions>New tenant contract</con:conditions>
      </con:CreateContractRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
Note the returned contract `id` (e.g., `5`)

3. **Create a Deposit for that Contract**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:dep="http://locaimmo.com/deposit">
   <soapenv:Header/>
   <soapenv:Body>
      <dep:CreateDepositRequest>
         <dep:contractId>5</dep:contractId>
         <dep:montant>2000.00</dep:montant>
         <dep:dateVersement>2024-05-01</dep:dateVersement>
         <dep:statut>VERSE</dep:statut>
      </dep:CreateDepositRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

4. **Create Rent Payments for that Contract**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rent="http://locaimmo.com/rent">
   <soapenv:Header/>
   <soapenv:Body>
      <rent:CreateRentRequest>
         <rent:contractId>5</rent:contractId>
         <rent:mois>5</rent:mois>
         <rent:annee>2024</rent:annee>
         <rent:montant>1000.00</rent:montant>
         <rent:dateEcheance>2024-05-05</rent:dateEcheance>
         <rent:statutPaiement>EN_ATTENTE</rent:statutPaiement>
      </rent:CreateRentRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

5. **Verify by Getting the Contract**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:GetContractRequest>
         <con:id>5</con:id>
      </con:GetContractRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

---

### Workflow 2: Check Existing Test Data

The application initializes test data on startup. Test retrieving them:

1. **Get Tenant 1**:
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

2. **Get Contract 1**:
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

3. **Get Deposit 1**:
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

4. **Get Rent 1**:
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

---

## Using SOAP UI

### Step 1: Import WSDL Files

1. Open SOAP UI
2. File → New SOAP Project
3. Enter project name: "Contract Services"
4. For each WSDL, click "Add WSDL":
   - `http://localhost:8083/ws/contract.wsdl`
   - `http://localhost:8083/ws/deposit.wsdl`
   - `http://localhost:8083/ws/rent.wsdl`
   - `http://localhost:8083/ws/tenant.wsdl`

### Step 2: Test Operations

1. Expand the imported services
2. Double-click on any operation (e.g., "GetContractRequest")
3. SOAP UI will generate a sample request
4. Modify the values as needed
5. Click the green play button to execute
6. View the response in the right panel

### Step 3: Create Test Suites (Optional)

1. Right-click on the project
2. New TestSuite
3. Add test cases for each operation
4. Run the entire test suite

---

## Using cURL (Command Line)

### Example: Get Contract
```bash
curl -X POST http://localhost:8083/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: \"\"" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:GetContractRequest>
         <con:id>1</con:id>
      </con:GetContractRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

### Example: Create Contract
```bash
curl -X POST http://localhost:8083/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: \"\"" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:con="http://locaimmo.com/contract">
   <soapenv:Header/>
   <soapenv:Body>
      <con:CreateContractRequest>
         <con:propertyId>6</con:propertyId>
         <con:tenantId>1</con:tenantId>
         <con:proprietaireId>1</con:proprietaireId>
         <con:dateDebut>2024-06-01</con:dateDebut>
         <con:dateFin>2025-05-31</con:dateFin>
         <con:loyerMensuel>1050.00</con:loyerMensuel>
         <con:depotGarantie>2100.00</con:depotGarantie>
         <con:statut>ACTIF</con:statut>
         <con:conditions>Test contract via cURL</con:conditions>
      </con:CreateContractRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

---

## Important Notes

1. **Date Format**: Always use `YYYY-MM-DD` format (e.g., `2024-01-01`)

2. **Decimal Values**: Use numbers without quotes (e.g., `850.00`, not `"850.00"`)

3. **Status Values**: Must match exactly (case-sensitive):
   - Contract: `ACTIF`, `TERMINE`, `RESILIE`, `EN_ATTENTE`
   - Deposit: `VERSE`, `RESTITUE`, `RETENU_PARTIELLEMENT`
   - Rent: `EN_ATTENTE`, `PAYE`, `EN_RETARD`, `ANNULE`

4. **ID Generation**: IDs are auto-generated by the database. Don't include `id` in create requests.

5. **Optional Fields**:
   - Contract: `conditions` (can be omitted)
   - Tenant: `telephone` (can be omitted)

6. **Error Handling**: If an ID doesn't exist, you'll get a response with `NOT_FOUND` status or empty values.

7. **Namespace Prefixes**: The namespace prefixes (`con:`, `dep:`, `rent:`, `ten:`) can be any value, but the namespace URIs must match exactly.

---

## Quick Reference Table

| Entity | Get Operation | Create Operation | WSDL |
|--------|--------------|------------------|------|
| Contract | GetContractRequest | CreateContractRequest | /ws/contract.wsdl |
| Deposit | GetDepositRequest | CreateDepositRequest | /ws/deposit.wsdl |
| Rent | GetRentRequest | CreateRentRequest | /ws/rent.wsdl |
| Tenant | GetTenantRequest | CreateTenantRequest | /ws/tenant.wsdl |

---

## Troubleshooting

### "No adapter for endpoint" Error
- Check that the namespace in your request matches the XSD namespace exactly
- Verify the `localPart` matches the element name

### "Content is not allowed in prolog" Error
- Ensure there are no BOM characters
- Check XML is well-formed
- Verify Content-Type header is `text/xml; charset=utf-8`

### "Unable to create envelope" Error
- Verify SOAP envelope structure
- Check namespace prefixes match
- Ensure request body matches XSD schema

### Empty or NOT_FOUND Responses
- The ID might not exist in the database
- Try using IDs from the test data (1, 2, etc.)
- Create new records first, then query them

---

## Test Data Summary

On first startup, the application creates:
- **Tenant ID 1**: Jean Dupont
- **Tenant ID 2**: Marie Martin
- **Contract ID 1**: For Tenant 1, 850.00/month
- **Contract ID 2**: For Tenant 2, 1200.00/month
- **Deposit ID 1**: For Contract 1, 1700.00
- **Deposit ID 2**: For Contract 2, 2400.00
- **Rent ID 1**: For Contract 1, January 2024, PAID
- **Rent ID 2**: For Contract 1, February 2024, PENDING
- **Rent ID 3**: For Contract 2, February 2024, PAID

Use these IDs to test the GET operations immediately after starting the application.

