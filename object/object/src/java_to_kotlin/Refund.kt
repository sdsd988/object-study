package java_to_kotlin

/**
 * refund - 환불과 관련된 정보를 가지고 있음
 */
class Refund(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money?,
    private val audienceCount: Int
)
