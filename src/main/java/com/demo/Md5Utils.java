package         com.demo;

import         org.springframework.beans.factory.annotation.Value;

import         java.security.MessageDigest;
import         java.util.Date;

/**
         *         company:北京千丁互联科技有限公司
         *
         *         @author:guojianzhu         date:18/5/9.
         */
public         class         Md5Utils         {

                                    @Value("${app_key_prefix}")
                                    public         static         String         app_key_prefix;

                                    private         static         final         String         hexDigits[]         =         {"0",         "1",         "2",         "3",         "4",         "5",
                                                                                                            "6",         "7",         "8",         "9",         "a",         "b",         "c",         "d",         "e",         "f"};

                                    /**
                                             *         @Description:加密-32位大写
                                             *         @author:liuyc
                                             *         @time:2016年5月23日         上午11:15:33
                                             */
                                    public         static         String         encrypt32(String         encryptStr)         {
                                                                        Date         date         =         new         Date();
                                                                        encryptStr         =         app_key_prefix         +         encryptStr         +         date.getTime();
                                                                        MessageDigest         md5;
                                                                        try         {
                                                                                                            md5         =         MessageDigest.getInstance("MD5");
                                                                                                            byte[]         md5Bytes         =         md5.digest(encryptStr.getBytes());
                                                                                                            StringBuffer         hexValue         =         new         StringBuffer();
                                                                                                            for         (int         i         =         0;         i         <         md5Bytes.length;         i++)         {
                                                                                                                                                int         val         =         ((int)         md5Bytes[i])         &         0xff;
                                                                                                                                                if         (val         <         16)         {
                                                                                                                                                                                    hexValue.append("0");
                                                                                                                                                }
                                                                                                                                                hexValue.append(Integer.toHexString(val));
                                                                                                            }
                                                                                                            encryptStr         =         hexValue.toString().toUpperCase();
                                                                        }         catch         (Exception         e)         {
                                                                                                            throw         new         RuntimeException(e);
                                                                        }
                                                                        return         encryptStr;
                                    }

                                    /**
                                             *         @Description:加密-16位小写
                                             *         @author:liuyc
                                             *         @time:2016年5月23日         上午11:15:33
                                             */
                                    public         static         String         encrypt16(String         encryptStr)         {
                                                                        Date         date         =         new         Date();
                                                                        return         encrypt32(app_key_prefix         +         encryptStr         +         date.getTime()).substring(8,         24);
                                    }

                                    public         static         String         MD5Encode(String         origin,         String         charsetname)         {
                                                                        String         resultString         =         null;
                                                                        try         {
                                                                                                            resultString         =         new         String(origin);
                                                                                                            MessageDigest         md         =         MessageDigest.getInstance("MD5");
                                                                                                            if         (charsetname         ==         null         ||         "".equals(charsetname))         {
                                                                                                                                                resultString         =         byteArrayToHexString(md.digest(resultString
                                                                                                                                                                                                                        .getBytes()));
                                                                                                            }         else         {
                                                                                                                                                resultString         =         byteArrayToHexString(md.digest(resultString
                                                                                                                                                                                                                        .getBytes(charsetname)));
                                                                                                            }
                                                                        }         catch         (Exception         exception)         {
                                                                        }
                                                                        return         resultString;
                                    }

                                    private         static         String         byteArrayToHexString(byte         b[])         {
                                                                        StringBuffer         resultSb         =         new         StringBuffer();
                                                                        for         (int         i         =         0;         i         <         b.length;         i++)
                                                                                                            resultSb.append(byteToHexString(b[i]));

                                                                        return         resultSb.toString();
                                    }

                                    private         static         String         byteToHexString(byte         b)         {
                                                                        int         n         =         b;
                                                                        if         (n         <         0)         {
                                                                                                            n         +=         256;
                                                                        }
                                                                        int         d1         =         n         /         16;
                                                                        int         d2         =         n         %         16;
                                                                        return         hexDigits[d1]         +         hexDigits[d2];
                                    }


                                    public         static         void         main(String[]         args)         {
                                                                        String         encryptStr         =         "2018030819214712701";

                                                                        System.out.println(Md5Utils.encrypt16(encryptStr));
                                                                        System.out.println(Md5Utils.encrypt32(encryptStr));
                                    }

}
