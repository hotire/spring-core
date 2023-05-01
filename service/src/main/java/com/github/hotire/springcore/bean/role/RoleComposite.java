package com.github.hotire.springcore.bean.role;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleComposite {
    private final RoleInfrastructureCore roleInfrastructureCore;

    @PostConstruct
    public void init() {
        log.info("[RoleComposite] roleInfrastructureCore");
    }
}
