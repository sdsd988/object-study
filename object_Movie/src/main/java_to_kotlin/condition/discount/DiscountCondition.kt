package java_to_kotlin.condition.discount

import java_to_kotlin.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}
