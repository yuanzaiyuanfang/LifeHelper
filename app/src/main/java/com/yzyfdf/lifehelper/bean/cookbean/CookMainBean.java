package com.yzyfdf.lifehelper.bean.cookbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookMainBean extends BaseCookBean{



    private ResultBean result;


    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String         tid;
        private HeaderBean     header;
        private String         murl;
        private int            ed;
        private String         btmid;
        private String         flt;
        private int            nic;
        private String         slt;
        /**
         * r : {"id":1544952,"cookstory":"哎，莫名其妙的感冒了，都不知道是什么原因引起的，真是难受/(ㄒoㄒ)/~~难受的时候就是想吃点儿暖心暖胃的食物，自己包了点儿饺子，希望把病毒快快赶走！","n":"青椒牛肉水饺","img":"http://i1.douguo.net/upload/caiku/7/7/4/300_7723e718bf19de2f2d41d93c9a5d9ad4.jpg","stc":14,"sti":1,"dc":1,"fc":69,"an":"吃好吃的喽aici君","ecs":0,"hq":0,"a":{"id":"8942164","n":"吃好吃的喽aici君","v":1,"p":"http://tx2.douguo.net/upload/photo/8/4/9/70_u2890298993436213816.jpg"},"p":"http://cp1.douguo.net/upload/caiku/7/7/4/600_7723e718bf19de2f2d41d93c9a5d9ad4.jpg","cookstep":[{"position":"1","content":"准备好牛肉馅，生姜去皮切丝，大葱切圈，青椒切小丁。","thumb":"http://cp1.douguo.net/upload/caiku/7/d/d/140_7d86d3b7418aeac3c57fa91c7bc79ced.jpg","image":"http://cp1.douguo.net/upload/caiku/7/d/d/600_7d86d3b7418aeac3c57fa91c7bc79ced.jpg"},{"position":"2","content":"将生姜、大葱、青椒继续切碎，然后放入牛肉馅中，加入食盐，老抽、浓汤宝、鸡粉、五香粉、料酒。","thumb":"http://cp1.douguo.net/upload/caiku/8/6/a/140_86df88aa85c40d4868a58e9de902fcfa.jpg","image":"http://cp1.douguo.net/upload/caiku/8/6/a/600_86df88aa85c40d4868a58e9de902fcfa.jpg"},{"position":"3","content":"搅拌均匀即可。","thumb":"http://cp1.douguo.net/upload/caiku/e/7/8/140_e74f9abfad0f02fed8049791fe72ed78.jpg","image":"http://cp1.douguo.net/upload/caiku/e/7/8/600_e74f9abfad0f02fed8049791fe72ed78.jpg"},{"position":"4","content":"面粉放入面盆中。","thumb":"http://cp1.douguo.net/upload/caiku/9/7/d/140_97c19891ae3fec396f7a90584248f3bd.jpg","image":"http://cp1.douguo.net/upload/caiku/9/7/d/600_97c19891ae3fec396f7a90584248f3bd.jpg"},{"position":"5","content":"加入清水和成面团，醒发20分左右。","thumb":"http://cp1.douguo.net/upload/caiku/4/2/2/140_422fed51355ece105a383ad188d72122.jpg","image":"http://cp1.douguo.net/upload/caiku/4/2/2/600_422fed51355ece105a383ad188d72122.jpg"},{"position":"6","content":"将面团揉长，切成小剂子，按扁。","thumb":"http://cp1.douguo.net/upload/caiku/9/f/7/140_9f5034dec440e44d2b1fd21c306ec3e7.jpg","image":"http://cp1.douguo.net/upload/caiku/9/f/7/600_9f5034dec440e44d2b1fd21c306ec3e7.jpg"},{"position":"7","content":"将按扁的面团擀开，放入馅料。","thumb":"http://cp1.douguo.net/upload/caiku/c/9/4/140_c909e6000c90ca253a5fcf4851f0d2b4.jpg","image":"http://cp1.douguo.net/upload/caiku/c/9/4/600_c909e6000c90ca253a5fcf4851f0d2b4.jpg"},{"position":"8","content":"包好。","thumb":"http://cp1.douguo.net/upload/caiku/8/3/e/140_831c8c3a706fa749c1eebd5bf8ee9a9e.jpg","image":"http://cp1.douguo.net/upload/caiku/8/3/e/600_831c8c3a706fa749c1eebd5bf8ee9a9e.jpg"},{"position":"9","content":"包好所有的饺子。","thumb":"http://cp1.douguo.net/upload/caiku/a/1/9/140_a1423729cc9de9ef539dac8aaa114279.jpg","image":"http://cp1.douguo.net/upload/caiku/a/1/9/600_a1423729cc9de9ef539dac8aaa114279.jpg"},{"position":"10","content":"锅中做水，水开以后放入饺子，点三次水。","thumb":"http://cp1.douguo.net/upload/caiku/0/d/6/140_0d9c8cae04443024d8ae71e756655fc6.jpg","image":"http://cp1.douguo.net/upload/caiku/0/d/6/600_0d9c8cae04443024d8ae71e756655fc6.jpg"},{"position":"11","content":"煮熟的饺子捞出来。","thumb":"http://cp1.douguo.net/upload/caiku/1/7/7/140_17298dc65e3135911402625cda255fa7.jpg","image":"http://cp1.douguo.net/upload/caiku/1/7/7/600_17298dc65e3135911402625cda255fa7.jpg"},{"position":"12","content":"我喜欢蘸醋再配一点儿自制辣椒酱。","thumb":"http://cp1.douguo.net/upload/caiku/a/1/e/140_a1ced1fa6edb84de6051fbe3140d2b5e.jpg","image":"http://cp1.douguo.net/upload/caiku/a/1/e/600_a1ced1fa6edb84de6051fbe3140d2b5e.jpg"},{"position":"13","content":"O(∩_∩)O哈哈~","thumb":"http://cp1.douguo.net/upload/caiku/5/5/2/140_55210a96d1cd4fdb97d75684a0689592.jpg","image":"http://cp1.douguo.net/upload/caiku/5/5/2/600_55210a96d1cd4fdb97d75684a0689592.jpg"},{"position":"14","content":"开吃啦~","thumb":"http://cp1.douguo.net/upload/caiku/e/1/0/140_e197e5a4654581fb480028791c8a2500.jpg","image":"http://cp1.douguo.net/upload/caiku/e/1/0/600_e197e5a4654581fb480028791c8a2500.jpg"}],"major":[{"title":"牛肉馅","note":"50g"},{"title":"青椒","note":"1个"},{"title":"面粉","note":"100g"}],"minor":[{"title":"大葱","note":"半根"},{"title":"生姜","note":"1小块"},{"title":"料酒","note":"2ml"},{"title":"五香粉","note":"2g"},{"title":"食盐","note":"2g"},{"title":"老抽","note":"1g"},{"title":"浓汤宝","note":"半个"},{"title":"鸡粉","note":"1g"}],"cook_difficulty":"切墩(初级)","cook_time":"10-30分钟","tags":[],"vc":2014}
         * id : 1544952
         * type : 2
         * tc :
         * h : 0
         */

        private List<ListBean> list;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public String getMurl() {
            return murl;
        }

        public void setMurl(String murl) {
            this.murl = murl;
        }

        public int getEd() {
            return ed;
        }

        public void setEd(int ed) {
            this.ed = ed;
        }

        public String getBtmid() {
            return btmid;
        }

        public void setBtmid(String btmid) {
            this.btmid = btmid;
        }

        public String getFlt() {
            return flt;
        }

        public void setFlt(String flt) {
            this.flt = flt;
        }

        public int getNic() {
            return nic;
        }

        public void setNic(int nic) {
            this.nic = nic;
        }

        public String getSlt() {
            return slt;
        }

        public void setSlt(String slt) {
            this.slt = slt;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class HeaderBean {
            /**
             * i : http://i1.douguo.net/upload/banner/4/d/9/4d37044590f900e06d02edf6b91981e9.png
             * u : recipes://www.douguo.com/foodclassification?open=1
             * t : 菜谱分类
             * content : 9
             * id : 9
             */

            private List<FsBean>   fs;
            /**
             * h : 1
             * d : {"id":"1","ch":0,"t":"","d":"","i":"http://i1.douguo.net/upload/banner/a/5/6/a5e1731d360c58c8099350f122add866.jpg","url":"recipes://www.douguo.com/menu?id=5523990"}
             */

            private List<DspsBean> dsps;
            /**
             * s : 0
             * i : http://i1.douguo.net/upload/banner/1488859251.png
             * u : recipes://www.douguo.com/dishtag?id=271
             * t : 今日早餐
             * c : 1431人记录
             * tian : ["8176592","8176233","8151394","8148415","8132479","8131481"]
             * huodong_id : 879
             * is : ["http://i1.douguo.net/upload/dish/b/6/a/200_b6788942ff72b77024088d980ea603da.jpeg","http://i1.douguo.net/upload/dish/6/1/5/200_61ffa640ce319bc138a060e61f328595.jpg"]
             */

            private List<DsBean>   ds;
            private List<Integer>  q;

            public List<FsBean> getFs() {
                return fs;
            }

            public void setFs(List<FsBean> fs) {
                this.fs = fs;
            }

            public List<DspsBean> getDsps() {
                return dsps;
            }

            public void setDsps(List<DspsBean> dsps) {
                this.dsps = dsps;
            }

            public List<DsBean> getDs() {
                return ds;
            }

            public void setDs(List<DsBean> ds) {
                this.ds = ds;
            }

            public List<Integer> getQ() {
                return q;
            }

            public void setQ(List<Integer> q) {
                this.q = q;
            }

            public static class FsBean {
                private String i;
                private String u;
                private String t;
                private String content;
                private String id;

                public String getI() {
                    return i;
                }

                public void setI(String i) {
                    this.i = i;
                }

                public String getU() {
                    return u;
                }

                public void setU(String u) {
                    this.u = u;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class DspsBean {

                private UBean u;




                public UBean getU() {
                    return u;
                }

                public void setU(UBean u) {
                    this.u = u;
                }


                public static class UBean {
                    private String id;
                    private String n;
                    private String p;
                    private int    v;
                    private int    lv;
                    private String qzn;

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

                    public String getP() {
                        return p;
                    }

                    public void setP(String p) {
                        this.p = p;
                    }

                    public int getV() {
                        return v;
                    }

                    public void setV(int v) {
                        this.v = v;
                    }

                    public int getLv() {
                        return lv;
                    }

                    public void setLv(int lv) {
                        this.lv = lv;
                    }

                    public String getQzn() {
                        return qzn;
                    }

                    public void setQzn(String qzn) {
                        this.qzn = qzn;
                    }
                }
                private int   h;
                /**
                 * id : 1
                 * ch : 0
                 * t :
                 * d :
                 * i : http://i1.douguo.net/upload/banner/a/5/6/a5e1731d360c58c8099350f122add866.jpg
                 * url : recipes://www.douguo.com/menu?id=5523990
                 */

                private DBean d;

                public int getH() {
                    return h;
                }

                public void setH(int h) {
                    this.h = h;
                }

                public DBean getD() {
                    return d;
                }

                public void setD(DBean d) {
                    this.d = d;
                }

                public static class DBean {
                    private String id;
                    private int    ch;
                    private String t;
                    private String d;
                    private String i;
                    private String url;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public int getCh() {
                        return ch;
                    }

                    public void setCh(int ch) {
                        this.ch = ch;
                    }

                    public String getT() {
                        return t;
                    }

                    public void setT(String t) {
                        this.t = t;
                    }

                    public String getD() {
                        return d;
                    }

                    public void setD(String d) {
                        this.d = d;
                    }

                    public String getI() {
                        return i;
                    }

                    public void setI(String i) {
                        this.i = i;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            public static class DsBean {
                private int          s;
                private String       i;
                private String       u;
                private String       t;
                private String       c;
                private String       huodong_id;
                private List<String> tian;
                private List<String> is;

                public int getS() {
                    return s;
                }

                public void setS(int s) {
                    this.s = s;
                }

                public String getI() {
                    return i;
                }

                public void setI(String i) {
                    this.i = i;
                }

                public String getU() {
                    return u;
                }

                public void setU(String u) {
                    this.u = u;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public String getC() {
                    return c;
                }

                public void setC(String c) {
                    this.c = c;
                }

                public String getHuodong_id() {
                    return huodong_id;
                }

                public void setHuodong_id(String huodong_id) {
                    this.huodong_id = huodong_id;
                }

                public List<String> getTian() {
                    return tian;
                }

                public void setTian(List<String> tian) {
                    this.tian = tian;
                }

                public List<String> getIs() {
                    return is;
                }

                public void setIs(List<String> is) {
                    this.is = is;
                }
            }
        }

        public static class ListBean {

            /**
             * id : 5524225
             * t : 出游必备！快手方便小零嘴！
             * a : {"id":"9820796","n":"请叫我小花儿","p":"http://tx2.douguo.net/upload/photo/1/b/3/70_u34015596630824100203.jpg","v":0,"lv":0}
             * b : http://i1.douguo.net/upload/caiku/9/c/8/9c42f81f34ecb6caac6978df58f6e1f8.jpeg
             * is : [{"i_u":"http://i1.douguo.net/upload/caiku/9/9/0/200_992c9f473a1385f47d838f47aafbd8f0.jpg"},{"i_u":"http://i1.douguo.net/upload/caiku/1/a/a/200_1ad5a109f91f7a7293e0bf8cc87a03da.jpg"},{"i_u":"http://i1.douguo.net/upload/caiku/3/8/1/200_386be2ad427700b9bbf60ca8fe8ce721.jpg"},{"i_u":"http://i1.douguo.net/upload/caiku/7/c/6/200_7c759b7952475ff153a67da9d2c61c76.jpg"}]
             * c : 105
             */

            private MBean m;

            public MBean getM() {
                return m;
            }

            public void setM(MBean m) {
                this.m = m;
            }

            public static class MBean implements Serializable{
                private int                         id;
                private String                      t;
                /**
                 * id : 9820796
                 * n : 请叫我小花儿
                 * p : http://tx2.douguo.net/upload/photo/1/b/3/70_u34015596630824100203.jpg
                 * v : 0
                 * lv : 0
                 */

                private ABean        a;
                private String                      b;
                private String                      c;
                /**
                 * i_u : http://i1.douguo.net/upload/caiku/9/9/0/200_992c9f473a1385f47d838f47aafbd8f0.jpg
                 */

                private List<IsBean> is;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public ABean getA() {
                    return a;
                }

                public void setA(ABean a) {
                    this.a = a;
                }

                public String getB() {
                    return b;
                }

                public void setB(String b) {
                    this.b = b;
                }

                public String getC() {
                    return c;
                }

                public void setC(String c) {
                    this.c = c;
                }

                public List<IsBean> getIs() {
                    return is;
                }

                public void setIs(List<IsBean> is) {
                    this.is = is;
                }

                public static class ABean implements Serializable{
                    private String id;
                    private String n;
                    private String p;
                    private int    v;
                    private int    lv;

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

                    public String getP() {
                        return p;
                    }

                    public void setP(String p) {
                        this.p = p;
                    }

                    public int getV() {
                        return v;
                    }

                    public void setV(int v) {
                        this.v = v;
                    }

                    public int getLv() {
                        return lv;
                    }

                    public void setLv(int lv) {
                        this.lv = lv;
                    }
                }

                public static class IsBean implements Serializable{
                    private String i_u;

                    public String getI_u() {
                        return i_u;
                    }

                    public void setI_u(String i_u) {
                        this.i_u = i_u;
                    }
                }
            }
            /**
             * id : 1235
             * pid :
             * ch : 0
             * url : http://m.douguo.com/jump/100/950
             * i : http://i1.douguo.net//upload/recipe/8/a/9/8a7ebb1d35f7152580be65761bb24a29.jpg
             * cap : 广告
             * t : 京东家装节 买4免1
             * d : 京东家装节最后3天，自营满199减100
             * query :
             * req_min_i : 2
             */

            private DspBean dsp;
            public DspBean getDsp() {
                return dsp;
            }

            public void setDsp(DspBean dsp) {
                this.dsp = dsp;
            }

            public static class DspBean {
                private String id;
                private String pid;
                private int    ch;
                private String url;
                private String i;
                private String cap;
                private String t;
                private String d;
                private String query;
                private int    req_min_i;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public int getCh() {
                    return ch;
                }

                public void setCh(int ch) {
                    this.ch = ch;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getI() {
                    return i;
                }

                public void setI(String i) {
                    this.i = i;
                }

                public String getCap() {
                    return cap;
                }

                public void setCap(String cap) {
                    this.cap = cap;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public String getD() {
                    return d;
                }

                public void setD(String d) {
                    this.d = d;
                }

                public String getQuery() {
                    return query;
                }

                public void setQuery(String query) {
                    this.query = query;
                }

                public int getReq_min_i() {
                    return req_min_i;
                }

                public void setReq_min_i(int req_min_i) {
                    this.req_min_i = req_min_i;
                }
            }

            /**
             * {
             * "ta": {
             * "id": "1343",
             * "i": "http://i1.douguo.net/upload/group/4/8/9/48ecd79773622380573a33dfd1b99949.jpg",
             * "u": "recipes://www.douguo.com/coursedetail?id=81",
             * "t": "【豆果课堂】网红珍妮曲奇",
             * "c": "限时抢6.6元，跟着虎虎老师学，再也不用去香港排队疯抢珍妮曲奇了！",
             * "vc": 0
             * },
             * "id": "6412",
             * "type": "8",
             * "tc": "",
             * "h": 1
             * }
             */

            private TaBean ta;

            public TaBean getTa() {
                return ta;
            }

            public void setTa(TaBean ta) {
                this.ta = ta;
            }

            public static class TaBean {
                private String id;
                private String i;
                private String u;
                private String t;
                private String c;
                private int    vc;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getI() {
                    return i;
                }

                public void setI(String i) {
                    this.i = i;
                }

                public String getU() {
                    return u;
                }

                public void setU(String u) {
                    this.u = u;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public String getC() {
                    return c;
                }

                public void setC(String c) {
                    this.c = c;
                }

                public int getVc() {
                    return vc;
                }

                public void setVc(int vc) {
                    this.vc = vc;
                }
            }

            /**
             * id : 1544952
             * cookstory : 哎，莫名其妙的感冒了，都不知道是什么原因引起的，真是难受/(ㄒoㄒ)/~~难受的时候就是想吃点儿暖心暖胃的食物，自己包了点儿饺子，希望把病毒快快赶走！
             * n : 青椒牛肉水饺
             * img : http://i1.douguo.net/upload/caiku/7/7/4/300_7723e718bf19de2f2d41d93c9a5d9ad4.jpg
             * stc : 14
             * sti : 1
             * dc : 1
             * fc : 69
             * an : 吃好吃的喽aici君
             * ecs : 0
             * hq : 0
             * a : {"id":"8942164","n":"吃好吃的喽aici君","v":1,"p":"http://tx2.douguo.net/upload/photo/8/4/9/70_u2890298993436213816.jpg"}
             * p : http://cp1.douguo.net/upload/caiku/7/7/4/600_7723e718bf19de2f2d41d93c9a5d9ad4.jpg
             * cookstep : [{"position":"1","content":"准备好牛肉馅，生姜去皮切丝，大葱切圈，青椒切小丁。","thumb":"http://cp1.douguo.net/upload/caiku/7/d/d/140_7d86d3b7418aeac3c57fa91c7bc79ced.jpg","image":"http://cp1.douguo.net/upload/caiku/7/d/d/600_7d86d3b7418aeac3c57fa91c7bc79ced.jpg"},{"position":"2","content":"将生姜、大葱、青椒继续切碎，然后放入牛肉馅中，加入食盐，老抽、浓汤宝、鸡粉、五香粉、料酒。","thumb":"http://cp1.douguo.net/upload/caiku/8/6/a/140_86df88aa85c40d4868a58e9de902fcfa.jpg","image":"http://cp1.douguo.net/upload/caiku/8/6/a/600_86df88aa85c40d4868a58e9de902fcfa.jpg"},{"position":"3","content":"搅拌均匀即可。","thumb":"http://cp1.douguo.net/upload/caiku/e/7/8/140_e74f9abfad0f02fed8049791fe72ed78.jpg","image":"http://cp1.douguo.net/upload/caiku/e/7/8/600_e74f9abfad0f02fed8049791fe72ed78.jpg"},{"position":"4","content":"面粉放入面盆中。","thumb":"http://cp1.douguo.net/upload/caiku/9/7/d/140_97c19891ae3fec396f7a90584248f3bd.jpg","image":"http://cp1.douguo.net/upload/caiku/9/7/d/600_97c19891ae3fec396f7a90584248f3bd.jpg"},{"position":"5","content":"加入清水和成面团，醒发20分左右。","thumb":"http://cp1.douguo.net/upload/caiku/4/2/2/140_422fed51355ece105a383ad188d72122.jpg","image":"http://cp1.douguo.net/upload/caiku/4/2/2/600_422fed51355ece105a383ad188d72122.jpg"},{"position":"6","content":"将面团揉长，切成小剂子，按扁。","thumb":"http://cp1.douguo.net/upload/caiku/9/f/7/140_9f5034dec440e44d2b1fd21c306ec3e7.jpg","image":"http://cp1.douguo.net/upload/caiku/9/f/7/600_9f5034dec440e44d2b1fd21c306ec3e7.jpg"},{"position":"7","content":"将按扁的面团擀开，放入馅料。","thumb":"http://cp1.douguo.net/upload/caiku/c/9/4/140_c909e6000c90ca253a5fcf4851f0d2b4.jpg","image":"http://cp1.douguo.net/upload/caiku/c/9/4/600_c909e6000c90ca253a5fcf4851f0d2b4.jpg"},{"position":"8","content":"包好。","thumb":"http://cp1.douguo.net/upload/caiku/8/3/e/140_831c8c3a706fa749c1eebd5bf8ee9a9e.jpg","image":"http://cp1.douguo.net/upload/caiku/8/3/e/600_831c8c3a706fa749c1eebd5bf8ee9a9e.jpg"},{"position":"9","content":"包好所有的饺子。","thumb":"http://cp1.douguo.net/upload/caiku/a/1/9/140_a1423729cc9de9ef539dac8aaa114279.jpg","image":"http://cp1.douguo.net/upload/caiku/a/1/9/600_a1423729cc9de9ef539dac8aaa114279.jpg"},{"position":"10","content":"锅中做水，水开以后放入饺子，点三次水。","thumb":"http://cp1.douguo.net/upload/caiku/0/d/6/140_0d9c8cae04443024d8ae71e756655fc6.jpg","image":"http://cp1.douguo.net/upload/caiku/0/d/6/600_0d9c8cae04443024d8ae71e756655fc6.jpg"},{"position":"11","content":"煮熟的饺子捞出来。","thumb":"http://cp1.douguo.net/upload/caiku/1/7/7/140_17298dc65e3135911402625cda255fa7.jpg","image":"http://cp1.douguo.net/upload/caiku/1/7/7/600_17298dc65e3135911402625cda255fa7.jpg"},{"position":"12","content":"我喜欢蘸醋再配一点儿自制辣椒酱。","thumb":"http://cp1.douguo.net/upload/caiku/a/1/e/140_a1ced1fa6edb84de6051fbe3140d2b5e.jpg","image":"http://cp1.douguo.net/upload/caiku/a/1/e/600_a1ced1fa6edb84de6051fbe3140d2b5e.jpg"},{"position":"13","content":"O(∩_∩)O哈哈~","thumb":"http://cp1.douguo.net/upload/caiku/5/5/2/140_55210a96d1cd4fdb97d75684a0689592.jpg","image":"http://cp1.douguo.net/upload/caiku/5/5/2/600_55210a96d1cd4fdb97d75684a0689592.jpg"},{"position":"14","content":"开吃啦~","thumb":"http://cp1.douguo.net/upload/caiku/e/1/0/140_e197e5a4654581fb480028791c8a2500.jpg","image":"http://cp1.douguo.net/upload/caiku/e/1/0/600_e197e5a4654581fb480028791c8a2500.jpg"}]
             * major : [{"title":"牛肉馅","note":"50g"},{"title":"青椒","note":"1个"},{"title":"面粉","note":"100g"}]
             * minor : [{"title":"大葱","note":"半根"},{"title":"生姜","note":"1小块"},{"title":"料酒","note":"2ml"},{"title":"五香粉","note":"2g"},{"title":"食盐","note":"2g"},{"title":"老抽","note":"1g"},{"title":"浓汤宝","note":"半个"},{"title":"鸡粉","note":"1g"}]
             * cook_difficulty : 切墩(初级)
             * cook_time : 10-30分钟
             * tags : []
             * vc : 2014
             */

            private RBean  r;
            private String id;
            private String type;
            private String tc;
            private int    h;

            public RBean getR() {
                return r;
            }

            public void setR(RBean r) {
                this.r = r;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTc() {
                return tc;
            }

            public void setTc(String tc) {
                this.tc = tc;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
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

                public static class MinorBean implements Serializable{
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
}
