package com.demo;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: qdp-data-conversion
 * @Package: PACKAGE_NAME
 * @ClassName: com.demo.demo
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/5 15:57
 * @Version: 1.0
 */

public class demo {


    /**
     * 我家云API接口demo
     */
    //正式地址api.wojiacloud.com 测试地址 http://mhyy.kingdee.com

    public static final String api_address = "http://api.wojiayun.cn/";

//  public static final String api_address = "http://mhyy.kingdee.com";

    public static final String api_version = "V1.0";

    public static final String CHARACTER_ENCODING = "UTF-8";


    //测试
    public static void main(String[] args) throws Exception {
        // 在系统管理-应用管理创建
        String appKey = "t0rzzsmey5qrkfse";
        String appSecret = "d9q245ixo8fkhpnisk3ogrzx86dhoays";
        //毫秒
        long clientTime = System.currentTimeMillis();
        //测试ticket接口
        String ticket = ticket(appKey, appSecret, clientTime);
        System.out.println(ticket);
        String pid = "319c23c4c60e4def9959c776c32ca7f9";
        //测试access_token接口
        //1 住户  2 物业管家
        String type = "0";
        //用户账号
        String username = "17620324021";

        String access_token = access_token(ticket, username, type, pid);
        JSONObject obj = sendGetRequest(api_address+"/api/buildings/batchList?access_token="+access_token+"&pid="+pid);

        System.out.println(obj);

    }


    /**
     * 2 ticket接口 api/users/ticket   GET请求
     */

    public static String ticket(String appKey, String appSecret, long clientTime) throws Exception {

        /*

        参数	说明	类型	是否必须

        appKey	App Key	String	Y 我家云管理员获取

        clientTime	访问时间毫秒数	Int	Y在30分钟内有效

        version	客户端版本	String	Y V1.0

        signature	签名串	String	Y */

        //签名

        String signature = demo.signature(appKey, appSecret, clientTime, api_version);

        System.out.println(signature);


        String url = api_address + "/api/users/ticket?appKey=" + appKey + "&clientTime=" + clientTime + "&version=" + api_version + "&signature=" + signature;

        System.out.println(url);

        //发送请求

        JSONObject obj = sendGetRequest(url);

        System.out.println(obj);

        if (obj != null) {

            String status = obj.getString("result");

            if ("success".equals(status)) {

                //System.out.println( obj.get("data") );

                JSONObject data = obj.getJSONObject("data");

                return (String) data.get("ticket");
            }
        }
        return null;
    }


    /**
     * 2 授权接口 api/users/access_token   POST请求
     */
    public static String access_token(String ticket, String username, String type, String pid) throws Exception {
        String url = api_address + "/api/users/access_token";
        System.out.println(url);
        //建立一个NameValuePair数组，用于存储欲传递的参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        //添加参数
        params.add(new BasicNameValuePair("ticket", ticket));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("type", type));
        params.add(new BasicNameValuePair("pid", pid));
        //发送请求
        JSONObject obj = sendPostRequest(url, params);
        System.out.println(obj);
        if (obj != null) {
            String status = obj.getString("result");
            if ("success".equals(status)) {
                //System.out.println( obj.get("data") );
                JSONObject data = obj.getJSONObject("data");
                return (String) data.get("access_token");

            }

        }
        return null;

    }


//POST请求

    private static JSONObject sendPostRequest(String url, List<BasicNameValuePair> params) throws Exception {

        HttpPost post = new HttpPost(url);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, CHARACTER_ENCODING);

        post.setEntity(entity);

//		HttpClient client = new DefaultHttpClient(); //测试环境使用http

        HttpClient client = new SSLClient(); //生产环境请使用 https

        try {

            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                String responseStr = EntityUtils.toString(response.getEntity(), CHARACTER_ENCODING);

                return JSONObject.fromObject(responseStr);
            }

        } finally {

            client.getConnectionManager().shutdown();

        }

        return null;

    }

    //GET请求

    private static JSONObject sendGetRequest(String url) throws Exception {


        HttpGet post = new HttpGet(url);

//		HttpClient client = new DefaultHttpClient(); //测试环境使用http

        HttpClient client = new SSLClient();   //生产环境请使用 https

        try {

            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                String responseStr = EntityUtils.toString(response.getEntity(), CHARACTER_ENCODING);

                return JSONObject.fromObject(responseStr);


            }

        } finally {

            client.getConnectionManager().shutdown();

        }

        return null;

    }
    /**

     待加密串为该次请求中的appKey、clientTime、version，以&连接的字符串，按参数的字母先后顺序排序，再连接appSecret

     如:

     appKey=ap119jaz6b6te84v&clientTime=1465180217306&version=V1.0&yhegf6ehllfegayh3bem6l3gvswp2r50

     得到和字符串经MD5加密, 最后再进行SHA1加密，得到signature

     */

    public static String signature(String appKey,String appSecret,long clientTime,String version) throws Exception {

        String pathString = "appKey=" + appKey + "&clientTime=" + clientTime+ "&version=" + version + "&" + appSecret;
        // MD5加密
        String data = PwdMD5Util.getMD5(pathString);
        //SHA1加密
        String digest = new SHA1().getDigestOfString(data.getBytes());
        System.out.println("signature==============>"+digest);
        return digest;

    }

}


