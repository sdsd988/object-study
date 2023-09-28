package java_to_kotlin

import java_to_kotlin.policy.discount.DiscountPolicy
import java_to_kotlin.policy.refund.RefundPolicy
import java.time.Duration

/**
 * Movie : 예매하는 대상의 정보를 갖고 있다.
 * 책임 : 예매 대상 금액 계산
 *
 */
class Movie(private val title: String, private val runningTime: Duration, val fee: Money, private var discountPolicy: DiscountPolicy, private val refundPolicy: RefundPolicy) {
    fun calculateMovieFee(screening: Screening): Money? {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun calculateRefundFee(refund: Refund): Money? {
        return refundPolicy.calculateRefundAmount(refund)
    }

    fun changDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}
