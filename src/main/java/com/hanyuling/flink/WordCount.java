package com.hanyuling.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WordCount {
    public static void main(String[] args) throws Exception {
        //  获取运行环境
//        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 通过socket获取源数据
//        DataSet<String> text = env.fromElements(
//                "to be or not to be,--that is a question--",
//                "hello everyone, my name is Lileilei",
//                "Fine,thank you and you?");
        DataStreamSource<String> ds = env.socketTextStream("127.0.0.1", 9898);
//        DataSet<Tuple2<String,Integer>> counts = text.flatMap(new LineSplitter()).groupBy(0).sum(1);
        DataStream<Tuple2<String, Integer>> sum = ds.flatMap(new LineSplitter()).keyBy(new KeySelector<Tuple2<String, Integer>, Object>() {

            @Override
            public Object getKey(Tuple2<String, Integer> value) throws Exception {
                return value.f0;
            }
        }).sum(1);
        sum.print();
        env.execute("streaming word count");
    }

    static class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] tokens = s.toLowerCase().split("\\W+");
            for (String token : tokens) {
                if (token.length() > 0) {
                    collector.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }
}
