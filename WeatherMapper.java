package com.company;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WeatherMapper extends Mapper<LongWritable, Text, Text, Text> {
    //2006-08-15 08:00:00.000 +0200,Partly Cloudy,rain,18.65555555555555,18.65555555555555,0.85,7.3738,223.0,10.3523,0.0,1014.13,Partly cloudy until evening.
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split(",");
        String year = words[0].split("-")[0];
        String temp = words[3];

        context.write(new Text(year), new Text(temp));
    }
}
