package java_to_kotlin

import java.math.BigDecimal
import java.util.*

class Money internal constructor(private val amount: BigDecimal) {
    operator fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    operator fun minus(amount: Money?): Money {
        return Money(this.amount.subtract(amount!!.amount))
    }

    operator fun times(percent: Double): Money {
        return Money(amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun isLessThan(other: Money): Boolean {
        return amount.compareTo(other.amount) < 0
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount.compareTo(other.amount) >= 0
    }

    override fun equals(`object`: Any?): Boolean {
        if (this === `object`) {
            return true
        }
        if (`object` !is Money) {
            return false
        }
        return amount.toDouble() == `object`.amount.toDouble()
    }

    override fun hashCode(): Int {
        return Objects.hashCode(amount)
    }

    override fun toString(): String {
        return amount.toString() + "원"
    }

    companion object {
        val ZERO = wons(0)
        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }
}
