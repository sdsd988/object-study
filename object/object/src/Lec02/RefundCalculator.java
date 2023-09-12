package Lec02;

import Lec02.policy.refund.RefundPolicy;

/**
 * refundCalculate 특 : 환불과 관련된 정보를 갖고 있음
 *                 책임 : 환불 금액 계산
 */
public class RefundCalculator {

    private RefundPolicy refundPolicy;
    private Money fee;

    public Money getFee() {
        return fee;
    }

    public RefundCalculator(RefundPolicy refundPolicy) {
        this.refundPolicy = refundPolicy;
    }


    public Money calculateRefundFee(Screening screening) {
        return refundPolicy.calculateRefundAmount(screening);
    }


}

