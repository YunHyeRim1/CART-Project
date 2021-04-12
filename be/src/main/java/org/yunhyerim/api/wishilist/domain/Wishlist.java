package org.yunhyerim.api.wishilist.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yunhyerim.api.exhibition.domain.Exhbn;
import org.yunhyerim.api.user.domain.UserVO;

import javax.persistence.*;

@NoArgsConstructor
@Entity @Getter @Table(name = "wishlist") @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wishlist {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_num") private long wishNum;

	@JsonBackReference(value = "user")
	@ManyToOne
	@JoinColumn(name = "user_num")
	private UserVO user;

	@JsonBackReference(value = "exhbn")
	@ManyToOne
	@JoinColumn(name = "exhbn_num")
	private Exhbn exhbn;

	@Builder
	public Wishlist(long wishNum, UserVO user, Exhbn exhbn) {
		this.wishNum = wishNum;
		this.exhbn = exhbn;
		this.user = user;
	}

	public void setWishNum(long wishNum) {
		this.wishNum = wishNum;
	}
}
/*
create table shows(
   show_num int primary key auto_increment,
   title varchar(30),
   period varchar(30),
   time varchar(20),
   venue varchar(20),
   admission varchar(20),
   price varchar(100),
   host varchar(20),
   management varchar(20),
   inquiry varchar(20)
   );
   poster_image varchar(100)*/