package com.zr.demo.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {
    @Scheduled(cron = "0 */5 * * * ?") // 每fen调用一次
    public void runJobB() {
        System.err.println("【*** MyTaskB - 间隔调度 ***】"
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                        .format(new Date()));
    }
}