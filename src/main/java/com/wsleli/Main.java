package com.wsleli;

import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String accessKey = "pa72m441hto6c7y7dtyssr3c78nloluu";
        String secretKey = "4midiaycqr1d32ritigsvwc0egjb47v8";
        YuCongMingClient client = new YuCongMingClient(accessKey, secretKey);
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1651468516836098050L);

        // 开始聊天
        Scanner sc = new Scanner(System.in);
        System.out.println("你好~ 输入exit退出聊天");
        while (true) {
            String message = sc.next();
            if ("exit".equals(message)) {
                System.out.println("拜拜~");
                return;
            }
            devChatRequest.setMessage(message);
            BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
            System.out.println(response.getData().getContent());
        }
    }
}