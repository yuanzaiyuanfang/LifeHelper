package com.yzyfdf.lifehelper.bean.cookbean;

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

        private List<CookRBean> recipes;

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

        public List<CookRBean> getRecipes() {
            return recipes;
        }

        public void setRecipes(List<CookRBean> recipes) {
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


    }
}
