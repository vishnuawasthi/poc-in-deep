package com.app.config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@SpringBootConfiguration
public class DroolsConfig {
	
	@Bean("drlFilesRuleContainer")
	public KieContainer kieContainer() {
	//	KieContainer kieContainer = KieServices.get().getKieClasspathContainer();
		KieContainer kieContainer = KieServices.get().newKieClasspathContainer();
		return kieContainer;
	}

	
	@Bean("drlFilesRuleSession")
	@DependsOn("drlFilesRuleContainer")
	public KieSession kieSession( @Qualifier("drlFilesRuleContainer")  @Autowired KieContainer kieContainer) throws IOException {
		KieSession kieSession = kieContainer.newKieSession("drlRulesSession");
		
		kieSession.addEventListener(new DefaultAgendaEventListener() {
			@Override
			public void afterMatchFired(AfterMatchFiredEvent event) {
				System.out.println("Matched Fired    -> "+event.getMatch().getRule().getName());
			}
		});
		return kieSession;
	}
}
