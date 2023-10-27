package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening

class NoneDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money? {
        return Money.Companion.ZERO
    }
}
