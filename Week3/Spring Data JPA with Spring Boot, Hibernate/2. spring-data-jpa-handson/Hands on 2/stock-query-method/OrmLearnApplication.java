package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testFacebookSeptember2019();
        testGoogleAbove1250();
        testTop3HighestVolumes();
        testThreeLowestNetflix();
    }

    private void testFacebookSeptember2019() {
        LocalDate start = LocalDate.of(2019, 9, 1);
        LocalDate end   = LocalDate.of(2019, 9, 30);
        List<Stock> fbSept = stockRepository.findByStCodeAndStDateBetween("FB", start, end);
        System.out.println("FB Sept 2019:");
        fbSept.forEach(System.out::println);
    }

    private void testGoogleAbove1250() {
        List<Stock> googl = stockRepository.findByStCodeAndStCloseGreaterThan(
            "GOOGL",
            new BigDecimal("1250")
        );
        System.out.println("GOOGL where close > 1250:");
        googl.forEach(System.out::println);
    }

    private void testTop3HighestVolumes() {
        List<Stock> top3Vol = stockRepository.findTop3ByOrderByStVolumeDesc();
        System.out.println("Top 3 by volume:");
        top3Vol.forEach(System.out::println);
    }

    private void testThreeLowestNetflix() {
        List<Stock> nflxLow = stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX");
        System.out.println("Three lowest NFLX closes:");
        nflxLow.forEach(System.out::println);
    }
}
