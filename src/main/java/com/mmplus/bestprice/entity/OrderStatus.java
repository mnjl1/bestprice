package com.mmplus.bestprice.entity;

import com.mmplus.bestprice.util.Constants;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OrderStatus {

	ORDER_STATUS_UNDER_CONSIDERATION(1) {
		public String toString() {
			return Constants.UA_ORDER_UNDER_CONSIDERATION;
		}
	},

	ORDER_STATUS_ACCEPTED(2) {
		public String toString() {
			return Constants.UA_ORDER_STATUS_ACCEPTED;
		}
	},

	ORDER_STATUS_DECLINED(3) {
		public String toString() {
			return Constants.UA_ORDER_STATUS_DECLINED;
		}
	};

	private int orderStatusValue;
	private static final Map<Integer, OrderStatus> map = Arrays.stream(OrderStatus.values())
			.collect(Collectors.toMap(status->status.orderStatusValue, status->status));

	OrderStatus(int orderStatusValue) {
		this.orderStatusValue = orderStatusValue;
	}

	public int getOrderStatusValue() {
		return orderStatusValue;
	}

	public static OrderStatus valueOf(int i){
		return map.get(i);
	}
}
