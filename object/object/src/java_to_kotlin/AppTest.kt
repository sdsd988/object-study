package java_to_kotlin

import java_to_kotlin.condition.discount.PeriodCondition
import java_to_kotlin.condition.discount.SequenceCondition
import java_to_kotlin.condition.refund.TimeCondition
import java_to_kotlin.policy.discount.AmountDiscountPolicy
import java_to_kotlin.policy.discount.PercentDiscountPolicy
import java_to_kotlin.policy.refund.AmountRefundPolicy
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

object AppTest {

    @JvmStatic
    fun main(args: Array<String>) {
        println("============================ ")
        println("AmountDiscountPolicy 예매 테스트")
        println("============================ ")

        //given
        val amountMovie = Movie("오펜하이머",
                Duration.ofMillis(180),
                Money.Companion.wons(12000),
                AmountDiscountPolicy(Money.Companion.wons(2000),
                        SequenceCondition(1), SequenceCondition(10),
                        PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)
                        )
                ), AmountRefundPolicy(TimeCondition(LocalDateTime.now()))
        )

        //when
        val testScreening1 = Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 10, 10))
        val fee1 = testScreening1.calculateFee(1)
        println("테스트 : 할인 조건(순번,기간 조건)에 부합하면 양적 할인 가격 적용된다.")

        // then
        if (fee1 == amountMovie.fee.minus(Money.Companion.wons(2000))) {
            println("테스트 성공")
        } else println("테스트 실패")

        //when
        val testScreening2 = Screening(amountMovie, 1, LocalDateTime.of(2023, 9, 13, 14, 10))
        val fee2 = testScreening1.calculateFee(1)
        println("테스트 : 할인 조건(순번 조건)에 부합하면 양적 할인 가격 적용된다.")
        //then
        if (fee1 == amountMovie.fee.minus(Money.Companion.wons(2000))) {
            println("테스트 성공")
        } else println("테스트 실패")

        //when
        val testScreening3 = Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 13, 10, 10))
        val fee3 = testScreening1.calculateFee(1)
        println("테스트 : 할인 조건(기간 조건)에 부합하면 양적 할인 가격 적용된다.")
        //then
        if (fee3 == Money.Companion.wons(10000)) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("테스트 : 할인 조건에 부합하지 않으면 양적 할인이 적용되지 않는다.")
        val testScreening4 = Screening(amountMovie, 4, LocalDateTime.of(2023, 9, 14, 15, 10))
        val fee4 = testScreening4.calculateFee(1)
        if (fee4 == amountMovie.fee) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("테스트 : 여러명이 티켓을 구매할 경우 값을 계산할 수 있다.")
        val fee4_1 = testScreening4.calculateFee(2)
        if (fee4_1 == Money.Companion.wons(12000).times(2.0)) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("============================ ")
        println("PolicyDiscountPolicy 예매 테스트")
        println("============================ ")
        val percentMovie = Movie("엘리멘탈",
                Duration.ofMillis(180),
                Money.Companion.wons(13000),
                PercentDiscountPolicy(0.1,
                        SequenceCondition(2),
                        PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                ), AmountRefundPolicy(TimeCondition(LocalDateTime.now())))
        val testScreening5 = Screening(percentMovie, 2, LocalDateTime.of(2023, 9, 14, 10, 10))
        val fee5 = testScreening5.calculateFee(1)
        println("테스트 : 할인 조건(순번,기간 조건)에 부합하면 비율 할인 가격 적용된다.")

        // then
        if (fee5 == percentMovie.fee.times(0.9)) {
            println("테스트 성공")
        } else println("테스트 실패")

        //given
        val testScreening6 = Screening(percentMovie, 2, LocalDateTime.of(2023, 9, 13, 14, 10))

        //when
        val fee6 = testScreening6.calculateFee(1)
        println("테스트 : 할인 조건(순번 조건)에 부합하면 비율 할인 가격 적용된다.")

        //then
        if (fee6 == Money.Companion.wons(13000).times(0.9)) {
            println("테스트 성공")
        } else println("테스트 실패")

        //given
        val testScreening7 = Screening(percentMovie, 4, LocalDateTime.of(2023, 9, 12, 10, 10))

        //when
        val fee7 = testScreening7.calculateFee(1)
        println("테스트 : 할인 조건(기간 조건)에 부합하면 비율 할인 가격 적용된다.")

        //then
        if (fee7 == Money.Companion.wons(13000).times(0.9)) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("테스트 : 할인 조건에 부합하지 않으면 비율 할인이 적용되지 않는다.")

        //given
        val testScreening8 = Screening(percentMovie, 4, LocalDateTime.of(2023, 9, 14, 15, 10))

        //when
        val fee8 = testScreening8.calculateFee(1)

        //then
        if (fee8 == Money.Companion.wons(13000)) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("============================ ")
        println("AmountRefundPolicy 예매 취소 테스트")
        println("============================ ")

        /*
        Movie AmountMovie = new Movie("오펜하이머",
                Duration.ofMillis(180),
                Money.wons(12000),
                new AmountDiscountPolicy(Money.wons(2000),
                        new SequenceCondition(1), new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)
                        )

                ),new AmountRefundPolicy(new TimeCondition(LocalDateTime.now()))
        );
        */


        //given
        val testScreening9 = Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 12, 10, 10))
        val reserveFee1 = testScreening9.calculateFee(1)

        //when
        val testRefund = Refund(testScreening9, AmountRefundPolicy(TimeCondition(LocalDateTime.now())), 1)
        val refundFee1 = testRefund.calculateRefundFee(1)
        println("테스트 : 환불 조건에 부합하지 않으면 환불되지 않는다.")
        //then
        if (refundFee1 == Money.Companion.wons(0)) {
            println("테스트 성공")
        } else println("테스트 실패")
        val testScreening10 = Screening(amountMovie, 2, LocalDateTime.of(2023, 9, 30, 10, 10))
        val reserveFee10 = testScreening9.calculateFee(1)

        //when
        val testRefund2 = Refund(testScreening10, AmountRefundPolicy(TimeCondition(LocalDateTime.now())), 1)
        val refundFee2 = testRefund2.calculateRefundFee(1)
        println("테스트 : 환불 조건에 부합하면, 전액 환불 된다.")


        //then
        if (refundFee2 == Money.Companion.wons(12000)) {
            println("테스트 성공")
        } else println("테스트 실패")
        println("============================ ")
    }
}
