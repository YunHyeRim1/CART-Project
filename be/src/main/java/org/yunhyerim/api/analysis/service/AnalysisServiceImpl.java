package org.yunhyerim.api.analysis.service;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.yunhyerim.api.analysis.domain.Analysis;
import org.yunhyerim.api.analysis.repository.AnalysisRepository;
import org.yunhyerim.api.common.service.AbstractService;


@Service @RequiredArgsConstructor
public class AnalysisServiceImpl extends AbstractService<Analysis> implements AnalysisService{
	private final AnalysisRepository repo;

	@Override public long save(Analysis h) { return (repo.save(h) != null) ? 1 : 0;}
	@Override public long delete(Analysis h) { repo.delete(h); return (getOne(h.getAnalNum()) == null) ? 1 : 0;}
	@Override public long count() { return (long)repo.count();}
	@Override public List<Analysis> findAll() { return repo.findAll();}
	@Override public Analysis getOne(long id) { return repo.getOne(id);}
	@Override public Optional<Analysis> findById(long id){ return repo.findById(id);}
	@Override public boolean existsById(long id) { return repo.existsById(id);}
}