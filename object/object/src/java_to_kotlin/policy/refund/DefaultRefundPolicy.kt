package java_to_kotlin.policy.refund

import java_to_kotlin.Money
import java_to_kotlin.Refund
import java_to_kotlin.condition.refund.RefundCondition
import java.util.*

abstract class DefaultRefundPolicy(vararg conditions: RefundCondition?) : RefundPolicy {
    private var conditions: MutableList<RefundCondition> = ArrayList()

    init {
        this.conditions = Arrays.asList(*conditions)
    }

    override fun calculateRefundAmount(refund: Refund): Money? {
        for (each in conditions) {
            if (each.isSatisfiedBy(refund)) {
                return getDiscountAmount(refund)
            }
        }
        return Money.Companion.ZERO
    }

    protected abstract fun getDiscountAmount(refund: Refund): Money?
}
