package java_to_kotlin.policy.refund

import java_to_kotlin.Money
import java_to_kotlin.Screening

interface RefundPolicy {
    fun calculateRefundAmount(screening: Screening): Money
}
