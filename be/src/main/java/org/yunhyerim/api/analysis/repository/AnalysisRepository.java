package org.yunhyerim.api.analysis.repository;

import org.yunhyerim.api.analysis.domain.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

interface AnalysisCustomRepository{
	
}

public interface AnalysisRepository extends JpaRepository<Analysis, Long>, AnalysisCustomRepository {

}
