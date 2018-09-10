package com.mmplus.bestprice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "best_price_event")
public class BestPriceEvent implements Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "best_price_event_id")
    private Long bestPriceEventId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "best_price_event_start_date")
    private LocalDate bestPriceStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "best_price_event_end_date")
    private LocalDate bestPriceEndDate;

    public BestPriceEvent(){
    }

    public BestPriceEvent(Long bestPriceEventId, LocalDate bestPriceStartDate, LocalDate bestPriceEndDate) {
        this.bestPriceEventId = bestPriceEventId;
        this.bestPriceStartDate = bestPriceStartDate;
        this.bestPriceEndDate = bestPriceEndDate;
    }

    public Long getBestPriceEventId() {
        return bestPriceEventId;
    }

    public void setBestPriceEventId(Long bestPriceEventId) {
        this.bestPriceEventId = bestPriceEventId;
    }

    public LocalDate getBestPriceStartDate() {
        return bestPriceStartDate;
    }

    public void setBestPriceStartDate(LocalDate bestPriceStartDate) {
        this.bestPriceStartDate = bestPriceStartDate;
    }

    public LocalDate getBestPriceEndDate() {
        return bestPriceEndDate;
    }

    public void setBestPriceEndDate(LocalDate bestPriceEndDate) {
        this.bestPriceEndDate = bestPriceEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BestPriceEvent)) return false;
        BestPriceEvent that = (BestPriceEvent) o;
        return Objects.equals(bestPriceEventId, that.bestPriceEventId) &&
                Objects.equals(bestPriceStartDate, that.bestPriceStartDate) &&
                Objects.equals(bestPriceEndDate, that.bestPriceEndDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bestPriceEventId, bestPriceStartDate, bestPriceEndDate);
    }

    @Override
    public String toString() {
        return "BestPriceEvent{" +
                "bestPriceEventId=" + bestPriceEventId +
                ", bestPriceStartDate=" + bestPriceStartDate +
                ", bestPriceEndDate=" + bestPriceEndDate +
                '}';
    }

    @Override
    public void promoPrice() {
        System.out.println("This type of promo is free.");
    }
}
