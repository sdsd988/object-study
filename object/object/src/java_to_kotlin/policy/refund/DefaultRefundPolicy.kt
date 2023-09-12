package java_to_kotlin.policy.refund

import java_to_kotlin.Money
import java_to_kotlin.Screening
import java_to_kotlin.condition.refund.RefundCondition

internal abstract class DefaultRefundPolicy(
    private val conditions: List<RefundCondition>) : RefundPolicy {


    override fun calculateRefundAmount(screening: Screening): Money {
        for (each in conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.Companion.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening?): Money
}
