package com.yzyfdf.lifehelper.bean.weather;

import java.util.List;

/**
 * Created by MLRC-iOS-CI on 2017/6/12.
 */

public class AddressBean {

    private List<ProvincesBean> address;

    public List<ProvincesBean> getAddress() {
        return address;
    }

    public void setAddress(List<ProvincesBean> address) {
        this.address = address;
    }

    public static class ProvincesBean {
        /**
         * areaId : 330000
         * areaName : 浙江省
         * cities : [{"areaId":"330100","areaName":"杭州市","counties":[{"areaId":"330102","areaName":"上城区"},{"areaId":"330103","areaName":"下城区"},{"areaId":"330104","areaName":"江干区"},{"areaId":"330105","areaName":"拱墅区"},{"areaId":"330106","areaName":"西湖区"},{"areaId":"330108","areaName":"滨江区"},{"areaId":"330109","areaName":"萧山区"},{"areaId":"330110","areaName":"余杭区"},{"areaId":"330122","areaName":"桐庐县"},{"areaId":"330127","areaName":"淳安县"},{"areaId":"330182","areaName":"建德市"},{"areaId":"330183","areaName":"富阳市"},{"areaId":"330185","areaName":"临安市"}]},{"areaId":"330200","areaName":"宁波市","counties":[{"areaId":"330203","areaName":"海曙区"},{"areaId":"330204","areaName":"江东区"},{"areaId":"330205","areaName":"江北区"},{"areaId":"330206","areaName":"北仑区"},{"areaId":"330211","areaName":"镇海区"},{"areaId":"330212","areaName":"鄞州区"},{"areaId":"330225","areaName":"象山县"},{"areaId":"330226","areaName":"宁海县"},{"areaId":"330281","areaName":"余姚市"},{"areaId":"330282","areaName":"慈溪市"},{"areaId":"330283","areaName":"奉化市"}]},{"areaId":"330300","areaName":"温州市","counties":[{"areaId":"330302","areaName":"鹿城区"},{"areaId":"330303","areaName":"龙湾区"},{"areaId":"330304","areaName":"瓯海区"},{"areaId":"330322","areaName":"洞头县"},{"areaId":"330324","areaName":"永嘉县"},{"areaId":"330326","areaName":"平阳县"},{"areaId":"330327","areaName":"苍南县"},{"areaId":"330328","areaName":"文成县"},{"areaId":"330329","areaName":"泰顺县"},{"areaId":"330381","areaName":"瑞安市"},{"areaId":"330382","areaName":"乐清市"}]},{"areaId":"330400","areaName":"嘉兴市","counties":[{"areaId":"330402","areaName":"南湖区"},{"areaId":"330411","areaName":"秀洲区"},{"areaId":"330421","areaName":"嘉善县"},{"areaId":"330424","areaName":"海盐县"},{"areaId":"330481","areaName":"海宁市"},{"areaId":"330482","areaName":"平湖市"},{"areaId":"330483","areaName":"桐乡市"}]},{"areaId":"330500","areaName":"湖州市","counties":[{"areaId":"330502","areaName":"吴兴区"},{"areaId":"330503","areaName":"南浔区"},{"areaId":"330521","areaName":"德清县"},{"areaId":"330522","areaName":"长兴县"},{"areaId":"330523","areaName":"安吉县"}]},{"areaId":"330600","areaName":"绍兴市","counties":[{"areaId":"330602","areaName":"越城区"},{"areaId":"330621","areaName":"绍兴县"},{"areaId":"330624","areaName":"新昌县"},{"areaId":"330681","areaName":"诸暨市"},{"areaId":"330682","areaName":"上虞市"},{"areaId":"330683","areaName":"嵊州市"}]},{"areaId":"330700","areaName":"金华市","counties":[{"areaId":"330702","areaName":"婺城区"},{"areaId":"330703","areaName":"金东区"},{"areaId":"330723","areaName":"武义县"},{"areaId":"330726","areaName":"浦江县"},{"areaId":"330727","areaName":"磐安县"},{"areaId":"330781","areaName":"兰溪市"},{"areaId":"330782","areaName":"义乌市"},{"areaId":"330783","areaName":"东阳市"},{"areaId":"330784","areaName":"永康市"}]},{"areaId":"330800","areaName":"衢州市","counties":[{"areaId":"330802","areaName":"柯城区"},{"areaId":"330803","areaName":"衢江区"},{"areaId":"330822","areaName":"常山县"},{"areaId":"330824","areaName":"开化县"},{"areaId":"330825","areaName":"龙游县"},{"areaId":"330881","areaName":"江山市"}]},{"areaId":"330900","areaName":"舟山市","counties":[{"areaId":"330902","areaName":"定海区"},{"areaId":"330903","areaName":"普陀区"},{"areaId":"330921","areaName":"岱山县"},{"areaId":"330922","areaName":"嵊泗县"}]},{"areaId":"331000","areaName":"台州市","counties":[{"areaId":"331002","areaName":"椒江区"},{"areaId":"331003","areaName":"黄岩区"},{"areaId":"331004","areaName":"路桥区"},{"areaId":"331021","areaName":"玉环县"},{"areaId":"331022","areaName":"三门县"},{"areaId":"331023","areaName":"天台县"},{"areaId":"331024","areaName":"仙居县"},{"areaId":"331081","areaName":"温岭市"},{"areaId":"331082","areaName":"临海市"}]},{"areaId":"331100","areaName":"丽水市","counties":[{"areaId":"331102","areaName":"莲都区"},{"areaId":"331121","areaName":"青田县"},{"areaId":"331122","areaName":"缙云县"},{"areaId":"331123","areaName":"遂昌县"},{"areaId":"331124","areaName":"松阳县"},{"areaId":"331125","areaName":"云和县"},{"areaId":"331126","areaName":"庆元县"},{"areaId":"331127","areaName":"景宁畲族自治县"},{"areaId":"331181","areaName":"龙泉市"}]}]
         */

        private String areaId;
        private String areaName;
        private List<CitiesBean> cities;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public List<CitiesBean> getCities() {
            return cities;
        }

        public void setCities(List<CitiesBean> cities) {
            this.cities = cities;
        }

        public static class CitiesBean {
            /**
             * areaId : 330100
             * areaName : 杭州市
             * counties : [{"areaId":"330102","areaName":"上城区"},{"areaId":"330103","areaName":"下城区"},{"areaId":"330104","areaName":"江干区"},{"areaId":"330105","areaName":"拱墅区"},{"areaId":"330106","areaName":"西湖区"},{"areaId":"330108","areaName":"滨江区"},{"areaId":"330109","areaName":"萧山区"},{"areaId":"330110","areaName":"余杭区"},{"areaId":"330122","areaName":"桐庐县"},{"areaId":"330127","areaName":"淳安县"},{"areaId":"330182","areaName":"建德市"},{"areaId":"330183","areaName":"富阳市"},{"areaId":"330185","areaName":"临安市"}]
             */

            private String areaId;
            private String areaName;
            private List<CountiesBean> counties;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public List<CountiesBean> getCounties() {
                return counties;
            }

            public void setCounties(List<CountiesBean> counties) {
                this.counties = counties;
            }

            public static class CountiesBean {
                /**
                 * areaId : 330102
                 * areaName : 上城区
                 */

                private String areaId;
                private String areaName;

                public String getAreaId() {
                    return areaId;
                }

                public void setAreaId(String areaId) {
                    this.areaId = areaId;
                }

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }
            }
        }
    }
}
