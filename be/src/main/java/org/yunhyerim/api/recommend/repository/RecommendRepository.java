package org.yunhyerim.api.recommend.repository;

import org.yunhyerim.api.recommend.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

interface RecommendCustomRepository{
	
}
public interface RecommendRepository extends JpaRepository<Recommend, Long>, RecommendCustomRepository {

}
