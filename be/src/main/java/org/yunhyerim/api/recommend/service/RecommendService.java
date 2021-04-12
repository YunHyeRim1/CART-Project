package org.yunhyerim.api.recommend.service;

import org.yunhyerim.api.exhibition.domain.ExhbnHallDTO;

import java.util.List;

public interface RecommendService {
    public List<ExhbnHallDTO> listByGenre(long userNum);
    public List<ExhbnHallDTO> listByMedia();
}
