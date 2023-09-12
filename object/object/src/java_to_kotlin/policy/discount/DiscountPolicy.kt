package java_to_kotlin.policy.discount

import java_to_kotlin.Money
import java_to_kotlin.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money?
}
