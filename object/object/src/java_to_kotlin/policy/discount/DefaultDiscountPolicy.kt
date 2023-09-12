package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening
import java_to_kotlin.condition.discount.discountCondition
import java.util.*

abstract class DefaultDiscountPolicy(
    vararg conditions: discountCondition?) : DiscountPolicy {
    private val conditions: List<discountCondition> = ArrayList()


    override fun calculateDiscountAmount(screening: Screening): Money? {
        for (each in conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.Companion.ZERO
    }

    protected abstract fun getDiscountAmount(Screening: Screening): Money?
}
