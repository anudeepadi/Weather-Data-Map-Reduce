package com.company;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WeatherReducer extends Reducer<Text, Text, Text, Text> {
    // 2006, <16.016666666666666, 17.144444444444446, 17.800000000000004, 17.333333333333332>

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        double max = 0.0;
        for(Text t : values){
            String[] temp = t.toString().split(",");
            String s = temp[0];
            double sum = Double.parseDouble(s);

            if(sum > max){
                max = sum;
            }
        }
        context.write(key, new Text(String.valueOf(max)));
    }
}
