package org.yunhyerim.api.analysis.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import org.yunhyerim.api.analysis.domain.Analysis;

@Repository
public class AnalysisRepositoryImpl extends QuerydslRepositorySupport implements AnalysisCustomRepository{
	//private final JPAQueryFactory qf;
	public AnalysisRepositoryImpl() {
		super(Analysis.class);
		//this.qf = qf;
	}
}
