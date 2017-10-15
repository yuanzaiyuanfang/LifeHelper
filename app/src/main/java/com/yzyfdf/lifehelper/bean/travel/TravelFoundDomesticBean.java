package com.yzyfdf.lifehelper.bean.travel;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class TravelFoundDomesticBean extends TravelBaseBean {

    /**
     * data : {"guides":[{"country":"中国","id":1,"img":"http://img.chufaba.me/guides/domestic/shanghai.jpg","intro":"「东方巴黎」「十里洋场」「魔性」\n完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。","name":"上海","name_en":"Shanghai"},{"country":"中国","id":2,"img":"http://img.chufaba.me/guides/domestic/beijing.jpg","intro":"「首都」「全球最伟大的城市之一」\n历史悠久名城，每一处角落都蕴藏丰富的历史痕迹与人文内涵。文化艺术活动从不间断、酒吧街的热闹繁华日日进行、到处都是胡同与京片子，是组成京城的最鲜明元素。四季气候分明，尤其秋冬总有惊艳全国的魅力。\n","name":"北京","name_en":"Beijing"},{"country":"中国","id":3,"img":"http://img.chufaba.me/guides/domestic/hangzhou.jpg","intro":"「湖光山色」 「人间天堂」 「才子佳人」\n别名钱塘，旧称临安。有湖光山色、烟雨迷蒙，因西湖而最是温柔旖旎；也有历史烟雨，才子佳人，文墨浸润，千年才情熬成一座城。三面云山一面城，书香与茶香，西子湖与钱塘江，自然和人文，繁华和古朴，共赋一曲人间天堂的辞赋。\n","name":"杭州","name_en":"Hangzhou"},{"country":"中国","id":4,"img":"http://img.chufaba.me/guides/domestic/xian.jpg","intro":"「十三朝古都」「梦回汉唐」\n秦时明月汉唐天，它是外国游客最喜欢的中国城市，也是天下华人的灵魂故乡。这里有太白诗，贵妃酒，十三朝古都的荣与辱；这里有兵马俑、汉帝陵，千年盛世的爱与恨。未央宫与乐游原不再，但我们依然能在城墙、碑林、大雁塔中窥见那个长安。长安长安，寒夜常梦见，此去几千年。\n","name":"西安","name_en":"Xian"},{"country":"中国","id":5,"img":"http://img.chufaba.me/guides/domestic/guangzhou.jpg","intro":"「最好吃的城市」 「节奏最慢的一线城市」\n这个中国节奏最慢的一线城市，看得到商业文化滋养的繁荣昌盛，也显见广府文化孕育出的市井怡然。比珠江新城的国际摩登，北京路的热闹喧嚣，沙面的西洋风情，黄浦的古意悠然，老祠堂的岭南遗韵都更重要的是，这里是中国最好吃的城市啊！\n","name":"广州","name_en":"Guangzhou"},{"country":"中国","id":6,"img":"http://img.chufaba.me/guides/domestic/lijiang.jpg","intro":"「艳遇圣地」 「慢生活」 「柔软时光」\n这里是雪山下的柔软时光，充满艳遇的小资之城。艳丽的自然风光，慵懒的生活节奏，让人来了便不忍离去。光滑的石板路，手工建造的木楼青瓦，无处不在的小桥流水，让丽江成为没有城墙的柔美古城。到丽江，就在慵懒的时光中慢慢度过吧。 \n","name":"丽江","name_en":"Lijiang"},{"country":"中国","id":13,"img":"http://img.chufaba.me/guides/domestic/chengdu.jpg","intro":"「天府之国」 「熊猫故里」 「悠闲生活」\n自从在三国时的政治舞台上惊鸿一瞥后，成都便走上了雅趣的生活道路。这是一座来了就不想走的城市，富足丰饶，吃得火辣、活得热辣。有着数不胜数的美食、悠闲的慢生活和深厚的巴蜀文化，拥\u201c天府之国\u201d之美誉。 ","name":"成都","name_en":"Chengdu"},{"country":"中国","id":14,"img":"http://img.chufaba.me/guides/domestic/chongqing.jpg","intro":"「打望美女好地方」 「火锅味香满城」\n地图是平面的，而重庆是立体的。它四面环山，长江和嘉陵江在此交汇。夜景，美女和火锅是这里的三张名片。白天去解放碑打望美女，晚上登高远眺尽收两江夜景，再吃顿热辣火锅，麻辣鲜香，越吃越爽。 ","name":"重庆","name_en":"Chongqing"},{"country":"中国","id":15,"img":"http://img.chufaba.me/guides/domestic/xiamen.jpg","intro":"「东方夏威夷」「海上花园」「闽南风情」「别想减肥」\n相传远古时为白鹭栖息地，故又称\u201c鹭岛\u201d。四季温和多雨，几乎没有冬天。侨乡背景下的异国建筑，使其拥有别具一格的迷人风情，清新与市井并存，悠闲的慢生活和美味的海鲜、闽南小吃，都将是俘获你芳心的不二理由。","name":"厦门","name_en":"Xiamen"},{"country":"中国","id":16,"img":"http://img.chufaba.me/guides/domestic/nanjing.jpg","intro":"「六朝古都」 「荣耀与悲情」\n一座六朝古都，享盛世之荣耀，历乱世之悲情。金陵或是石头城，古城或是旧都，如今秦淮河的桨声灯影中已经没有脂粉香，但校园和书店让文气墨香不曾断绝，古寺和城墙让古意能被触摸，陵墓与博物馆让怀古之情得以抒发。","name":"南京","name_en":"Nanjing"},{"country":"中国","id":17,"img":"http://img.chufaba.me/guides/domestic/suzhou.jpg","intro":"「所谓江南」 「最诗意的栖居」\n一座园林，一件苏绣，一碗苏式面，一支评弹，一场昆曲，一腔吴侬软语，构成一座姑苏城，也构成中国人曾有过的最精致的生活。两千五百年历史的城池，是阖闾城，是江东，是平江城，桃花庵不在了，但园林依旧，小桥流水依旧，始终是我们心底那个江南的模样。","name":"苏州","name_en":"Suzhou"},{"country":"中国","id":18,"img":"http://img.chufaba.me/guides/domestic/wuhan.jpg","intro":"「华中最大都市」  「\u201c过早\u201d文化」\n这是一座黄鹤飘逸的历史文化名城，亦是江城，长江和汉江横贯市区，将武汉一分为三。这里有历史，多故事，处处散发着市井之气。早尝户部巷，夜吃吉庆街，吃货有自己的一片天。春去武大赏樱，秋去芦荡嬉戏，是你不可错过的体验。","name":"武汉","name_en":"Wuhan"},{"country":"中国","id":19,"img":"http://img.chufaba.me/guides/domestic/dali.jpg","intro":"「云南文化发祥地」「慢生活」「艳遇之都」「很晒」\n东临洱海，北接丽江，是以白族为自治民族的自治州。大理是云南最早文化的发祥地之一，唐代南诏国、宋代大理国都曾将其作为都城，美丽的自然风光，与深厚的文化积淀、白族特色风情，用风花雪月来形容还远远不够。","name":"大理","name_en":"Dali"},{"country":"中国","id":20,"img":"http://img.chufaba.me/guides/domestic/harbin.jpg","intro":"「东方莫斯科」 「避暑天堂」\n俄罗斯文化与中国文化在这里交融，当年大批俄国人涌入哈尔滨，至今还能看到许多俄式建筑，漫步街头，恍若置身异国。冬季，这是冰雪世界；夏季，这里是避暑天堂。难怪，哈尔滨有着\u201c 东方莫斯科\u201d之称。","name":"哈尔滨","name_en":"Harbin"},{"country":"中国","id":40,"img":"http://img.chufaba.me/guides/domestic/qingdao.jpg","intro":"「殖民风情」「海滨之城」「东方瑞士」\r\n依山傍海的海滨小城，啤酒飘香，街道相错，万国建筑中处处遗留殖民风情。你可以在海滨线上感受碧海蓝天、大吃海鲜，也可流连于各国建筑间欣赏红瓦绿树，亦可登崂山俯瞰山海之阔。青岛最好的打开方式是不定目标慢慢走，惊喜总在下一个转角。","name":"青岛","name_en":"Qingdao"}],"total":15}
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
         * guides : [{"country":"中国","id":1,"img":"http://img.chufaba.me/guides/domestic/shanghai.jpg","intro":"「东方巴黎」「十里洋场」「魔性」\n完美融合中西方文化，日新月异的摩登混搭历史悠久的痕迹，造就如今魔性的海派魅力。她是繁华大都市，同时拥有平凡市井的烟火气，上海的海纳百川与迷之风情，愈发深入感受，愈发觉得亲切。","name":"上海","name_en":"Shanghai"},{"country":"中国","id":2,"img":"http://img.chufaba.me/guides/domestic/beijing.jpg","intro":"「首都」「全球最伟大的城市之一」\n历史悠久名城，每一处角落都蕴藏丰富的历史痕迹与人文内涵。文化艺术活动从不间断、酒吧街的热闹繁华日日进行、到处都是胡同与京片子，是组成京城的最鲜明元素。四季气候分明，尤其秋冬总有惊艳全国的魅力。\n","name":"北京","name_en":"Beijing"},{"country":"中国","id":3,"img":"http://img.chufaba.me/guides/domestic/hangzhou.jpg","intro":"「湖光山色」 「人间天堂」 「才子佳人」\n别名钱塘，旧称临安。有湖光山色、烟雨迷蒙，因西湖而最是温柔旖旎；也有历史烟雨，才子佳人，文墨浸润，千年才情熬成一座城。三面云山一面城，书香与茶香，西子湖与钱塘江，自然和人文，繁华和古朴，共赋一曲人间天堂的辞赋。\n","name":"杭州","name_en":"Hangzhou"},{"country":"中国","id":4,"img":"http://img.chufaba.me/guides/domestic/xian.jpg","intro":"「十三朝古都」「梦回汉唐」\n秦时明月汉唐天，它是外国游客最喜欢的中国城市，也是天下华人的灵魂故乡。这里有太白诗，贵妃酒，十三朝古都的荣与辱；这里有兵马俑、汉帝陵，千年盛世的爱与恨。未央宫与乐游原不再，但我们依然能在城墙、碑林、大雁塔中窥见那个长安。长安长安，寒夜常梦见，此去几千年。\n","name":"西安","name_en":"Xian"},{"country":"中国","id":5,"img":"http://img.chufaba.me/guides/domestic/guangzhou.jpg","intro":"「最好吃的城市」 「节奏最慢的一线城市」\n这个中国节奏最慢的一线城市，看得到商业文化滋养的繁荣昌盛，也显见广府文化孕育出的市井怡然。比珠江新城的国际摩登，北京路的热闹喧嚣，沙面的西洋风情，黄浦的古意悠然，老祠堂的岭南遗韵都更重要的是，这里是中国最好吃的城市啊！\n","name":"广州","name_en":"Guangzhou"},{"country":"中国","id":6,"img":"http://img.chufaba.me/guides/domestic/lijiang.jpg","intro":"「艳遇圣地」 「慢生活」 「柔软时光」\n这里是雪山下的柔软时光，充满艳遇的小资之城。艳丽的自然风光，慵懒的生活节奏，让人来了便不忍离去。光滑的石板路，手工建造的木楼青瓦，无处不在的小桥流水，让丽江成为没有城墙的柔美古城。到丽江，就在慵懒的时光中慢慢度过吧。 \n","name":"丽江","name_en":"Lijiang"},{"country":"中国","id":13,"img":"http://img.chufaba.me/guides/domestic/chengdu.jpg","intro":"「天府之国」 「熊猫故里」 「悠闲生活」\n自从在三国时的政治舞台上惊鸿一瞥后，成都便走上了雅趣的生活道路。这是一座来了就不想走的城市，富足丰饶，吃得火辣、活得热辣。有着数不胜数的美食、悠闲的慢生活和深厚的巴蜀文化，拥\u201c天府之国\u201d之美誉。 ","name":"成都","name_en":"Chengdu"},{"country":"中国","id":14,"img":"http://img.chufaba.me/guides/domestic/chongqing.jpg","intro":"「打望美女好地方」 「火锅味香满城」\n地图是平面的，而重庆是立体的。它四面环山，长江和嘉陵江在此交汇。夜景，美女和火锅是这里的三张名片。白天去解放碑打望美女，晚上登高远眺尽收两江夜景，再吃顿热辣火锅，麻辣鲜香，越吃越爽。 ","name":"重庆","name_en":"Chongqing"},{"country":"中国","id":15,"img":"http://img.chufaba.me/guides/domestic/xiamen.jpg","intro":"「东方夏威夷」「海上花园」「闽南风情」「别想减肥」\n相传远古时为白鹭栖息地，故又称\u201c鹭岛\u201d。四季温和多雨，几乎没有冬天。侨乡背景下的异国建筑，使其拥有别具一格的迷人风情，清新与市井并存，悠闲的慢生活和美味的海鲜、闽南小吃，都将是俘获你芳心的不二理由。","name":"厦门","name_en":"Xiamen"},{"country":"中国","id":16,"img":"http://img.chufaba.me/guides/domestic/nanjing.jpg","intro":"「六朝古都」 「荣耀与悲情」\n一座六朝古都，享盛世之荣耀，历乱世之悲情。金陵或是石头城，古城或是旧都，如今秦淮河的桨声灯影中已经没有脂粉香，但校园和书店让文气墨香不曾断绝，古寺和城墙让古意能被触摸，陵墓与博物馆让怀古之情得以抒发。","name":"南京","name_en":"Nanjing"},{"country":"中国","id":17,"img":"http://img.chufaba.me/guides/domestic/suzhou.jpg","intro":"「所谓江南」 「最诗意的栖居」\n一座园林，一件苏绣，一碗苏式面，一支评弹，一场昆曲，一腔吴侬软语，构成一座姑苏城，也构成中国人曾有过的最精致的生活。两千五百年历史的城池，是阖闾城，是江东，是平江城，桃花庵不在了，但园林依旧，小桥流水依旧，始终是我们心底那个江南的模样。","name":"苏州","name_en":"Suzhou"},{"country":"中国","id":18,"img":"http://img.chufaba.me/guides/domestic/wuhan.jpg","intro":"「华中最大都市」  「\u201c过早\u201d文化」\n这是一座黄鹤飘逸的历史文化名城，亦是江城，长江和汉江横贯市区，将武汉一分为三。这里有历史，多故事，处处散发着市井之气。早尝户部巷，夜吃吉庆街，吃货有自己的一片天。春去武大赏樱，秋去芦荡嬉戏，是你不可错过的体验。","name":"武汉","name_en":"Wuhan"},{"country":"中国","id":19,"img":"http://img.chufaba.me/guides/domestic/dali.jpg","intro":"「云南文化发祥地」「慢生活」「艳遇之都」「很晒」\n东临洱海，北接丽江，是以白族为自治民族的自治州。大理是云南最早文化的发祥地之一，唐代南诏国、宋代大理国都曾将其作为都城，美丽的自然风光，与深厚的文化积淀、白族特色风情，用风花雪月来形容还远远不够。","name":"大理","name_en":"Dali"},{"country":"中国","id":20,"img":"http://img.chufaba.me/guides/domestic/harbin.jpg","intro":"「东方莫斯科」 「避暑天堂」\n俄罗斯文化与中国文化在这里交融，当年大批俄国人涌入哈尔滨，至今还能看到许多俄式建筑，漫步街头，恍若置身异国。冬季，这是冰雪世界；夏季，这里是避暑天堂。难怪，哈尔滨有着\u201c 东方莫斯科\u201d之称。","name":"哈尔滨","name_en":"Harbin"},{"country":"中国","id":40,"img":"http://img.chufaba.me/guides/domestic/qingdao.jpg","intro":"「殖民风情」「海滨之城」「东方瑞士」\r\n依山傍海的海滨小城，啤酒飘香，街道相错，万国建筑中处处遗留殖民风情。你可以在海滨线上感受碧海蓝天、大吃海鲜，也可流连于各国建筑间欣赏红瓦绿树，亦可登崂山俯瞰山海之阔。青岛最好的打开方式是不定目标慢慢走，惊喜总在下一个转角。","name":"青岛","name_en":"Qingdao"}]
         * total : 15
         */

        private int total;
        private List<TravelFoundBean.DataBean.GuidesBean> guides;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<TravelFoundBean.DataBean.GuidesBean> getGuides() {
            return guides;
        }

        public void setGuides(List<TravelFoundBean.DataBean.GuidesBean> guides) {
            this.guides = guides;
        }


    }
}
