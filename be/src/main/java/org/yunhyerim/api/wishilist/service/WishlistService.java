package org.yunhyerim.api.wishilist.service;

import org.yunhyerim.api.wishilist.domain.WishDTO;
import org.yunhyerim.api.wishilist.domain.Wishlist;
import org.yunhyerim.api.wishilist.domain.WishlistDTO;

import java.util.List;

public interface WishlistService {
    public long delete(long userNum, long exhbnNum);
    public List<Wishlist> findAll();
    public Wishlist getOne(long id);
    public long add(WishlistDTO w);
    public List<WishDTO> findWishlist();
    public List<Exhbn> findByUser(long id);
}
