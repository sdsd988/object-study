package java_to_kotlin.condition.refund

import java_to_kotlin.Refund

interface RefundCondition {
    fun isSatisfiedBy(refund: Refund): Boolean
}
