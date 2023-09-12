package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening
import java_to_kotlin.condition.discount.discountCondition

class AmountDiscountPolicy(private val discountAmount: Money, vararg conditions: discountCondition?) :
    DefaultDiscountPolicy(*conditions) {
    override fun getDiscountAmount(screening: Screening): Money? {
        return discountAmount
    }
}
