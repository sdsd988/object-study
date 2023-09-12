package java_to_kotlin

import java_to_kotlin.policy.discount.DiscountPolicy
import java.time.Duration

/**
 * 영화 객체의 역할 : 예매 금액 계산
 *
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private var discountPolicy: DiscountPolicy
) {
    fun calculateMovieFee(screening: Screening): Money? {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun changDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}
