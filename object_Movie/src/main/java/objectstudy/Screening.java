package objectstudy;

import java.time.LocalDateTime;


/**
 * obectstudy.Screening 역할 : 사용자들이 예매하는 대상
 * obectstudy.Screening 책임 : 1. 예매
 *                            2. 환불
 */
public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;


    public Movie getMovie() {
        return movie;
    }

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

    public Money getMovieFee(){
        return movie.getFee();
    }



    public Money calculateFee(int audienceCount){

        return movie.calculateMovieFee(this).times(audienceCount);
    }


    @Override
    public String toString() {
        return "Screening{" +
                "movie=" + movie +
                ", sequence=" + sequence +
                ", whenScreened=" + whenScreened +
                '}';
    }
}
