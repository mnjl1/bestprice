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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hotPriceSchedule")
public class HotPriceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="hotPriceScheduleId", nullable=false, insertable=false, updatable=false)
    private Long hotPriceScheduleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hot_price__start_date")
    private LocalDate hotPriceStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hot_price_end_date")
    private LocalDate hotPriceEndDate;
    
    @OneToMany(mappedBy="hotPriceSchedule")
    private Set<HotPriceOrder> hotPriceOrders;

    public HotPriceSchedule(){
    }
   
	public HotPriceSchedule(Long hotPriceScheduleId, LocalDate hotPriceStartDate, LocalDate hotPriceEndDate) {
		super();
		this.hotPriceScheduleId = hotPriceScheduleId;
		this.hotPriceStartDate = hotPriceStartDate;
		this.hotPriceEndDate = hotPriceEndDate;
	}

	public HotPriceSchedule(Long hotPriceScheduleId, LocalDate hotPriceStartDate, LocalDate hotPriceEndDate,
			Set<HotPriceOrder> hotPriceOrders) {
		super();
		this.hotPriceScheduleId = hotPriceScheduleId;
		this.hotPriceStartDate = hotPriceStartDate;
		this.hotPriceEndDate = hotPriceEndDate;
		this.hotPriceOrders = hotPriceOrders;
	}

	public Long getHotPriceScheduleId() {
		return hotPriceScheduleId;
	}

	public void setHotPriceScheduleId(Long hotPriceScheduleId) {
		this.hotPriceScheduleId = hotPriceScheduleId;
	}

	public LocalDate getHotPriceStartDate() {
        return hotPriceStartDate;
    }

    public void setHotPriceStartDate(LocalDate hotPriceStartDate) {
        this.hotPriceStartDate = hotPriceStartDate;
    }

    public LocalDate getHotPriceEndDate() {
        return hotPriceEndDate;
    }

    public void setHotPriceEndDate(LocalDate hotPriceEndDate) {
        this.hotPriceEndDate = hotPriceEndDate;
    }

	public Set<HotPriceOrder> getOrders() {
		return hotPriceOrders;
	}

	public Set<HotPriceOrder> getHotPriceOrders() {
		return hotPriceOrders;
	}

	public void setHotPriceOrders(Set<HotPriceOrder> hotPriceOrders) {
		this.hotPriceOrders = hotPriceOrders;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotPriceSchedule)) return false;
        HotPriceSchedule that = (HotPriceSchedule) o;
        return Objects.equals(hotPriceScheduleId, that.hotPriceScheduleId) &&
                Objects.equals(hotPriceStartDate, that.hotPriceStartDate) &&
                Objects.equals(hotPriceEndDate, that.hotPriceEndDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hotPriceScheduleId, hotPriceStartDate, hotPriceEndDate);
    }

	@Override
	public String toString() {
		return "HotPriceSchedule [hotPriceScheduleId=" + hotPriceScheduleId + ", hotPriceStartDate=" + hotPriceStartDate
				+ ", hotPriceEndDate=" + hotPriceEndDate + ", hotPriceOrders=" + hotPriceOrders + "]";
	}
}
