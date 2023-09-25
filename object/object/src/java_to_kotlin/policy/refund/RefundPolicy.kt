package java_to_kotlin.policy.refund

import java_to_kotlin.Money
import java_to_kotlin.Refund

interface RefundPolicy {
    fun calculateRefundAmount(refund: Refund): Money?
}
