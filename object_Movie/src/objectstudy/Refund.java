package objectstudy;

import objectstudy.policy.refund.RefundPolicy;

import java.time.LocalDateTime;

/**
 * refund - 환불과 관련된 정보를 가지고 있음
 */
public class Refund {

    private Screening screening;
    private int audienceCount;

    public Refund(Screening screening,int audienceCount) {
        this.screening = screening;
        this.audienceCount = audienceCount;
    }


    public Money getMovieFee(){
        return screening.getMovieFee();
    }

    public LocalDateTime getMovieStartTime() {
        return screening.getStartTime();
    }

    public Money calculateRefundFee(int audienceCount){
        return screening.refundCalculator(this).times(audienceCount);
    }

    @Override
    public String toString() {
        return "Refund{" +
                "screening=" + screening +
                ", audienceCount=" + audienceCount +
                '}';
    }
}
