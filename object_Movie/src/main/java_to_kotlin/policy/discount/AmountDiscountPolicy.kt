package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening
import java_to_kotlin.condition.discount.DiscountCondition

class AmountDiscountPolicy(private val discountAmount: Money, vararg conditions: DiscountCondition?) : DefaultDiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money? {
        return discountAmount
    }
}
