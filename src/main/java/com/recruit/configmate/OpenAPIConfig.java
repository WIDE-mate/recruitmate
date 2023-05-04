package com.recruit.configmate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
            title = "채용 사이트 API",
            description = "API Description",
            version = "v1.0.0"
    )
)
@Configuration
public class OpenAPIConfig {

//    @Bean
//    public OpenApiCustomiser globalOpenApiCustomiser(){
//        return openApi -> {
//            ApiResponse ok = new ApiResponse().description("dfd").con;
//            ApiResponse not_found = new ApiResponse().description("");
//            ApiResponse err = new ApiResponse().description("");
//
//            openApi.getPaths().values().stream()
//                    .flatMap(pathItem -> pathItem.readOperations().stream())
//                    .forEach(operation -> operation.addParametersItem(new HeaderParameter().$ref("#/components/parameters/myGlobalHeader")));
//        };
//    }

}
