package         com.demo;

import         java.io.UnsupportedEncodingException;
import         java.math.BigInteger;
import         java.security.MessageDigest;
import         java.security.NoSuchAlgorithmException;

/**
         *         Created         by         xuxiaoxing         on         2018/6/7.
         */
public         class         PwdMD5Util         {

                                    public         static         String         getMD5(String         str)                  {
                                                                        MessageDigest         md         =         null;
                                                                        try         {
                                                                                                            //         生成一个MD5加密计算摘要
                                                                                                            md         =         MessageDigest.getInstance("MD5");
                                                                                                            //         计算md5函数
                                                                                                            md.update(str.getBytes("GBK"));
                                                                        }catch         (NoSuchAlgorithmException         e)         {
                                                                                                            throw         new         RuntimeException(e.getMessage());
                                                                        }         catch         (UnsupportedEncodingException         e)         {
                                                                                                            throw         new         RuntimeException(e.getMessage());
                                                                        }
                                                                        //         digest()最后确定返回md5         hash值，返回值为8位字符串。因为md5         hash值是16位的hex值，实际上就是8位的字符
                                                                        //         BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                                                                        return         new         BigInteger(1,         md.digest()).toString(16);
                                    }


                                    public         static         void         main(String[]         args)         throws         Exception{
                                                                        System.out.println(PwdMD5Util.getMD5("123456"));

                                    }

}
