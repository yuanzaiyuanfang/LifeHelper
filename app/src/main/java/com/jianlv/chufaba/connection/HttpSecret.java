package com.jianlv.chufaba.connection;
//package com.yzyfdf.lifehelper.app;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public  class HttpSecret
{
    static
    {
        System.loadLibrary("ndk_secret");
    }

    public native String getSecret(HttpGetSecret paramHttpGetSecret);

    public native String getSecret2(HttpGetSecret paramHttpGetSecret);

    public native String getSecret3(HttpGetSecret paramHttpGetSecret);


    public static class HttpGetSecret
    {
        private String secret1;
        private String secret10;
        private String secret11;
        private String secret12;
        private String secret13;
        private String secret14;
        private String secret15;
        private String secret16;
        private String secret17;
        private String secret2;
        private String secret3;
        private String secret4;
        private String secret5;
        private String secret6;
        private String secret7;
        private String secret8;
        private String secret9;

        public String getSecret1()
        {
            return this.secret1;
        }

        public String getSecret10()
        {
            return this.secret10;
        }

        public String getSecret11()
        {
            return this.secret11;
        }

        public String getSecret12()
        {
            return this.secret12;
        }

        public String getSecret13()
        {
            return this.secret13;
        }

        public String getSecret14()
        {
            return this.secret14;
        }

        public String getSecret15()
        {
            return this.secret15;
        }

        public String getSecret16()
        {
            return this.secret16;
        }

        public String getSecret17()
        {
            return this.secret17;
        }

        public String getSecret2()
        {
            return this.secret2;
        }

        public String getSecret3()
        {
            return this.secret3;
        }

        public String getSecret4()
        {
            return this.secret4;
        }

        public String getSecret5()
        {
            return this.secret5;
        }

        public String getSecret6()
        {
            return this.secret6;
        }

        public String getSecret7()
        {
            return this.secret7;
        }

        public String getSecret8()
        {
            return this.secret8;
        }

        public String getSecret9()
        {
            return this.secret9;
        }

        public void setSecret1(String paramString)
        {
            this.secret1 = paramString;
        }

        public void setSecret10(String paramString)
        {
            this.secret10 = paramString;
        }

        public void setSecret11(String paramString)
        {
            this.secret11 = paramString;
        }

        public void setSecret12(String paramString)
        {
            this.secret12 = paramString;
        }

        public void setSecret13(String paramString)
        {
            this.secret13 = paramString;
        }

        public void setSecret14(String paramString)
        {
            this.secret14 = paramString;
        }

        public void setSecret15(String paramString)
        {
            this.secret15 = paramString;
        }

        public void setSecret16(String paramString)
        {
            this.secret16 = paramString;
        }

        public void setSecret17(String paramString)
        {
            this.secret17 = paramString;
        }

        public void setSecret2(String paramString)
        {
            this.secret2 = paramString;
        }

        public void setSecret3(String paramString)
        {
            this.secret3 = paramString;
        }

        public void setSecret4(String paramString)
        {
            this.secret4 = paramString;
        }

        public void setSecret5(String paramString)
        {
            this.secret5 = paramString;
        }

        public void setSecret6(String paramString)
        {
            this.secret6 = paramString;
        }

        public void setSecret7(String paramString)
        {
            this.secret7 = paramString;
        }

        public void setSecret8(String paramString)
        {
            this.secret8 = paramString;
        }

        public void setSecret9(String paramString)
        {
            this.secret9 = paramString;
        }
    }
}
