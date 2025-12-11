package com.locaimmo.servicecontrat.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "contract")
    public DefaultWsdl11Definition contractWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ContractPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://locaimmo.com/contract");
        wsdl11Definition.setSchema(contractSchema());
        return wsdl11Definition;
    }

    @Bean(name = "deposit")
    public DefaultWsdl11Definition depositWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DepositPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://locaimmo.com/deposit");
        wsdl11Definition.setSchema(depositSchema());
        return wsdl11Definition;
    }

    @Bean(name = "rent")
    public DefaultWsdl11Definition rentWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RentPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://locaimmo.com/rent");
        wsdl11Definition.setSchema(rentSchema());
        return wsdl11Definition;
    }

    @Bean(name = "tenant")
    public DefaultWsdl11Definition tenantWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TenantPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://locaimmo.com/tenant");
        wsdl11Definition.setSchema(tenantSchema());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema contractSchema() {
        return new SimpleXsdSchema(new ClassPathResource("contract.xsd"));
    }

    @Bean
    public XsdSchema depositSchema() {
        return new SimpleXsdSchema(new ClassPathResource("deposit.xsd"));
    }

    @Bean
    public XsdSchema rentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("rent.xsd"));
    }

    @Bean
    public XsdSchema tenantSchema() {
        return new SimpleXsdSchema(new ClassPathResource("tenant.xsd"));
    }
}

