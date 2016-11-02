package com.example.testquerymap;

import java.util.List;

/**
 * Created by wushufeng on 2016/11/3.
 */

public class AirBean {

    /**
     * msg : success
     * result : [{"aqi":290,"city":"合肥","district":"合肥","fetureData":[{"aqi":214,"date":"2015-12-24","quality":"重度污染"},{"aqi":146,"date":"2015-12-25","quality":"轻度污染"},{"aqi":176,"date":"2015-12-26","quality":"中度污染"},{"aqi":173,"date":"2015-12-27","quality":"中度污染"},{"aqi":171,"date":"2015-12-28","quality":"中度污染"},{"aqi":163,"date":"2015-12-29","quality":"中度污染"}],"hourData":[{"aqi":217,"dateTime":"2015-12-2314:00:00"},{"aqi":250,"dateTime":"2015-12-2313:00:00"},{"aqi":273,"dateTime":"2015-12-2312:00:00"},{"aqi":275,"dateTime":"2015-12-2311:00:00"},{"aqi":285,"dateTime":"2015-12-2310:00:00"},{"aqi":328,"dateTime":"2015-12-2309:00:00"},{"aqi":348,"dateTime":"2015-12-2308:00:00"},{"aqi":355,"dateTime":"2015-12-2307:00:00"},{"aqi":356,"dateTime":"2015-12-2306:00:00"},{"aqi":354,"dateTime":"2015-12-2305:00:00"},{"aqi":348,"dateTime":"2015-12-2304:00:00"},{"aqi":321,"dateTime":"2015-12-2303:00:00"},{"aqi":300,"dateTime":"2015-12-2302:00:00"},{"aqi":316,"dateTime":"2015-12-2301:00:00"},{"aqi":342,"dateTime":"2015-12-2300:00:00"},{"aqi":373,"dateTime":"2015-12-2223:00:00"},{"aqi":399,"dateTime":"2015-12-2222:00:00"},{"aqi":394,"dateTime":"2015-12-2221:00:00"},{"aqi":401,"dateTime":"2015-12-2220:00:00"},{"aqi":382,"dateTime":"2015-12-2219:00:00"},{"aqi":357,"dateTime":"2015-12-2218:00:00"},{"aqi":331,"dateTime":"2015-12-2217:00:00"},{"aqi":332,"dateTime":"2015-12-2216:00:00"},{"aqi":330,"dateTime":"2015-12-2215:00:00"}],"no2":55,"pm25":167,"province":"安徽","quality":"严重污染","so2":19,"updateTime":"2015-12-2315:00:00"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    /**
     * aqi : 290
     * city : 合肥
     * district : 合肥
     * fetureData : [{"aqi":214,"date":"2015-12-24","quality":"重度污染"},{"aqi":146,"date":"2015-12-25","quality":"轻度污染"},{"aqi":176,"date":"2015-12-26","quality":"中度污染"},{"aqi":173,"date":"2015-12-27","quality":"中度污染"},{"aqi":171,"date":"2015-12-28","quality":"中度污染"},{"aqi":163,"date":"2015-12-29","quality":"中度污染"}]
     * hourData : [{"aqi":217,"dateTime":"2015-12-2314:00:00"},{"aqi":250,"dateTime":"2015-12-2313:00:00"},{"aqi":273,"dateTime":"2015-12-2312:00:00"},{"aqi":275,"dateTime":"2015-12-2311:00:00"},{"aqi":285,"dateTime":"2015-12-2310:00:00"},{"aqi":328,"dateTime":"2015-12-2309:00:00"},{"aqi":348,"dateTime":"2015-12-2308:00:00"},{"aqi":355,"dateTime":"2015-12-2307:00:00"},{"aqi":356,"dateTime":"2015-12-2306:00:00"},{"aqi":354,"dateTime":"2015-12-2305:00:00"},{"aqi":348,"dateTime":"2015-12-2304:00:00"},{"aqi":321,"dateTime":"2015-12-2303:00:00"},{"aqi":300,"dateTime":"2015-12-2302:00:00"},{"aqi":316,"dateTime":"2015-12-2301:00:00"},{"aqi":342,"dateTime":"2015-12-2300:00:00"},{"aqi":373,"dateTime":"2015-12-2223:00:00"},{"aqi":399,"dateTime":"2015-12-2222:00:00"},{"aqi":394,"dateTime":"2015-12-2221:00:00"},{"aqi":401,"dateTime":"2015-12-2220:00:00"},{"aqi":382,"dateTime":"2015-12-2219:00:00"},{"aqi":357,"dateTime":"2015-12-2218:00:00"},{"aqi":331,"dateTime":"2015-12-2217:00:00"},{"aqi":332,"dateTime":"2015-12-2216:00:00"},{"aqi":330,"dateTime":"2015-12-2215:00:00"}]
     * no2 : 55
     * pm25 : 167
     * province : 安徽
     * quality : 严重污染
     * so2 : 19
     * updateTime : 2015-12-2315:00:00
     */

    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int aqi;
        private String city;
        private String district;
        private int no2;
        private int pm25;
        private String province;
        private String quality;
        private int so2;
        private String updateTime;
        /**
         * aqi : 214
         * date : 2015-12-24
         * quality : 重度污染
         */

        private List<FetureDataBean> fetureData;
        /**
         * aqi : 217
         * dateTime : 2015-12-2314:00:00
         */

        private List<HourDataBean> hourData;

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public List<FetureDataBean> getFetureData() {
            return fetureData;
        }

        public void setFetureData(List<FetureDataBean> fetureData) {
            this.fetureData = fetureData;
        }

        public List<HourDataBean> getHourData() {
            return hourData;
        }

        public void setHourData(List<HourDataBean> hourData) {
            this.hourData = hourData;
        }

        public static class FetureDataBean {
            private int aqi;
            private String date;
            private String quality;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }
        }

        public static class HourDataBean {
            private int aqi;
            private String dateTime;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }
        }
    }
}
