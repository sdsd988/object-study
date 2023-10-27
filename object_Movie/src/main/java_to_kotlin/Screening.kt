package java_to_kotlin

import java.time.LocalDateTime

/**
 * Screening 역할 : 사용자들이 예매하는 대상
 * Screening 책임 : 1. 예매
 * 2. 환불
 *
 */
class Screening(val movie: Movie, private val sequence: Int, val startTime: LocalDateTime) {
    private val maxAudience: Int? = null
    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    val movieFee: Money?
        get() = movie.fee

    fun reserve(customer: Customer?, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    fun calculateFee(audienceCount: Int): Money? {
        return movie.calculateMovieFee(this)!!.times(audienceCount.toDouble())
    }

    fun refundCalculator(refund: Refund): Money? {
        return movie.calculateRefundFee(refund)
    }
}
