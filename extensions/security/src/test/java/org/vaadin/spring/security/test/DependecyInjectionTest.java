/*
 * Copyright 2015 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.spring.security.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.security.VaadinSecurityContext;
import org.vaadin.spring.test.annotation.VaadinAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test Security Bean Injection
 * 
 * @author Gert-Jan Timmer (gjr.timmer@gmail.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@VaadinAppConfiguration
@ContextConfiguration(classes = {DefaultTestConfiguration.class, DefaultSecurityConfiguration.class, DependecyInjectionTest.DependencyConfig.class})
public class DependecyInjectionTest {
    
    @Autowired
    ApplicationContext applicationContext;
    
    @Autowired
    VaadinSecurity vaadinSecurity;
    
    @Autowired
    VaadinSecurityContext vaadinSecurityContext;
    
    @Autowired
    SecurityAwareClass securityAwareClass;
    
    @Test
    public void testSecurityAutowiring() {
        assertNotNull(vaadinSecurity);
        assertNotNull(vaadinSecurityContext);
        assertNotNull(securityAwareClass);
        assertNotNull(securityAwareClass.getVaadinSecurity());
        assertNotNull(securityAwareClass.getVaadinSecurityContext());
    }
    
    @Test
    public void testSecurityAware() {
        VaadinSecurity vaadinSecurity = securityAwareClass.getVaadinSecurity();
        assertEquals(applicationContext, vaadinSecurity.getApplicationContext());
    }
    
    @Configuration
    public static class DependencyConfig {
        
        @Bean
        SecurityAwareClass securityAware() {
            return new SecurityAwareClass();
        }
        
    }

}
