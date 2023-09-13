package Lec02;



import java.time.LocalDateTime;


/**
 * Screening 역할 : 사용자들이 예매하는 대상
 * Screening 책임 : 1. 예매
 *                 2. 환불
 *
 */
public class Screening {

    private Movie movie;
    private RefundCalculator refundCalculate;
    private int sequence;
    private LocalDateTime whenScreened;

    public Movie getMovie() {
        return movie;
    }

    public Screening(Movie movie, RefundCalculator refundCalculate, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.refundCalculate = refundCalculate;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime(){
        return whenScreened;
    }

    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public Money getMovieFee(){
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount){

        return movie.calculateMovieFee(this).times(audienceCount);
    }


    public Refund refund(Customer customer, int audienceCount){
        return new Refund(customer, this,calculateRefundFee(audienceCount),audienceCount);
    }

    private Money calculateRefundFee(int audienceCount){
        return refundCalculate.calculateRefundFee(this).times(audienceCount);

    }
}
