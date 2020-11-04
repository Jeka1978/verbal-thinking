package com.inwhite.elisversity.verbalthinking

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

class OnDesktopModeCondition :Condition{
    override fun matches(p0: ConditionContext, p1: AnnotatedTypeMetadata): Boolean {
        return System.getProperty("java.awt.headless") == "false"
    }

}
