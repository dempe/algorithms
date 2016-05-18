package com.project.euler.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextLoader {

    private ApplicationContextLoader() {}

    public static ApplicationContext loadConfigurations(final Class<?>... annotatedClasses) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.registerShutdownHook();
        annotationConfigApplicationContext.register(annotatedClasses);
        annotationConfigApplicationContext.refresh();

        return annotationConfigApplicationContext;
    }

}
