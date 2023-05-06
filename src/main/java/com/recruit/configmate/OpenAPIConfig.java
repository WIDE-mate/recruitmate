package com.recruit.configmate;

import com.recruit.commonmate.dto.ResponseError;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.util.Map;
import java.util.function.Predicate;

@OpenAPIDefinition(
        info = @Info(
                title = "채용 사이트 API",
                description = "API Description",
                version = "v1.0.0"
        )
)
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenApiCustomiser globalOpenApiCustomiser(){

        ApiResponse notFound = new ApiResponse().description("Not found");
        ApiResponse err = new ApiResponse().description("message 를 확인해주세요.");

        MediaType mediaType = new MediaType().schema(new ObjectSchema().$ref("#/components/schemas/ResponseError"));

        Content content = new Content().addMediaType("application/json",mediaType);
        err.setContent(content);

        return openApi -> {
            openApi.getPaths().values().stream()
                    .flatMap(pathItem -> pathItem.readOperations().stream())
                    .map(Operation::getResponses)
                    .forEach(responses -> {
                        if(responses == null) responses = new ApiResponses();
                        responses.addApiResponse("404",notFound);
                        responses.addApiResponse("4XX, 5XX",err);
                    });

            openApi.getPaths().remove("/api/json/error");

            openApi.getComponents().getSchemas().entrySet()
                    .removeIf(entry -> entry.getKey().startsWith("Response"));
        };
    }

}
