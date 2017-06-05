package com.yzyfdf.lifehelper.bean.cookbean;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookSearchBean extends BaseCookBean {



    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {


        private MdspBean mdsp;
        private String         adurl;
        private IeBean         ie;
        private List<String>   sts;
        private List<ListBean> list;

        public MdspBean getMdsp() {
            return mdsp;
        }

        public void setMdsp(MdspBean mdsp) {
            this.mdsp = mdsp;
        }

        public String getAdurl() {
            return adurl;
        }

        public void setAdurl(String adurl) {
            this.adurl = adurl;
        }

        public IeBean getIe() {
            return ie;
        }

        public void setIe(IeBean ie) {
            this.ie = ie;
        }

        public List<String> getSts() {
            return sts;
        }

        public void setSts(List<String> sts) {
            this.sts = sts;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class MdspBean {
            /**
             * dsp : {"id":"1219","pid":"","ch":0,"url":"http://m.douguo.com/activity/cpzj/index/1041?isapp=1&open=0","i":"http://i1.douguo.net//upload/recipe/e/0/e/e062a43c5274fe0e840bd001bc0da61e.jpg","cap":"","t":"松下饭煲关键词","d":"松下饭煲关键词","query":"","req_min_i":2}
             * type : 126
             */

            private DspBean dsp;
            private int type;

            public DspBean getDsp() {
                return dsp;
            }

            public void setDsp(DspBean dsp) {
                this.dsp = dsp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public static class DspBean {
                /**
                 * id : 1219
                 * pid :
                 * ch : 0
                 * url : http://m.douguo.com/activity/cpzj/index/1041?isapp=1&open=0
                 * i : http://i1.douguo.net//upload/recipe/e/0/e/e062a43c5274fe0e840bd001bc0da61e.jpg
                 * cap :
                 * t : 松下饭煲关键词
                 * d : 松下饭煲关键词
                 * query :
                 * req_min_i : 2
                 */

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
        }

        public static class IeBean {
            /**
             * i : http://cp2.douguo.net/upload/shicai/1445843485.jpg
             * n : 牛肉
             * d : 食材的营养功效，饮食搭配
             * u : http://m.douguo.com/ingredients/牛肉/detailmaterial
             */

            private String i;
            private String n;
            private String d;
            private String u;

            public String getI() {
                return i;
            }

            public void setI(String i) {
                this.i = i;
            }

            public String getN() {
                return n;
            }

            public void setN(String n) {
                this.n = n;
            }

            public String getD() {
                return d;
            }

            public void setD(String d) {
                this.d = d;
            }

            public String getU() {
                return u;
            }

            public void setU(String u) {
                this.u = u;
            }
        }

        public static class ListBean {


            private int type;
            private RBean    r;
            private DspBeanX dsp;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public RBean getR() {
                return r;
            }

            public void setR(RBean r) {
                this.r = r;
            }

            public DspBeanX getDsp() {
                return dsp;
            }

            public void setDsp(DspBeanX dsp) {
                this.dsp = dsp;
            }

            public static class RBean {


                private int id;
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
                private ABean              a;
                private String             p;
                private String             cook_difficulty;
                private String             cook_time;
                private int                vc;
                private List<CookstepBean> cookstep;
                private List<MajorBean>    major;
                private List<MinorBean>    minor;
                private List<TagsBean>     tags;

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

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }

                public static class ABean {
                    /**
                     * id : 3084957
                     * n : keletimes
                     * v : 1
                     * p : http://tx2.douguo.net/upload/photo/4/6/9/70_u75959639894837132612.jpg
                     */

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

                public static class CookstepBean {
                    /**
                     * position : 1
                     * content : 牛腩入冷水锅烧开一分钟，焯水捞起，再放入高压锅加水、姜片、葱段、料酒和一个炖肉料包，压半小时左右关火
                     * thumb : http://cp1.douguo.net/upload/caiku/5/e/a/140_5e83d3b09ea2f336a292621b92b7c1da.jpg
                     * image : http://cp1.douguo.net/upload/caiku/5/e/a/600_5e83d3b09ea2f336a292621b92b7c1da.jpg
                     */

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

                public static class MajorBean {
                    /**
                     * title : 牛腩
                     * note : 一斤
                     */

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

                public static class MinorBean {
                    /**
                     * title : 葱
                     * note : 适量
                     */

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

                public static class TagsBean {
                    /**
                     * t : 家常菜
                     */

                    private String t;

                    public String getT() {
                        return t;
                    }

                    public void setT(String t) {
                        this.t = t;
                    }
                }
            }

            public static class DspBeanX {
                /**
                 * id : 1111
                 * pid : 7090100781143884
                 * ch : 1
                 * url :
                 * i :
                 * cap : 广告
                 * query :
                 * req_min_i : 2
                 */

                private String id;
                private String pid;
                private int    ch;
                private String url;
                private String i;
                private String cap;
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
        }
    }
}
