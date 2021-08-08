package com.hjj.task;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjj24
 * @date 2021-7-26 17:09
 **/
public class BrushCommentsTask extends Thread {

    static AtomicInteger query = new AtomicInteger(0);
    static String QUERY_URL = "http://meizai.midea.com/v1/bbs/core/article/comments";
    static String COMMENT_URL = "http://meizai.midea.com/v1/bbs/core/comment/article";
    static int sleep = 1000;

    public static void main(String[] args) {
        BrushCommentsTask myThread = new BrushCommentsTask();
        myThread.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        BlockingQueue<Runnable> myTasks = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor my = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, myTasks);
        my.execute(new TestThread());
        while (query.get()<10100) {
            Thread.sleep(sleep);
            // 创建一个request对象
            HttpEntity httpEntity = new StringEntity("{\n"
                    + "    \"articleId\": \"321\",\n"
                    + "    \"index\": \"1\",\n"
                    + "    \"pageSize\": \"1\"\n"
                    + "}\n");
            HttpUriRequest queryReq = RequestBuilder.post(QUERY_URL).addHeader("Content-Type", "application/json")
                    .setEntity(httpEntity).build();
            QueryResp queryResp = JSON.parseObject(execute(queryReq), QueryResp.class);
            if (query.get() == 0) {
                query.set(queryResp.getData().getTotal());
                continue;
            }
            if (query.get() == queryResp.getData().getTotal()) {
                continue;
            }
            query.set(queryResp.getData().getTotal());
            for (int i = 0; i < 6; i++) {
                Runnable myTask = new MyTask();
                myTasks.add(myTask);
            }
            Thread.sleep(sleep * 2);
        }
    }

    public static class MyTask extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            HttpEntity httpEntity = new StringEntity("{\n"
                    + "    \"id\": 321,\n"
                    + "    \"type\": 1,\n"
                    + "    \"anonymous\": 0,\n"
                    + "    \"content\": \"%3Cp%3E%3Cspan%20style%3D%22color%3A%20rgb(26%2C%2026%2C%2026)%3B%20font-family%3A%20%26quot%3BHelvetica%20Neue%26quot%3B%2C%20Helvetica%2C%20%26quot%3BPingFang%20SC%26quot%3B%2C%20%26quot%3BHiragino%20Sans%20GB%26quot%3B%2C%20%26quot%3BMicrosoft%20YaHei%26quot%3B%2C%20%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91%2C%20Arial%2C%20sans-serif%3B%20font-size%3A%2015px%3B%20background-color%3A%20rgb(255%2C%20255%2C%20255)%3B%22%3E%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86Aop%EF%BC%8Cyyds%3C%2Fspan%3E%3C%2Fp%3E\"\n"
                    + "}");
            HttpUriRequest queryReq = RequestBuilder.post(COMMENT_URL).addHeader("Content-Type", "application/json")
                    .addHeader("Cookie", getCookie())
                    .setEntity(httpEntity).build();
            execute(queryReq);
            query.addAndGet(1);
        }
    }

    public static String execute(HttpUriRequest request) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            System.out.println(request);
            CloseableHttpResponse resp = client.execute(request);
            String response = EntityUtils.toString(resp.getEntity());
            System.out.println(response);
            HttpClientUtils.closeQuietly(resp);
            return response;
        } catch (Exception e) {
            return "";
        } finally {
            HttpClientUtils.closeQuietly(client);
        }
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println("------------线程池启动-------------------------");
        }
    }

    @Data
    public static class QueryResp {

        private Da data;

        @Data
        public static class Da {
            Integer total;
        }
    }

    public static String getCookie() {
        return "mip_curr_lang=zh-CN; mip_lang=zh; UM_distinctid=179cb68a3e3391-071fcabe1b4c99-b79183d-100200-179cb68a3e43d; oam_locale=zh; user_info=%7B%22fdPositiontype%22%3A%221%22%2C%22id%22%3A%22u_12100962073%22%2C%22parentId%22%3A%22d_1272745717936418816%22%2C%22name%22%3A%22%E9%BB%84%E5%AE%B6%E6%9D%B0%22%2C%22fdLangType%22%3A%22zh-CN%22%2C%22loginName%22%3A%22huangjj24%22%2C%22fdTimeZone%22%3A%22Asia%2FShanghai%22%2C%22fdDepartmentName%22%3A%22%E7%BE%8E%E7%9A%84_%E7%BE%8E%E7%9A%84%E9%9B%86%E5%9B%A2_%E9%9B%86%E5%9B%A2%E8%81%8C%E8%83%BD_IT_%E8%90%A5%E9%94%80%E7%B3%BB%E7%BB%9F_%E8%90%A5%E9%94%80%E6%8A%80%E6%9C%AF%E5%B9%B3%E5%8F%B0%22%2C%22fdMobile%22%3A%2218860873135%22%2C%22fdMailSystem%22%3A%22coremail%22%2C%22shiroid%22%3Anull%7D; MAS_TGC=eyJhbGciOiJIUzUxMiJ9.WlhsS05tRllRV2xQYVVwRlVsVlphVXhEU21oaVIyTnBUMmxLYTJGWVNXbE1RMHBzWW0xTmFVOXBTa0pOVkVrMFVUQktSRXhWYUZSTmFsVXlTVzR3TGk1cWRYRldXR0pUYjNoTFpuWkJjMlZGVEVGUmVFRkJMa0l0UVhVeFVVSlhkR2hMUVV4WWVUZ3diRXRuVTBWNmExODFkWFZhU1dSaVFUaDFabGw1TlMxMk5uRnpRWEI0UVRKS1VtWm9iMngxZVdGc2VsZGZjbWRLV25kbVVtaFlaMVpXUTFGelRTMVViMmhEYWtGNE5WcEJhbmRUYVd0QmRUTnJibmh2YzNsRGFVNWhjWFZZYkZScU9VRm9kVWM1VWxJeE5ubEVSbXhGVGxGMVJHRnRSV2hMTldoblJWVmlVRnA2VkhKMlluTkdRMDV2ZGxWWmQzRkxaVGRYVDJSblpXVldkakZwZW10NGVETnRlbWxIV1hjNWFtRTNaMWN3VW14SVFsVnVaa05EUkhaRE1GVXdPVmhTTjJRMVZWaHZaWHBmYVRVeVJUWjZYM3AwTkdvd1lraExORE5KYURoS1RrWXhjSFpvUjFKRFNFRnpSME53VjJVdWQyMXlNR1pOU1VSWWRGaG1RVEpVWDFGSVNEZENkdz09.C7WOvxDgwvu2lbCdIMmDVaD1i_zr9EKb_xl5JXJBbcyMIXpWVgtr4AnpkGzcrmCp1jUbu3v7Vi5t9oN-8p6vEA; midea_sso_token=PR%2BS8v02QmnN6qiSGOKKMRDPnsWYZFAKa10vonpy3u2%2FYe70p2KIbx%2BRC1ihJ2T7; OAM_ID=VERSION_4~HGg3Mv6nPiXbFqRqtCOcyA==~nHD8bUygi6KQqlEaoN7YjKVGIRlEFO9wpIZizGQcwheLhnXSd4TfAPTzmty6g6WAKE1125dyTtlx1lbYRBBaZsWhb+NbiHqecbGVRSQ0wGoUX82DwFCS0OLmLXP0+GUVHAM75FVIYXFEpeLNTLzIhcGcI+kCnnaTpDrXGWnYIp6zlcWMwf7vI/EaiOHF7h7uAMHCHHOAwPBaGjzDFh2IystYy8moTwI/lwGiWN2KkPHnTkGUDEpgZpymsBRZWv82XCEqvOe1i4ijdqW0+Xt7Iw==; apmUser=huangjj24; IDAAS_USER_INFO=%7B%22userId%22%3A%22MC943422261%22%7D; BBSID=C583D5E9E9F84A9F849D3556E48F5ABB";
    }
}
