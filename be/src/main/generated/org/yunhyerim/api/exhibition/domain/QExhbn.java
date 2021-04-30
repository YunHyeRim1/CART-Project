package org.yunhyerim.api.exhibition.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExhbn is a Querydsl query type for Exhbn
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExhbn extends EntityPathBase<Exhbn> {

    private static final long serialVersionUID = 1818385726L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExhbn exhbn = new QExhbn("exhbn");

    public final ListPath<org.yunhyerim.api.analysis.domain.Analysis, org.yunhyerim.api.analysis.domain.QAnalysis> analysisList = this.<org.yunhyerim.api.analysis.domain.Analysis, org.yunhyerim.api.analysis.domain.QAnalysis>createList("analysisList", org.yunhyerim.api.analysis.domain.Analysis.class, org.yunhyerim.api.analysis.domain.QAnalysis.class, PathInits.DIRECT2);

    public final ListPath<org.yunhyerim.api.booking.domain.Booking, org.yunhyerim.api.booking.domain.QBooking> bookingList = this.<org.yunhyerim.api.booking.domain.Booking, org.yunhyerim.api.booking.domain.QBooking>createList("bookingList", org.yunhyerim.api.booking.domain.Booking.class, org.yunhyerim.api.booking.domain.QBooking.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath exhbnArtist = createString("exhbnArtist");

    public final StringPath exhbnContent = createString("exhbnContent");

    public final StringPath exhbnGenre = createString("exhbnGenre");

    public final StringPath exhbnImage = createString("exhbnImage");

    public final NumberPath<Long> exhbnNum = createNumber("exhbnNum", Long.class);

    public final StringPath exhbnPrice = createString("exhbnPrice");

    public final StringPath exhbnTitle = createString("exhbnTitle");

    public final org.yunhyerim.api.hall.domain.QHall hall;

    public final ListPath<org.yunhyerim.api.review.domain.Review, org.yunhyerim.api.review.domain.QReview> reviewList = this.<org.yunhyerim.api.review.domain.Review, org.yunhyerim.api.review.domain.QReview>createList("reviewList", org.yunhyerim.api.review.domain.Review.class, org.yunhyerim.api.review.domain.QReview.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Float> totalScore = createNumber("totalScore", Float.class);

    public final ListPath<org.yunhyerim.api.wishilist.domain.Wishlist, org.yunhyerim.api.wishilist.domain.QWishlist> wishLists = this.<org.yunhyerim.api.wishilist.domain.Wishlist, org.yunhyerim.api.wishilist.domain.QWishlist>createList("wishLists", org.yunhyerim.api.wishilist.domain.Wishlist.class, org.yunhyerim.api.wishilist.domain.QWishlist.class, PathInits.DIRECT2);

    public QExhbn(String variable) {
        this(Exhbn.class, forVariable(variable), INITS);
    }

    public QExhbn(Path<? extends Exhbn> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExhbn(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExhbn(PathMetadata metadata, PathInits inits) {
        this(Exhbn.class, metadata, inits);
    }

    public QExhbn(Class<? extends Exhbn> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hall = inits.isInitialized("hall") ? new org.yunhyerim.api.hall.domain.QHall(forProperty("hall")) : null;
    }

}

