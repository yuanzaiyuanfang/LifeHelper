package com.yzyfdf.lifehelper.bean.live;

/**
 * Created by MLRC-iOS-CI on 2018/1/10.
 */

public class CounterBean {
    /**
     * comment : 0
     * like : 1
     * favorite : 0
     * share : 0
     * read : 0
     * goods : 0
     */

    private int comment;
    private int like;
    private int favorite;
    private int share;
    private int read;
    private int goods;

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }
}
