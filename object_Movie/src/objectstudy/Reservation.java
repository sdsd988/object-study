package objectstudy;

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

    public Refund refund(Screening screening, int audienceCount) {

        return new Refund(screening, audienceCount);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public Screening getScreening() {
        return screening;
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
