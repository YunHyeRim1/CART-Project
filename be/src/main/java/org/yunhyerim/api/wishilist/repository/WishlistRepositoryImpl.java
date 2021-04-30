package org.yunhyerim.api.wishilist.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.yunhyerim.api.exhibition.domain.Exhbn;
import org.yunhyerim.api.wishilist.domain.WishDTO;
import org.yunhyerim.api.wishilist.domain.Wishlist;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.yunhyerim.api.wishilist.domain.QWishlist.wishlist;

@Repository
public class WishlistRepositoryImpl extends QuerydslRepositorySupport implements WishlistCustomRepository {
	private final JPAQueryFactory qf;
	public WishlistRepositoryImpl(JPAQueryFactory qf) {
		super(Wishlist.class);
		this.qf = qf;
	}

	@Override
	public List<WishDTO> findWishlist(){
		return qf.select(Projections.bean(WishDTO.class,
				wishlist.wishNum, wishlist.exhbn.exhbnNum, wishlist.user.userNum))
				.from(wishlist).fetch();
	}

	@Override
	public List<WishDTO> findAlllist(){
		return qf.select(Projections.bean(WishDTO.class,
				wishlist.wishNum, wishlist.exhbn, wishlist.user))
				.from(wishlist).fetch();
	}

	@Override
	public void deleteWish(long userNum, long exhbnNum){
		qf.delete(wishlist).where(wishlist.user.userNum.eq(userNum), wishlist.exhbn.exhbnNum.eq(exhbnNum));
	}

	@Override
	public List<Exhbn> findByUser(long id){
		return qf.select(wishlist.exhbn)
				.from(wishlist).where(wishlist.user.userNum.eq(id)).fetch();
	}

}
