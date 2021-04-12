package org.yunhyerim.api.hall.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.yunhyerim.api.hall.domain.HallDTO;
import org.springframework.stereotype.Service;

import org.yunhyerim.api.common.service.AbstractService;
import org.yunhyerim.api.hall.domain.Hall;
import org.yunhyerim.api.hall.repository.HallRepository;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class HallServiceImpl implements HallService {
	final HallRepository hallRepository;
	
	@Override 
	public long save(Hall hall) {
		return (hallRepository.save(hall) != null) ? 1 : 0;
	}
	@Override 
	public long delete(long id) {
		hallRepository.deleteById(id);
		return(getOne(id) == null) ? 1 : 0;
	}
	@Override 
	public long count() {
		return hallRepository.count();
	}
	@Override 
    public Hall getOne(long id) {
    	return hallRepository.getOne(id);
    }
	@Override 
    public Optional<Hall> findById(long id) {
    	return hallRepository.findById(id);
	}
    @Override 
    public boolean existsById(long id) {
    	return hallRepository.existsById(id);
    }
    @Override
	public List<Hall> findAll() { return hallRepository.findAll();}
    @Override
    public List<HallDTO> findAllHall() {
		return hallRepository.findAll().stream().map(i -> new HallDTO(i)).collect(Collectors.toList());
    }
	@Override public long update(String hallName, String hallLocation, String hallTime, String hallClosed,
								 String hallPnumber, String hallInfo, String hallImage, long hallNum) {
		return hallRepository.update(hallName, hallLocation, hallTime, hallClosed, hallPnumber,
				hallInfo, hallImage, hallNum);}
}
