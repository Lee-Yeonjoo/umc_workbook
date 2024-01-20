package dev.umc.spring.service.StoreService;

import dev.umc.spring.domain.Review;
import dev.umc.spring.domain.Store;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
