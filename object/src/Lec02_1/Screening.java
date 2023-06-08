package Lec02_1;

import Lec02.Customer;
import Lec02.Money;
import Lec02.Movie;
import Lec02.Reservation;

import java.time.LocalDateTime;

public class Screening {
    private Lec02.Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime(){
        return whenScreened;
    }

    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public Lec02.Money getMovieFee(){
        return movie.getFee();
    }

    public Lec02.Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
