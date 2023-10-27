package objectstudy;

import java.time.LocalDateTime;

/**
 * 예매의 역할 : ?
 *      책임 : ?
 */
public class Reservation {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Refund refund() {
        return new Refund(this);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public Money getFee() {
        return fee;
    }

    public LocalDateTime getScreeningTime() {
        return screening.getStartTime();
    }

    public Money calculateRefundFee() {
        return screening.getMovie().calculateRefundFee(this);
    }





    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", screening=" + screening +
                ", fee=" + fee +
                ", audienceCount=" + audienceCount +
                '}';
    }
}
