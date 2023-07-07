public class ReservationAgency {

    public Reservation reserve(Sreening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;

        for(DiscountCondition condition : movie.getDiscountConditions()){
            if(condition.getType() == DiscpuntConditionType.PERIOD){
                discountable = screenin.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())&&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTiem())<=0 &&
                        condition.getEndTime().comparTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequnece();
            }

            if(discountable){
                break;
            }
        }

        Money fee;

        if(discountable){
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()){
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = MONEY.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee().times(audienceCount);
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}