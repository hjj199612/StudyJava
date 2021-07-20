package src.functionCoding;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo {
    /**
     * 需求描述：电商订单数据处理，根据下⾯的list1和list2 各10个订单
     * 统计出同时被两个⼈购买的商品列表(交集)
     * 统计出两个⼈购买商品的差集
     * 统计出全部被购买商品的去重并集
     * 统计两个⼈的分别购买订单的平均价格
     * 统计两个⼈的分别购买订单的总价格
     */
    public static void main(String[] args) throws InterruptedException {
        //总价 35
        List<VideoOrder> videoOrders1 = Arrays.asList(
                new VideoOrder("20190242812", "springboot教程", 3),
                new VideoOrder("20194350812", "微服务SpringCloud", 5),
                new VideoOrder("20190814232", "Redis教程", 9),
                new VideoOrder("20190523812", "⽹⻚开发教程", 9),
                new VideoOrder("201932324", "百万并发实战Netty", 9));
        //总价 54
        List<VideoOrder> videoOrders2 = Arrays.asList(
                new VideoOrder("2019024285312", "springboot教程", 3),
                new VideoOrder("2019081453232", "Redis教程", 9),
                new VideoOrder("20190522338312", "⽹⻚开发教程", 9),
                new VideoOrder("2019435230812", "Jmeter压⼒测试", 5),
                new VideoOrder("2019323542411", "Git+Jenkins持续集成", 7),
                new VideoOrder("2019323542424", "Idea全套教程", 21));
        //统计出同时被两个⼈购买的商品列表(交集)
        List<String> result1 = videoOrders1.stream().filter(e1 ->
                videoOrders2.stream().anyMatch(e2 -> e2.getTitle().equals(e1.getTitle())))
                .map(VideoOrder::getTitle).collect(Collectors.toList());
        System.out.println(result1.stream().collect(Collectors.joining("||", "[", "]")));
        //统计出两个⼈购买商品的差集
        List<String> result2 = Stream.concat(videoOrders1.stream().filter(e1 -> videoOrders2.stream().noneMatch(e2 -> e2.getTitle().equals(e1.getTitle()))),
                videoOrders2.stream().filter(e1 -> videoOrders1.stream().noneMatch(e2 -> e2.getTitle().equals(e1.getTitle()))))
                .map(VideoOrder::getTitle).collect(Collectors.toList());
        System.out.println(result2.stream().collect(Collectors.joining("||", "[", "]")));
        // 统计出全部被购买商品的去重并集
        List<String> result3 = Stream.concat(videoOrders1.stream(), videoOrders2.stream()).map(VideoOrder::getTitle).distinct().collect(Collectors.toList());
        System.out.println(result3.stream().collect(Collectors.joining("||", "[", "]")));
        //统计两个⼈的分别购买订单的平均价格
        DoubleSummaryStatistics collect1 = videoOrders1.parallelStream().collect(Collectors.summarizingDouble(VideoOrder::getMoney));
        System.out.println(collect1.getAverage());
        DoubleSummaryStatistics collect2 = videoOrders2.parallelStream().collect(Collectors.summarizingDouble(VideoOrder::getMoney));
        System.out.println(collect2.getAverage());
        //统计两个⼈的分别购买订单的总价格
        System.out.println(collect1.getSum());
        System.out.println(collect2.getSum());


    }

    public static class VideoOrder {
        private String tradeNo;
        private int money;
        private String title;

        public VideoOrder(String tradeNo, String title, int money) {
            this.tradeNo = tradeNo;
            this.title = title;
            this.money = money;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
