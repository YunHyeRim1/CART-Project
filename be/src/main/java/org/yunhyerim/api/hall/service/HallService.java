package org.yunhyerim.api.hall.service;

import java.util.List;

import org.yunhyerim.api.hall.domain.Hall;

public interface HallService {
	public Hall findByHallNum(long hallNum);
	public long update(String hallName, String hallLocation, String hallTime, String hallClosed,
					   String hallPnumber, String hallInfo, String Image, long hallNum);
}
