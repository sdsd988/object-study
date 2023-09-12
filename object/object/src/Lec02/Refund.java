package Lec02;

/**
 * refund - 환불과 관련된 정보를 가지고 있음
 */
public class Refund {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Refund(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
