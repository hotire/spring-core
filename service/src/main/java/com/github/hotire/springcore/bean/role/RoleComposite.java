package com.github.hotire.springcore.bean.role;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleComposite {

    private final ApplicationContext context;
    private final RoleInfrastructureCore roleInfrastructureCore;


    @PostConstruct
    public void init() {
        log.info("[RoleComposite] roleInfrastructureCore");
    }
}
