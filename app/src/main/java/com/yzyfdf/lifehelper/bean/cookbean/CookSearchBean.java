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
            private CookRBean    r;
            private DspBeanX dsp;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public CookRBean getR() {
                return r;
            }

            public void setR(CookRBean r) {
                this.r = r;
            }

            public DspBeanX getDsp() {
                return dsp;
            }

            public void setDsp(DspBeanX dsp) {
                this.dsp = dsp;
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
