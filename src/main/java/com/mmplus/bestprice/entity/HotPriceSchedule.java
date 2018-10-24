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
@Table(name = "hotPriceSchedule")
public class HotPriceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotPriceScheduleId", nullable=false)
    private Long hotPriceScheduleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hotPriceStartDate")
    private LocalDate hotPriceStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hotPriceEndDate")
    private LocalDate hotPriceEndDate;
    
    @OneToMany(mappedBy="hotPriceSchedule")
    private Set<HotPriceOrder> orders;

    public HotPriceSchedule(){
    }
   
	public HotPriceSchedule(Long HotPriceScheduleId, LocalDate hotPriceStartDate, LocalDate hotPriceEndDate) {
		super();
		this.hotPriceScheduleId = HotPriceScheduleId;
		this.hotPriceStartDate = hotPriceStartDate;
		this.hotPriceEndDate = hotPriceEndDate;
	}

	public HotPriceSchedule(Long hotPriceScheduleId, LocalDate hotPriceStartDate, LocalDate hotPriceEndDate,
                            Set<HotPriceOrder> orders) {
		super();
		this.hotPriceScheduleId = hotPriceScheduleId;
		this.hotPriceStartDate = hotPriceStartDate;
		this.hotPriceEndDate = hotPriceEndDate;
		this.orders = orders;
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
		return orders;
	}

	public void setOrders(Set<HotPriceOrder> orders) {
		this.orders = orders;
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
        return "HotPriceSchedule{" +
                "hotPriceScheduleId=" + hotPriceScheduleId +
                ", hotPriceStartDate=" + hotPriceStartDate +
                ", hotPriceEndDate=" + hotPriceEndDate +
                '}';
    }
}
