package com.yzyfdf.lifehelper.bean.travel;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class TravelFoundBean extends TravelBaseBean {

    /**
     * data : {"domestic":{"guides":[{"country":"中国","id":1,"img":"http://img.chufaba.me/guides/domestic/shanghai.jpg","intro":"「东方巴黎」「十里洋场」「魔性」\n完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。","name":"上海","name_en":"Shanghai"},{"country":"中国","id":2,"img":"http://img.chufaba.me/guides/domestic/beijing.jpg","intro":"「首都」「全球最伟大的城市之一」\n历史悠久名城，每一处角落都蕴藏丰富的历史痕迹与人文内涵。文化艺术活动从不间断、酒吧街的热闹繁华日日进行、到处都是胡同与京片子，是组成京城的最鲜明元素。四季气候分明，尤其秋冬总有惊艳全国的魅力。\n","name":"北京","name_en":"Beijing"},{"country":"中国","id":3,"img":"http://img.chufaba.me/guides/domestic/hangzhou.jpg","intro":"「湖光山色」 「人间天堂」 「才子佳人」\n别名钱塘，旧称临安。有湖光山色、烟雨迷蒙，因西湖而最是温柔旖旎；也有历史烟雨，才子佳人，文墨浸润，千年才情熬成一座城。三面云山一面城，书香与茶香，西子湖与钱塘江，自然和人文，繁华和古朴，共赋一曲人间天堂的辞赋。\n","name":"杭州","name_en":"Hangzhou"},{"country":"中国","id":4,"img":"http://img.chufaba.me/guides/domestic/xian.jpg","intro":"「十三朝古都」「梦回汉唐」\n秦时明月汉唐天，它是外国游客最喜欢的中国城市，也是天下华人的灵魂故乡。这里有太白诗，贵妃酒，十三朝古都的荣与辱；这里有兵马俑、汉帝陵，千年盛世的爱与恨。未央宫与乐游原不再，但我们依然能在城墙、碑林、大雁塔中窥见那个长安。长安长安，寒夜常梦见，此去几千年。\n","name":"西安","name_en":"Xian"},{"country":"中国","id":5,"img":"http://img.chufaba.me/guides/domestic/guangzhou.jpg","intro":"「最好吃的城市」 「节奏最慢的一线城市」\n这个中国节奏最慢的一线城市，看得到商业文化滋养的繁荣昌盛，也显见广府文化孕育出的市井怡然。比珠江新城的国际摩登，北京路的热闹喧嚣，沙面的西洋风情，黄浦的古意悠然，老祠堂的岭南遗韵都更重要的是，这里是中国最好吃的城市啊！\n","name":"广州","name_en":"Guangzhou"},{"country":"中国","id":6,"img":"http://img.chufaba.me/guides/domestic/lijiang.jpg","intro":"「艳遇圣地」 「慢生活」 「柔软时光」\n这里是雪山下的柔软时光，充满艳遇的小资之城。艳丽的自然风光，慵懒的生活节奏，让人来了便不忍离去。光滑的石板路，手工建造的木楼青瓦，无处不在的小桥流水，让丽江成为没有城墙的柔美古城。到丽江，就在慵懒的时光中慢慢度过吧。 \n","name":"丽江","name_en":"Lijiang"}],"total":15},"abroad":{"guides":[{"country":"港澳台","id":7,"img":"http://img.chufaba.me/guides/abroad/taipei.jpg","intro":"「多元文化」「台湾第一大城市」「需要很多胃」\n台北最大的魅力在于丰富。有曾经日据时代留下的痕迹，也有传统的中国建筑；有恨不得扶墙进扶墙出的夜市，三天三夜都逛不完的文创园，一两个小时就能抵达的天然氧吧。吃货、文青、自然景色爱好者，它都能满足你的期待。","name":"台北","name_en":"Taipei"},{"country":"港澳台","id":8,"img":"http://img.chufaba.me/guides/abroad/hongkong.jpg","intro":"「很多情节」 「很多美食」 「买买买乐园」\n香港是被摩天大楼割破的城市天空，因灯光而绚烂的维港夜色，是中环的压力与疏离，旺角的熙攘和草根，是美味老店一代代的传承，天星小轮吹了十几年的风，是王家卫电影中的迷离光影，古惑仔电影中的热血街头。在香港，我们购物，觅食，朝圣经典，完满情结。","name":"香港","name_en":"Hong Kong"},{"country":"韩国","id":9,"img":"http://img.chufaba.me/guides/abroad/seoul.jpg","intro":"「韩流风潮」 「买买买」\n这是一座浪漫而寂寞的城市。它浪漫却不张扬，挂上锁的首尔塔，夜灯闪烁的汉江小路，随处可见充满着艺术气息的咖啡厅。它喧嚣却又寂寞，午后的乐天世界，夜中的明洞大街，还有静寂的穿插在整座热闹城市中的韩屋村。","name":"首尔","name_en":"Seoul"},{"country":"日本","id":10,"img":"http://img.chufaba.me/guides/abroad/tokyo.jpg","intro":"「江户风情」「最贵的城市」「日剧饭最爱」「宅男天堂」「米其林星星」\n拥有千年历史的皇城，如今已是全球五大金融中心之一，能满足你对繁华大都市的所有幻想。抱着不同的目的，不管你是日剧饭、动漫迷、购物狂人、米其林摘星爱好者、这里都能实现你的所有情结和远景。毕竟，这可是东京啊！","name":"东京","name_en":"Tokyo"},{"country":"日本","id":11,"img":"http://img.chufaba.me/guides/abroad/kyoto.jpg","intro":"「曾经的首都」「17个世遗」\n做了1200年的日本首都后，留下了不胜枚举的古迹、寺庙，和古朴的日本传统文化。在街巷中偶遇老字号京都特产，在鸭川纳凉床上品尝京料理，或是去寺庙感受寂静美的日式庭院，京都的美和回味自会慢慢浮现。","name":"京都","name_en":"Kyoto"},{"country":"日本","id":12,"img":"http://img.chufaba.me/guides/abroad/osaka.jpg","intro":"「日本第二大城市」「历史文化名城」「天下厨房」「购物圣地」\n日本关西区域的最重要城市，是日本的历史文化名城，也是美食党和买买买剁手党的天堂。哦对，还有日本环球影城和世界最大的室内海游馆，永远在向大小孩们敞开大门！","name":"大阪","name_en":"Osaka"}],"total":28}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * domestic : {"guides":[{"country":"中国","id":1,"img":"http://img.chufaba.me/guides/domestic/shanghai.jpg","intro":"「东方巴黎」「十里洋场」「魔性」\n完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。","name":"上海","name_en":"Shanghai"},{"country":"中国","id":2,"img":"http://img.chufaba.me/guides/domestic/beijing.jpg","intro":"「首都」「全球最伟大的城市之一」\n历史悠久名城，每一处角落都蕴藏丰富的历史痕迹与人文内涵。文化艺术活动从不间断、酒吧街的热闹繁华日日进行、到处都是胡同与京片子，是组成京城的最鲜明元素。四季气候分明，尤其秋冬总有惊艳全国的魅力。\n","name":"北京","name_en":"Beijing"},{"country":"中国","id":3,"img":"http://img.chufaba.me/guides/domestic/hangzhou.jpg","intro":"「湖光山色」 「人间天堂」 「才子佳人」\n别名钱塘，旧称临安。有湖光山色、烟雨迷蒙，因西湖而最是温柔旖旎；也有历史烟雨，才子佳人，文墨浸润，千年才情熬成一座城。三面云山一面城，书香与茶香，西子湖与钱塘江，自然和人文，繁华和古朴，共赋一曲人间天堂的辞赋。\n","name":"杭州","name_en":"Hangzhou"},{"country":"中国","id":4,"img":"http://img.chufaba.me/guides/domestic/xian.jpg","intro":"「十三朝古都」「梦回汉唐」\n秦时明月汉唐天，它是外国游客最喜欢的中国城市，也是天下华人的灵魂故乡。这里有太白诗，贵妃酒，十三朝古都的荣与辱；这里有兵马俑、汉帝陵，千年盛世的爱与恨。未央宫与乐游原不再，但我们依然能在城墙、碑林、大雁塔中窥见那个长安。长安长安，寒夜常梦见，此去几千年。\n","name":"西安","name_en":"Xian"},{"country":"中国","id":5,"img":"http://img.chufaba.me/guides/domestic/guangzhou.jpg","intro":"「最好吃的城市」 「节奏最慢的一线城市」\n这个中国节奏最慢的一线城市，看得到商业文化滋养的繁荣昌盛，也显见广府文化孕育出的市井怡然。比珠江新城的国际摩登，北京路的热闹喧嚣，沙面的西洋风情，黄浦的古意悠然，老祠堂的岭南遗韵都更重要的是，这里是中国最好吃的城市啊！\n","name":"广州","name_en":"Guangzhou"},{"country":"中国","id":6,"img":"http://img.chufaba.me/guides/domestic/lijiang.jpg","intro":"「艳遇圣地」 「慢生活」 「柔软时光」\n这里是雪山下的柔软时光，充满艳遇的小资之城。艳丽的自然风光，慵懒的生活节奏，让人来了便不忍离去。光滑的石板路，手工建造的木楼青瓦，无处不在的小桥流水，让丽江成为没有城墙的柔美古城。到丽江，就在慵懒的时光中慢慢度过吧。 \n","name":"丽江","name_en":"Lijiang"}],"total":15}
         * abroad : {"guides":[{"country":"港澳台","id":7,"img":"http://img.chufaba.me/guides/abroad/taipei.jpg","intro":"「多元文化」「台湾第一大城市」「需要很多胃」\n台北最大的魅力在于丰富。有曾经日据时代留下的痕迹，也有传统的中国建筑；有恨不得扶墙进扶墙出的夜市，三天三夜都逛不完的文创园，一两个小时就能抵达的天然氧吧。吃货、文青、自然景色爱好者，它都能满足你的期待。","name":"台北","name_en":"Taipei"},{"country":"港澳台","id":8,"img":"http://img.chufaba.me/guides/abroad/hongkong.jpg","intro":"「很多情节」 「很多美食」 「买买买乐园」\n香港是被摩天大楼割破的城市天空，因灯光而绚烂的维港夜色，是中环的压力与疏离，旺角的熙攘和草根，是美味老店一代代的传承，天星小轮吹了十几年的风，是王家卫电影中的迷离光影，古惑仔电影中的热血街头。在香港，我们购物，觅食，朝圣经典，完满情结。","name":"香港","name_en":"Hong Kong"},{"country":"韩国","id":9,"img":"http://img.chufaba.me/guides/abroad/seoul.jpg","intro":"「韩流风潮」 「买买买」\n这是一座浪漫而寂寞的城市。它浪漫却不张扬，挂上锁的首尔塔，夜灯闪烁的汉江小路，随处可见充满着艺术气息的咖啡厅。它喧嚣却又寂寞，午后的乐天世界，夜中的明洞大街，还有静寂的穿插在整座热闹城市中的韩屋村。","name":"首尔","name_en":"Seoul"},{"country":"日本","id":10,"img":"http://img.chufaba.me/guides/abroad/tokyo.jpg","intro":"「江户风情」「最贵的城市」「日剧饭最爱」「宅男天堂」「米其林星星」\n拥有千年历史的皇城，如今已是全球五大金融中心之一，能满足你对繁华大都市的所有幻想。抱着不同的目的，不管你是日剧饭、动漫迷、购物狂人、米其林摘星爱好者、这里都能实现你的所有情结和远景。毕竟，这可是东京啊！","name":"东京","name_en":"Tokyo"},{"country":"日本","id":11,"img":"http://img.chufaba.me/guides/abroad/kyoto.jpg","intro":"「曾经的首都」「17个世遗」\n做了1200年的日本首都后，留下了不胜枚举的古迹、寺庙，和古朴的日本传统文化。在街巷中偶遇老字号京都特产，在鸭川纳凉床上品尝京料理，或是去寺庙感受寂静美的日式庭院，京都的美和回味自会慢慢浮现。","name":"京都","name_en":"Kyoto"},{"country":"日本","id":12,"img":"http://img.chufaba.me/guides/abroad/osaka.jpg","intro":"「日本第二大城市」「历史文化名城」「天下厨房」「购物圣地」\n日本关西区域的最重要城市，是日本的历史文化名城，也是美食党和买买买剁手党的天堂。哦对，还有日本环球影城和世界最大的室内海游馆，永远在向大小孩们敞开大门！","name":"大阪","name_en":"Osaka"}],"total":28}
         */

        private DomesticBean domestic;
        private AbroadBean abroad;

        public DomesticBean getDomestic() {
            return domestic;
        }

        public void setDomestic(DomesticBean domestic) {
            this.domestic = domestic;
        }

        public AbroadBean getAbroad() {
            return abroad;
        }

        public void setAbroad(AbroadBean abroad) {
            this.abroad = abroad;
        }

        public static class DomesticBean {
            /**
             * guides : [{"country":"中国","id":1,"img":"http://img.chufaba.me/guides/domestic/shanghai.jpg","intro":"「东方巴黎」「十里洋场」「魔性」\n完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。","name":"上海","name_en":"Shanghai"},{"country":"中国","id":2,"img":"http://img.chufaba.me/guides/domestic/beijing.jpg","intro":"「首都」「全球最伟大的城市之一」\n历史悠久名城，每一处角落都蕴藏丰富的历史痕迹与人文内涵。文化艺术活动从不间断、酒吧街的热闹繁华日日进行、到处都是胡同与京片子，是组成京城的最鲜明元素。四季气候分明，尤其秋冬总有惊艳全国的魅力。\n","name":"北京","name_en":"Beijing"},{"country":"中国","id":3,"img":"http://img.chufaba.me/guides/domestic/hangzhou.jpg","intro":"「湖光山色」 「人间天堂」 「才子佳人」\n别名钱塘，旧称临安。有湖光山色、烟雨迷蒙，因西湖而最是温柔旖旎；也有历史烟雨，才子佳人，文墨浸润，千年才情熬成一座城。三面云山一面城，书香与茶香，西子湖与钱塘江，自然和人文，繁华和古朴，共赋一曲人间天堂的辞赋。\n","name":"杭州","name_en":"Hangzhou"},{"country":"中国","id":4,"img":"http://img.chufaba.me/guides/domestic/xian.jpg","intro":"「十三朝古都」「梦回汉唐」\n秦时明月汉唐天，它是外国游客最喜欢的中国城市，也是天下华人的灵魂故乡。这里有太白诗，贵妃酒，十三朝古都的荣与辱；这里有兵马俑、汉帝陵，千年盛世的爱与恨。未央宫与乐游原不再，但我们依然能在城墙、碑林、大雁塔中窥见那个长安。长安长安，寒夜常梦见，此去几千年。\n","name":"西安","name_en":"Xian"},{"country":"中国","id":5,"img":"http://img.chufaba.me/guides/domestic/guangzhou.jpg","intro":"「最好吃的城市」 「节奏最慢的一线城市」\n这个中国节奏最慢的一线城市，看得到商业文化滋养的繁荣昌盛，也显见广府文化孕育出的市井怡然。比珠江新城的国际摩登，北京路的热闹喧嚣，沙面的西洋风情，黄浦的古意悠然，老祠堂的岭南遗韵都更重要的是，这里是中国最好吃的城市啊！\n","name":"广州","name_en":"Guangzhou"},{"country":"中国","id":6,"img":"http://img.chufaba.me/guides/domestic/lijiang.jpg","intro":"「艳遇圣地」 「慢生活」 「柔软时光」\n这里是雪山下的柔软时光，充满艳遇的小资之城。艳丽的自然风光，慵懒的生活节奏，让人来了便不忍离去。光滑的石板路，手工建造的木楼青瓦，无处不在的小桥流水，让丽江成为没有城墙的柔美古城。到丽江，就在慵懒的时光中慢慢度过吧。 \n","name":"丽江","name_en":"Lijiang"}]
             * total : 15
             */

            private int total;
            private List<GuidesBean> guides;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<GuidesBean> getGuides() {
                return guides;
            }

            public void setGuides(List<GuidesBean> guides) {
                this.guides = guides;
            }


        }

        public static class GuidesBean {
            /**
             * country : 中国
             * id : 1
             * img : http://img.chufaba.me/guides/domestic/shanghai.jpg
             * intro : 「东方巴黎」「十里洋场」「魔性」
             完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。
             * name : 上海
             * name_en : Shanghai
             */

            private String country;
            private int    id;
            private String img;
            private String intro;
            private String name;
            private String name_en;
            private int type;

            public GuidesBean(String country) {
                this.country = country;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }
        }

        public static class AbroadBean {
            /**
             * guides : [{"country":"港澳台","id":7,"img":"http://img.chufaba.me/guides/abroad/taipei.jpg","intro":"「多元文化」「台湾第一大城市」「需要很多胃」\n台北最大的魅力在于丰富。有曾经日据时代留下的痕迹，也有传统的中国建筑；有恨不得扶墙进扶墙出的夜市，三天三夜都逛不完的文创园，一两个小时就能抵达的天然氧吧。吃货、文青、自然景色爱好者，它都能满足你的期待。","name":"台北","name_en":"Taipei"},{"country":"港澳台","id":8,"img":"http://img.chufaba.me/guides/abroad/hongkong.jpg","intro":"「很多情节」 「很多美食」 「买买买乐园」\n香港是被摩天大楼割破的城市天空，因灯光而绚烂的维港夜色，是中环的压力与疏离，旺角的熙攘和草根，是美味老店一代代的传承，天星小轮吹了十几年的风，是王家卫电影中的迷离光影，古惑仔电影中的热血街头。在香港，我们购物，觅食，朝圣经典，完满情结。","name":"香港","name_en":"Hong Kong"},{"country":"韩国","id":9,"img":"http://img.chufaba.me/guides/abroad/seoul.jpg","intro":"「韩流风潮」 「买买买」\n这是一座浪漫而寂寞的城市。它浪漫却不张扬，挂上锁的首尔塔，夜灯闪烁的汉江小路，随处可见充满着艺术气息的咖啡厅。它喧嚣却又寂寞，午后的乐天世界，夜中的明洞大街，还有静寂的穿插在整座热闹城市中的韩屋村。","name":"首尔","name_en":"Seoul"},{"country":"日本","id":10,"img":"http://img.chufaba.me/guides/abroad/tokyo.jpg","intro":"「江户风情」「最贵的城市」「日剧饭最爱」「宅男天堂」「米其林星星」\n拥有千年历史的皇城，如今已是全球五大金融中心之一，能满足你对繁华大都市的所有幻想。抱着不同的目的，不管你是日剧饭、动漫迷、购物狂人、米其林摘星爱好者、这里都能实现你的所有情结和远景。毕竟，这可是东京啊！","name":"东京","name_en":"Tokyo"},{"country":"日本","id":11,"img":"http://img.chufaba.me/guides/abroad/kyoto.jpg","intro":"「曾经的首都」「17个世遗」\n做了1200年的日本首都后，留下了不胜枚举的古迹、寺庙，和古朴的日本传统文化。在街巷中偶遇老字号京都特产，在鸭川纳凉床上品尝京料理，或是去寺庙感受寂静美的日式庭院，京都的美和回味自会慢慢浮现。","name":"京都","name_en":"Kyoto"},{"country":"日本","id":12,"img":"http://img.chufaba.me/guides/abroad/osaka.jpg","intro":"「日本第二大城市」「历史文化名城」「天下厨房」「购物圣地」\n日本关西区域的最重要城市，是日本的历史文化名城，也是美食党和买买买剁手党的天堂。哦对，还有日本环球影城和世界最大的室内海游馆，永远在向大小孩们敞开大门！","name":"大阪","name_en":"Osaka"}]
             * total : 28
             */

            private int total;
            private List<GuidesBean> guides;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<GuidesBean> getGuides() {
                return guides;
            }

            public void setGuides(List<GuidesBean> guides) {
                this.guides = guides;
            }

//            public static class GuidesBeanX {
//                /**
//                 * country : 港澳台
//                 * id : 7
//                 * img : http://img.chufaba.me/guides/abroad/taipei.jpg
//                 * intro : 「多元文化」「台湾第一大城市」「需要很多胃」
//                 台北最大的魅力在于丰富。有曾经日据时代留下的痕迹，也有传统的中国建筑；有恨不得扶墙进扶墙出的夜市，三天三夜都逛不完的文创园，一两个小时就能抵达的天然氧吧。吃货、文青、自然景色爱好者，它都能满足你的期待。
//                 * name : 台北
//                 * name_en : Taipei
//                 */
//
//                private String country;
//                private int    id;
//                private String img;
//                private String intro;
//                private String name;
//                private String name_en;
//
//                public String getCountry() {
//                    return country;
//                }
//
//                public void setCountry(String country) {
//                    this.country = country;
//                }
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getImg() {
//                    return img;
//                }
//
//                public void setImg(String img) {
//                    this.img = img;
//                }
//
//                public String getIntro() {
//                    return intro;
//                }
//
//                public void setIntro(String intro) {
//                    this.intro = intro;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getName_en() {
//                    return name_en;
//                }
//
//                public void setName_en(String name_en) {
//                    this.name_en = name_en;
//                }
//            }
        }
    }
}
