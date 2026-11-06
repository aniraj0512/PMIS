package org.quickr.oct26_2026.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMethodExample {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(BeanConfiguration.class)) {

            BasicBean basicBean = context.getBean(BasicBean.class);

            System.out.println(basicBean.getName());
        }
    }
}