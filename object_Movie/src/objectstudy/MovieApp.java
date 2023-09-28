package objectstudy;

import objectstudy.initializer.MovieInit;
import objectstudy.initializer.ScreeningInit;
import objectstudy.repository.CustomerRepository;
import objectstudy.repository.MovieRepository;
import objectstudy.repository.ReservationRepository;
import objectstudy.repository.ScreeningRepository;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;

public class MovieApp {

    private MovieRepository movieRepository = new MovieRepository();
    private ScreeningRepository screeningRepository = new ScreeningRepository();
    private CustomerRepository customerRepository = new CustomerRepository();
    private ReservationRepository reservationRepository = new ReservationRepository();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean inputMismatch = false;
        while (true) {
            System.out.println("=====================================");
            System.out.println("1. 예매 가능 영화 보기 2. 예매하기 3. 환불 하기 0. 종료");
            System.out.println("=====================================");

            if (inputMismatch) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                scanner.nextLine(); // 버퍼를 비워줌
                inputMismatch = false;
            }

            try {
                select = scanner.nextInt();
                switch (select) {
                    case 1 -> {
                        LinkedHashMap<Long, Screening> screenInfos = screeningRepository.findAll();
                        for ( Screening screenInfo : screenInfos.values()) {
                            System.out.println(screenInfo);
                        }

                    }
                    case 2 -> {
                        System.out.println("예매자 이름 입력 해주세요!" );
                        String customerName = scanner.next();
                        Customer customer = new Customer(customerName);
                        customerRepository.save(customer);

                        System.out.println("예매 인원을 입력해주세요!");
                        int audienceCount = scanner.nextInt();
                        ReservationAgency reservationAgency = new ReservationAgency();

                        System.out.println("예매하실 영화제목을 입력해주세요");

                        String movieName = scanner.next();

                        System.out.println("예매하실 영화의 순번을 입력해주세요");

                        int sequence = scanner.nextInt();
                        Screening findScreening = screeningRepository.findByMovieNameAndSequence(movieName, sequence);

                        Reservation reserve = reservationAgency.reserve(findScreening, customer, audienceCount);

                        reservationRepository.save(reserve);
                        System.out.println("예매결과 출력");
                        System.out.println(reserve);
                    }
                    case 3 ->{
                        System.out.println("예매자 이름을 입력해주세요!");
                        String customerName = scanner.next();

                        Reservation refundReservation = reservationRepository.findByCustomer(customerName);

                        System.out.println("환불 인원을 입력해주세요!");
                        int audienceCount = scanner.nextInt();

                        Refund refund = refundReservation.refund(refundReservation.getScreening(), audienceCount);

                        reservationRepository.delete(refundReservation);

                        System.out.println(refund);


                    }

                    case 0 -> {
                        System.out.println("프로그램 종료");
                        return;
                    }
                    default -> {
                        System.out.println("다시 선택해주세요.");
                    }
                }
            } catch (InputMismatchException e) {
                inputMismatch = true;
            }
        }
    }

    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();
        LinkedHashMap<Long, Movie> movieData = MovieInit.createMovieData(movieApp.movieRepository);

        ScreeningInit.createScreeningData(movieApp.screeningRepository, movieData);



        movieApp.showMenu();
    }
}
