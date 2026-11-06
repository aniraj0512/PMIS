package org.quickr.oct26_2026.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeExample {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(ScopeConfiguration.class)) {
            SingletonBean firstString=context.getBean(SingletonBean.class);
        }
    }
}
