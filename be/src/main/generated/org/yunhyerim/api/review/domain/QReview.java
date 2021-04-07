package org.yunhyerim.api.review.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 974072996L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final org.yunhyerim.api.exhibition.domain.QExhbn exhbn;

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public final StringPath reviewContent = createString("reviewContent");

    public final NumberPath<Long> reviewNum = createNumber("reviewNum", Long.class);

    public final StringPath reviewTitle = createString("reviewTitle");

    public final StringPath score = createString("score");

    public final org.yunhyerim.api.user.domain.QUserVO user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exhbn = inits.isInitialized("exhbn") ? new org.yunhyerim.api.exhibition.domain.QExhbn(forProperty("exhbn"), inits.get("exhbn")) : null;
        this.user = inits.isInitialized("user") ? new org.yunhyerim.api.user.domain.QUserVO(forProperty("user")) : null;
    }

}

