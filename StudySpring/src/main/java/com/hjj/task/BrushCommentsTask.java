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
    static String QUERY_URL = "host:comments";
    static String COMMENT_URL = "host:comment/article";
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
        while (query.get() < 10100) {
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
        return "cookie";//todo
    }
}
