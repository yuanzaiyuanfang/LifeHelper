package com.yzyfdf.lifehelper.bean.cookbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookListBean extends BaseCookBean {


    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private int         end;
        /**
         * id : 5547028
         * title : 高分易做千人评测，照着做不出错
         * description : 做饭最怕选错菜谱，这些高分菜谱经过众多豆友实践，一定没错
         * user_id : 9820796
         * create_time : 2017-05-03 16:42:37
         * c : 98
         * cs : 0
         * thumb_url : http://cp2.douguo.net/upload/caiku/8/c/1/300_8cd14016e86e1c87c2bfe830c6d9cf51.jpeg
         * cover_url : http://cp2.douguo.net/upload/caiku/8/c/1/600_8cd14016e86e1c87c2bfe830c6d9cf51.jpeg
         * author : {"user_id":"9820796","nick":"请叫我小花儿","nickname":"请叫我小花儿","user_photo":"http://tx2.douguo.net/upload/photo/1/b/3/70_u34015596630824100203.jpg","avatar_medium":"http://tx2.douguo.net/upload/photo/1/b/3/140_u34015596630824100203.jpg","gender":2,"user_large_photo":"http://tx2.douguo.net/upload/photo/1/b/3/yuan_u34015596630824100203.jpg","verified":0}
         * as : 2
         */

        private MenuBean          menu;
        /**
         * id : 1476612
         * cookstory : 鸡丝杏鲍菇属于我的拿手家常菜之一，其实最秘密的武器就是放了丘比沙拉汁香辣口味，不是参加活动一般人我还不告诉他呢
         * n : 鸡丝杏鲍菇
         * img : http://i1.douguo.net/upload/caiku/8/c/1/300_8cd14016e86e1c87c2bfe830c6d9cf51.jpeg
         * stc : 7
         * sti : 1
         * dc : 0
         * fc : 365
         * an : *star丶时光
         * ecs : 0
         * hq : 0
         * a : {"id":"10184108","n":"*star丶时光","v":1,"p":"http://tx2.douguo.net/upload/photo/a/1/1/70_u35928460932704100453.jpg"}
         * p : http://cp1.douguo.net/upload/caiku/8/c/1/600_8cd14016e86e1c87c2bfe830c6d9cf51.jpeg
         * cookstep : [{"position":"1","content":"鸡胸肉和杏鲍菇煮熟用手撕成丝，大葱和红辣椒切丝","thumb":"http://cp1.douguo.net/upload/caiku/1/e/f/140_1eab3352e2cc05e049fc4212342a7f9f.jpeg","image":"http://cp1.douguo.net/upload/caiku/1/e/f/600_1eab3352e2cc05e049fc4212342a7f9f.jpeg"},{"position":"2","content":"锅里放油加入杏鲍菇丝煸炒一分钟","thumb":"http://cp1.douguo.net/upload/caiku/e/5/f/140_e5c783cc4b3010c6ec470c62527752df.jpeg","image":"http://cp1.douguo.net/upload/caiku/e/5/f/600_e5c783cc4b3010c6ec470c62527752df.jpeg"},{"position":"3","content":"加入葱丝辣椒丝翻炒均匀","thumb":"http://cp1.douguo.net/upload/caiku/5/0/9/140_506cf84f18a3e840d31abe752b82b2c9.jpeg","image":"http://cp1.douguo.net/upload/caiku/5/0/9/600_506cf84f18a3e840d31abe752b82b2c9.jpeg"},{"position":"4","content":"加入鸡丝","thumb":"http://cp1.douguo.net/upload/caiku/9/a/8/140_9a0f1f93653d993365569886d3ba6228.jpeg","image":"http://cp1.douguo.net/upload/caiku/9/a/8/600_9a0f1f93653d993365569886d3ba6228.jpeg"},{"position":"5","content":"神器就是图中的香辣口味丘比沙拉汁","thumb":"http://cp1.douguo.net/upload/caiku/a/1/f/140_a104e315cf0bdf1c58374459de21733f.jpeg","image":"http://cp1.douguo.net/upload/caiku/a/1/f/600_a104e315cf0bdf1c58374459de21733f.jpeg"},{"position":"6","content":"倒入适量丘比沙拉汁翻炒均匀即可出锅","thumb":"http://cp1.douguo.net/upload/caiku/9/7/a/140_97c5177d6904dc3b86ce76f25914defa.jpeg","image":"http://cp1.douguo.net/upload/caiku/9/7/a/600_97c5177d6904dc3b86ce76f25914defa.jpeg"},{"position":"7","content":"依照自己口味添加丘比沙拉汁，我们能吃辣的就多加了些，盐就不需要放了。不食辣者依口味适当加盐或者酱油。","thumb":"http://cp1.douguo.net/upload/caiku/8/0/1/140_80ff0a438439563d929e199bc68de401.jpeg","image":"http://cp1.douguo.net/upload/caiku/8/0/1/600_80ff0a438439563d929e199bc68de401.jpeg"}]
         * major : [{"title":"杏鲍菇","note":"1根"},{"title":"鸡胸肉","note":"100克"},{"title":"红辣椒","note":"1个"},{"title":"丘比沙拉汁香辣口味","note":"适量"},{"title":"葱丝","note":"少许"}]
         * minor : []
         * cook_difficulty : 切墩(初级)
         * cook_time : 10~30分钟
         * tags : []
         * vc : 6010
         */

        private List<RBean> recipes;

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public MenuBean getMenu() {
            return menu;
        }

        public void setMenu(MenuBean menu) {
            this.menu = menu;
        }

        public List<RBean> getRecipes() {
            return recipes;
        }

        public void setRecipes(List<RBean> recipes) {
            this.recipes = recipes;
        }

        public static class MenuBean {
            private String     id;
            private String     title;
            private String     description;
            private String     user_id;
            private String     create_time;
            private int        c;
            private int        cs;
            private String     thumb_url;
            private String     cover_url;
            /**
             * user_id : 9820796
             * nick : 请叫我小花儿
             * nickname : 请叫我小花儿
             * user_photo : http://tx2.douguo.net/upload/photo/1/b/3/70_u34015596630824100203.jpg
             * avatar_medium : http://tx2.douguo.net/upload/photo/1/b/3/140_u34015596630824100203.jpg
             * gender : 2
             * user_large_photo : http://tx2.douguo.net/upload/photo/1/b/3/yuan_u34015596630824100203.jpg
             * verified : 0
             */

            private AuthorBean author;
            private int        as;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getC() {
                return c;
            }

            public void setC(int c) {
                this.c = c;
            }

            public int getCs() {
                return cs;
            }

            public void setCs(int cs) {
                this.cs = cs;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public String getCover_url() {
                return cover_url;
            }

            public void setCover_url(String cover_url) {
                this.cover_url = cover_url;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public int getAs() {
                return as;
            }

            public void setAs(int as) {
                this.as = as;
            }

            public static class AuthorBean {
                private String user_id;
                private String nick;
                private String nickname;
                private String user_photo;
                private String avatar_medium;
                private int    gender;
                private String user_large_photo;
                private int    verified;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getUser_photo() {
                    return user_photo;
                }

                public void setUser_photo(String user_photo) {
                    this.user_photo = user_photo;
                }

                public String getAvatar_medium() {
                    return avatar_medium;
                }

                public void setAvatar_medium(String avatar_medium) {
                    this.avatar_medium = avatar_medium;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public String getUser_large_photo() {
                    return user_large_photo;
                }

                public void setUser_large_photo(String user_large_photo) {
                    this.user_large_photo = user_large_photo;
                }

                public int getVerified() {
                    return verified;
                }

                public void setVerified(int verified) {
                    this.verified = verified;
                }
            }
        }

        public static class RBean implements Serializable{
            private int                id;
            private String             cookstory;
            private String             n;
            private String             img;
            private int                stc;
            private int                sti;
            private int                dc;
            private int                fc;
            private String             an;
            private int                ecs;
            private int                hq;
            /**
             * id : 8942164
             * n : 吃好吃的喽aici君
             * v : 1
             * p : http://tx2.douguo.net/upload/photo/8/4/9/70_u2890298993436213816.jpg
             */

            private ABean              a;
            private String             p;
            private String             cook_difficulty;
            private String             cook_time;
            private int                vc;
            /**
             * position : 1
             * content : 准备好牛肉馅，生姜去皮切丝，大葱切圈，青椒切小丁。
             * thumb : http://cp1.douguo.net/upload/caiku/7/d/d/140_7d86d3b7418aeac3c57fa91c7bc79ced.jpg
             * image : http://cp1.douguo.net/upload/caiku/7/d/d/600_7d86d3b7418aeac3c57fa91c7bc79ced.jpg
             */

            private List<CookstepBean> cookstep;
            /**
             * title : 牛肉馅
             * note : 50g
             */

            private List<MajorBean>    major;
            /**
             * title : 大葱
             * note : 半根
             */

            private List<MinorBean>    minor;
            private List<?>            tags;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCookstory() {
                return cookstory;
            }

            public void setCookstory(String cookstory) {
                this.cookstory = cookstory;
            }

            public String getN() {
                return n;
            }

            public void setN(String n) {
                this.n = n;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getStc() {
                return stc;
            }

            public void setStc(int stc) {
                this.stc = stc;
            }

            public int getSti() {
                return sti;
            }

            public void setSti(int sti) {
                this.sti = sti;
            }

            public int getDc() {
                return dc;
            }

            public void setDc(int dc) {
                this.dc = dc;
            }

            public int getFc() {
                return fc;
            }

            public void setFc(int fc) {
                this.fc = fc;
            }

            public String getAn() {
                return an;
            }

            public void setAn(String an) {
                this.an = an;
            }

            public int getEcs() {
                return ecs;
            }

            public void setEcs(int ecs) {
                this.ecs = ecs;
            }

            public int getHq() {
                return hq;
            }

            public void setHq(int hq) {
                this.hq = hq;
            }

            public ABean getA() {
                return a;
            }

            public void setA(ABean a) {
                this.a = a;
            }

            public String getP() {
                return p;
            }

            public void setP(String p) {
                this.p = p;
            }

            public String getCook_difficulty() {
                return cook_difficulty;
            }

            public void setCook_difficulty(String cook_difficulty) {
                this.cook_difficulty = cook_difficulty;
            }

            public String getCook_time() {
                return cook_time;
            }

            public void setCook_time(String cook_time) {
                this.cook_time = cook_time;
            }

            public int getVc() {
                return vc;
            }

            public void setVc(int vc) {
                this.vc = vc;
            }

            public List<CookstepBean> getCookstep() {
                return cookstep;
            }

            public void setCookstep(List<CookstepBean> cookstep) {
                this.cookstep = cookstep;
            }

            public List<MajorBean> getMajor() {
                return major;
            }

            public void setMajor(List<MajorBean> major) {
                this.major = major;
            }

            public List<MinorBean> getMinor() {
                return minor;
            }

            public void setMinor(List<MinorBean> minor) {
                this.minor = minor;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

            public static class ABean implements Serializable{
                private String id;
                private String n;
                private int    v;
                private String p;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public int getV() {
                    return v;
                }

                public void setV(int v) {
                    this.v = v;
                }

                public String getP() {
                    return p;
                }

                public void setP(String p) {
                    this.p = p;
                }
            }

            public static class CookstepBean implements Serializable{
                private String position;
                private String content;
                private String thumb;
                private String image;

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }

            public static class MajorBean implements Serializable{
                private String title;
                private String note;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }
            }

            public static class MinorBean implements Serializable {
                private String title;
                private String note;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }
            }
        }
    }
}
