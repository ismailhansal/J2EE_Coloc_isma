# Spring Boot SOAP Web Service Setup Guide

## Project Structure

```
src/main/resources/contract.xsd                    # XSD Schema definition
src/main/java/.../config/WebServiceConfig.java    # SOAP Configuration
src/main/java/.../endpoints/ContractSoapEndpoint.java  # SOAP Endpoint
src/main/java/.../service/IServiceContract.java   # Service Interface
src/main/java/.../service/impl/ServiceContractImpl.java  # Service Implementation
src/main/java/.../domain/entity/Contract.java     # Domain Entity (existing)
```

## Prerequisites

- Java 17
- Maven 3.6+
- Spring Boot 3.4.12

## Build Instructions

### Step 1: Generate JAXB Classes from XSD

The JAXB classes are automatically generated during the Maven build process. Run:

```bash
mvn clean generate-sources
```

Or to build the entire project:

```bash
mvn clean install
```

This will:
1. Generate Java classes from `contract.xsd` into `target/generated-sources/xjc`
2. Package them into `com.locaimmo.contract`
3. Add them to the classpath automatically

### Step 2: Verify Generated Classes

After running Maven, verify that the following classes exist:
- `target/generated-sources/xjc/com/locaimmo/contract/GetContractRequest.java`
- `target/generated-sources/xjc/com/locaimmo/contract/GetContractResponse.java`
- `target/generated-sources/xjc/com/locaimmo/contract/ObjectFactory.java`

### Step 3: Run the Application

```bash
mvn spring-boot:run
```

Or if you prefer:

```bash
java -jar target/servicecontrat-0.0.1-SNAPSHOT.jar
```

The application will start on port **8083** (as configured in `application.properties`).

## Accessing the WSDL

Once the application is running, access the WSDL at:

**http://localhost:8083/ws/contract.wsdl**

Open this URL in your browser to view the generated WSDL.

## SOAP Endpoint

The SOAP service is exposed at:

**http://localhost:8083/ws**

## Testing the SOAP Service

### Using cURL

```bash
curl -X POST http://localhost:8083/ws \
  -H "Content-Type: text/xml; charset=utf-8" \
  -H "SOAPAction: \"\"" \
  -d @soap-request.xml
```

### Using Postman

1. Create a new POST request
2. URL: `http://localhost:8083/ws`
3. Headers:
   - `Content-Type: text/xml; charset=utf-8`
   - `SOAPAction: ""`
4. Body: Select "raw" and "XML", then paste the SOAP request from `soap-request.xml`

### Using SOAP UI

1. Create a new SOAP project
2. Initial WSDL: `http://localhost:8083/ws/contract.wsdl`
3. SOAP UI will automatically generate a test request

## SOAP Request Example

See `soap-request.xml` for a complete SOAP 1.1 request example.

## Troubleshooting

### "Content is not allowed in prolog" Error

- Ensure there are no BOM (Byte Order Mark) characters in your XML
- Verify the XML is well-formed
- Check that Content-Type header is `text/xml; charset=utf-8`

### "No adapter for endpoint" Error

- Verify the namespace in `@PayloadRoot` matches the XSD namespace exactly
- Ensure the `localPart` matches the element name in the XSD
- Check that the endpoint is properly annotated with `@Endpoint`

### "Unable to create envelope" Error

- Verify the SOAP envelope structure is correct
- Check that namespace prefixes match (soapenv, con)
- Ensure the request body matches the XSD schema

### Generated Classes Not Found

- Run `mvn clean generate-sources` to regenerate classes
- Verify the package name in `pom.xml` matches `com.locaimmo.contract`
- Check that `target/generated-sources/xjc` is added to the build path

### WSDL Not Accessible

- Verify the application is running on port 8083
- Check that `WebServiceConfig` is properly configured
- Ensure the servlet mapping is `/ws/*`

## Configuration Details

### Namespace Mapping

- **XSD Namespace**: `http://locaimmo.com/contract`
- **Generated Package**: `com.locaimmo.contract`
- **WSDL Namespace**: `http://locaimmo.com/contract`
- **Endpoint Namespace**: `http://locaimmo.com/contract`

All namespaces must match exactly for the service to work correctly.

### Port Configuration

The service runs on port **8083** as configured in `application.properties`:
```
server.port=8083
```

## Maven Dependencies

Key dependencies added:
- `spring-boot-starter-web-services` - Spring WS support
- `wsdl4j` - WSDL generation
- `jakarta.xml.bind-api` - JAXB API (Jakarta EE)
- `jaxb-runtime` - JAXB implementation
- `jaxb2-maven-plugin` - XJC code generation

## Next Steps

1. Run `mvn clean generate-sources` to generate JAXB classes
2. Start the application with `mvn spring-boot:run`
3. Access the WSDL at `http://localhost:8083/ws/contract.wsdl`
4. Test with the provided SOAP request

