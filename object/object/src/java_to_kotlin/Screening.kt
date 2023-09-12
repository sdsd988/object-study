package java_to_kotlin

import java.time.LocalDateTime

/**
 * Screening 역할 : 1. 영화 예매
 * 2. 예매 취소
 */
class Screening(private val movie: Movie, private val sequence: Int, val startTime: LocalDateTime) {
    private val refundCalculate: RefundCalculate? = null

    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    val movieFee: Money?
        get() = movie.fee

    fun reserve(customer: Customer?, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money? {
        return movie.calculateMovieFee(this)!!.times(audienceCount.toDouble())
    }

    fun refund(customer: Customer, audienceCount: Int): Refund {
        return Refund(customer, this, calculateRefundFee(audienceCount), audienceCount)
    }

    private fun calculateRefundFee(audienceCount: Int): Money? {
        return refundCalculate!!.calculateRefundFee(this)!!.times(audienceCount.toDouble())
    }
}
