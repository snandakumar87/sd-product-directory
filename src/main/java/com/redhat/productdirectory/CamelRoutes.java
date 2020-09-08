package com.redhat.productdirectory;

import javax.annotation.Generated;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Generated from Swagger specification by Camel REST DSL generator.
 */
@Component

@Generated("org.apache.camel.generator.swagger.PathGenerator")
public final class CamelRoutes extends RouteBuilder {
    /**
     * Defines Apache Camel routes using REST DSL fluent API.
     */

    @Value("${oc.project.path}")
    String projectPath;

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/service/*");
        registration.setName("CamelServlet");
        return registration;
    }
    //Method Configure
    public void configure() throws UnknownHostException {


        //This is a new comment for the method
        restConfiguration()
                .component("servlet")

                .bindingMode(RestBindingMode.auto)
                .producerComponent("http4")
                .apiContextPath("/swagger") //swagger endpoint path
                .apiContextRouteId("swagger") //id of route providing the swagger endpoint

                .contextPath("/service")
                //Swagger properties
                .host(projectPath)
                .apiProperty("api.title", "Example REST api")
                .apiProperty("api.version", "1.0")
        .apiProperty("api.path","/service")
        ;
        rest()
            .post("/product-directory/activation")
                .id("activateSDProductDirectory")
                .description("Activate  a  SDProductDirectory servicing session")
                .produces("application/json")
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDProductDirectory Request Payload")
                .endParam()
                .to("direct:activateSDProductDirectory")
            .put("/product-directory/{sd-reference-id}/configuration")
                .id("configureSDProductDirectory")
                .description("Update an active SDProductDirectory session configuration")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDProductDirectory Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Configure Request Payload")
                .endParam()
                .to("direct:configureSDProductDirectory")
            .put("/product-directory/{sd-reference-id}/feedback")
                .id("feedbackSDProductDirectory")
                .description("Capturing feedback against the SDProductDirectory service that can target different levels of detail: SD/CR/BQ")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDProductDirectory Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SDProductDirectory Feedback Request Payload")
                .endParam()
                .to("direct:feedbackSDProductDirectory")
            .get("/product-directory/{sd-reference-id}")
                .id("retrieveSDProductDirectory")
                .description("Analytical views maintained by the SDProductDirectory service center for management reporting and analysis purposes")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SDProductDirectory Servicing Session Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/SDProductDirectoryRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveSDProductDirectory")
            .post("/product-directory/{sd-reference-id}/product-directory-entry/registration")
                .id("registerProductDirectoryEntry")
                .description("Register a new product or service in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("ProductDirectoryEntry Request Payload")
                .endParam()
                .to("direct:registerProductDirectoryEntry")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/update")
                .id("updateProductDirectoryEntry")
                .description("Update details of a product or service in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:updateProductDirectoryEntry")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/requisition")
                .id("requestProductDirectoryEntryUpdate")
                .description("Request that an existing entry is updated or revised")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:requestProductDirectoryEntryUpdate")
            .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}")
                .id("retrieveProductDirectory")
                .description("Retrieve product or service details from the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/CRProductDirectoryEntryRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveProductDirectory")
            .post("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/operations/registration")
                .id("registerProductDirectoryEntryOperations")
                .description("Register a new product or service operations details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:registerProductDirectoryEntryOperations")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/operations/{bq-reference-id}/update")
                .id("updateProductDirectoryEntryOperations")
                .description("Update details of a product or service operations details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Operations Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Operations Request Payload")
                .endParam()
                .to("direct:updateProductDirectoryEntryOperations")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/operations/{bq-reference-id}/requisition")
                .id("requestProductDirectoryEntryOperationsUpdate")
                .description("Request that an existing entry is updated or revised")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Operations Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Operations request payload")
                .endParam()
                .to("direct:requestProductDirectoryEntryOperationsUpdate")
            .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/operations/{bq-reference-id}/")
                .id("retrieveProductDirectoryEntryOperations")
                .description("Retrieve product or service operations details from the catalog .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Operations Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/BQOperationsRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveProductDirectoryEntryOperations")
            .post("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/salesandmarketing/registration")
                .id("registerProductDirectoryEntrySalesandMarketing")
                .description("Register a new product or service sales and marketing details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:registerProductDirectoryEntrySalesandMarketing")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/salesandmarketing/{bq-reference-id}/update")
                .id("updateProductDirectoryEntrySalesandMarketing")
                .description("Update details of a product or service sales and marketing details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SalesandMarketing Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SalesandMarketing Request Payload")
                .endParam()
                .to("direct:updateProductDirectoryEntrySalesandMarketing")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/salesandmarketing/{bq-reference-id}/requisition")
                .id("requestProductDirectoryEntrySalesandMarketingUpdate")
                .description("Request that an existing entry is updated or revised")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SalesandMarketing Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("SalesandMarketing request payload")
                .endParam()
                .to("direct:requestProductDirectoryEntrySalesandMarketingUpdate")
            .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/salesandmarketing/{bq-reference-id}/")
                .id("retrieveProductDirectoryEntrySalesandMarketing")
                .description("Retrieve product or service sales and marketing details from the catalog .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("SalesandMarketing Instance Reference")
                .endParam()
                .param()
                    .name("queryparams")
                    .type(RestParamType.query)
                    .dataType("string")
                    .required(false)
                    .description("Query params from schema '#/definitions/BQSalesandMarketingRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveProductDirectoryEntrySalesandMarketing")
            .post("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/servicing/registration")
                .id("registerProductDirectoryEntryServicing")
                .description("Register a new product or service servicing details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:registerProductDirectoryEntryServicing")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/servicing/{bq-reference-id}/update")
                .id("updateProductDirectoryEntryServicing")
                .description("Update details of a product or service servicing details in the catalog")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Servicing Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Servicing Request Payload")
                .endParam()
                .to("direct:updateProductDirectoryEntryServicing")
            .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/servicing/{bq-reference-id}/requisition")
                .id("requestProductDirectoryEntryServicingUpdate")
                .description("Request that an existing entry is updated or revised")
                .produces("application/json")
                .param()
                    .name("sd-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                    .name("cr-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                    .name("bq-reference-id")
                    .type(RestParamType.path)
                    .dataType("string")
                    .required(true)
                    .description("Servicing Instance Reference")
                .endParam()
                .param()
                    .name("body")
                    .type(RestParamType.body)
                    .required(true)
                    .description("Servicing request payload")
                .endParam()
                .to("direct:requestProductDirectoryEntryServicingUpdate");
        rest()

        .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/servicing/{bq-reference-id}/")
                .id("retrieveProductDirectoryEntryServicing")
                .description("Retrieve product or service servicing details from the catalog .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Servicing Instance Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/BQServicingRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveProductDirectoryEntryServicing")
                .post("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/production/registration")
                .id("registerProductDirectoryEntryProduction")
                .description("Register a new product or service production details in the catalog")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Product Directory Entry Request Payload")
                .endParam()
                .to("direct:registerProductDirectoryEntryProduction")
                .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/production/{bq-reference-id}/update")
                .id("updateProductDirectoryEntryProduction")
                .description("Update details of a product or service production details in the catalog")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Production Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Production Request Payload")
                .endParam()
                .to("direct:updateProductDirectoryEntryProduction")
                .put("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/production/{bq-reference-id}/requisition")
                .id("requestProductDirectoryEntryProductionUpdate")
                .description("Request that an existing entry is updated or revised")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Production Instance Reference")
                .endParam()
                .param()
                .name("body")
                .type(RestParamType.body)
                .required(true)
                .description("Production request payload")
                .endParam()
                .to("direct:requestProductDirectoryEntryProductionUpdate")
                .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/production/{bq-reference-id}/")
                .id("retrieveProductDirectoryEntryProduction")
                .description("Retrieve product or service production details from the catalog .The retrieve operation can have sub qualifiers beyond BQ level, please reffer to the model heriarchy to extend beyond BQ level into APIs retrieving sub-qualifier level information.")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("bq-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Production Instance Reference")
                .endParam()
                .param()
                .name("queryparams")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Query params from schema '#/definitions/BQProductionRetrieveInputModel'")
                .endParam()
                .to("direct:retrieveProductDirectoryEntryProduction")
                .get("/product-directory/{sd-reference-id}/product-directory-entry")
                .id("RetrieveProductDirectoryReferenceIds")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("collection-filter")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Filter to refine the result set. ex- ProductDirectory Instance Status='active'")
                .endParam()
                .to("direct:RetrieveProductDirectoryReferenceIds")
                .get("/product-directory/product-directory-entry/behavior-qualifiers/")
                .id("RetrieveProductDirectoryBehaviorQualifiers")
                .produces("application/json")
                .to("direct:RetrieveProductDirectoryBehaviorQualifiers")
                .get("/product-directory/{sd-reference-id}/product-directory-entry/{cr-reference-id}/{behavior-qualifier}/")
                .id("RetrieveProductDirectoryBehaviorQualifierReferenceIds")
                .produces("application/json")
                .param()
                .name("sd-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Servicing Session Reference")
                .endParam()
                .param()
                .name("cr-reference-id")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Product Directory Entry Instance Reference")
                .endParam()
                .param()
                .name("behavior-qualifier")
                .type(RestParamType.path)
                .dataType("string")
                .required(true)
                .description("Behavior Qualifier Name. ex- Production")
                .endParam()
                .param()
                .name("collection-filter")
                .type(RestParamType.query)
                .dataType("string")
                .required(false)
                .description("Filter to refine the result set. ex- Production Instance Status = 'pending'")
                .endParam()
                .to("direct:RetrieveProductDirectoryBehaviorQualifierReferenceIds");


        from("direct:retrieveProductDirectoryEntrySalesandMarketing")
                .bean(TransformerBean.class,"retrieveSalesandmarketing");
//        .setBody(simple("hello"));



    }
}
