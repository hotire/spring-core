package com.github.hotire.springcore.argument;

import org.springframework.stereotype.Component;

import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
public class EntityArgumentParameterBuilderPlugin implements ParameterBuilderPlugin {

    @Override
    public void apply(ParameterContext parameterContext) {
        parameterContext.resolvedMethodParameter()
                        .findAnnotation(EntityArgument.class)
                        .toJavaUtil()
                        .ifPresent(entityArgument -> parameterContext.parameterBuilder()
                                                                     .name(entityArgument.value())
                                                                     .required(true)
                                                                     .parameterType(entityArgument.parameterType())
                                                                     .modelRef(new ModelRef("string"))
                                                                     .build());
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return SwaggerPluginSupport.pluginDoesApply(delimiter);
    }
}
