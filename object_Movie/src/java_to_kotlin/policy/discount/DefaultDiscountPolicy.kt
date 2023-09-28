package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening
import java_to_kotlin.condition.discount.DiscountCondition
import java.util.*

abstract class DefaultDiscountPolicy(vararg conditions: DiscountCondition?) : DiscountPolicy {
    private var conditions: MutableList<DiscountCondition> = ArrayList()

    init {
        this.conditions = Arrays.asList(*conditions)
    }

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
