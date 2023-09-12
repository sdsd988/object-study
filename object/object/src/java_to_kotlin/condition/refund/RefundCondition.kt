package java_to_kotlin.condition.refund

import java_to_kotlin.Screening

interface RefundCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
