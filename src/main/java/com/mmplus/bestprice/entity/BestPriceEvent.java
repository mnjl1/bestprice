package com.mmplus.bestprice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bestPriceEvent")
public class BestPriceEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bestPriceEventId", insertable=false, updatable=false, nullable=false)
    private Long bestPriceEventId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "best_price_event_start_date")
    private LocalDate bestPriceStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "best_price_event_end_date")
    private LocalDate bestPriceEndDate;
    
    @OneToMany(mappedBy="bestPriceEvent")
    private Set<HotPriceOrder> orders;

    public BestPriceEvent(){
    }
   
	public BestPriceEvent(Long bestPriceEventId, LocalDate bestPriceStartDate, LocalDate bestPriceEndDate) {
		super();
		this.bestPriceEventId = bestPriceEventId;
		this.bestPriceStartDate = bestPriceStartDate;
		this.bestPriceEndDate = bestPriceEndDate;
	}

	public BestPriceEvent(Long bestPriceEventId, LocalDate bestPriceStartDate, LocalDate bestPriceEndDate,
			Set<HotPriceOrder> orders) {
		super();
		this.bestPriceEventId = bestPriceEventId;
		this.bestPriceStartDate = bestPriceStartDate;
		this.bestPriceEndDate = bestPriceEndDate;
		this.orders = orders;
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

	public Set<HotPriceOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<HotPriceOrder> orders) {
		this.orders = orders;
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
}
