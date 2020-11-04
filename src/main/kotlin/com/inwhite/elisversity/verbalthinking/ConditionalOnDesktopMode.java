package com.inwhite.elisversity.verbalthinking;/**
 * @author Evgeny Borisov
 */

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnDesktopModeCondition.class)
public @interface ConditionalOnDesktopMode {
}
