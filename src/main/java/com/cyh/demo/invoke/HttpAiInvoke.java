package com.cyh.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class HttpAiInvoke {

    private static final String URL =
            "https://llm-xq80lofbvw8sqjrx.cn-beijing.maas.aliyuncs.com/api/v1/services/aigc/multimodal-generation/generation";

    public static String callWithMessage() {
        JSONObject systemContent = new JSONObject().set("text", "You are a helpful assistant.");
        JSONObject systemMsg = new JSONObject()
                .set("role", "system")
                .set("content", new JSONArray().set(systemContent));

        JSONObject userContent = new JSONObject().set("text", "今天是几号？");
        JSONObject userMsg = new JSONObject()
                .set("role", "user")
                .set("content", new JSONArray().set(userContent));

        JSONObject body = new JSONObject()
                .set("model", "qwen3.8-max")
                .set("input", new JSONObject()
                        .set("messages", new JSONArray().set(systemMsg).set(userMsg)))
                .set("parameters", new JSONObject()
                        .set("result_format", "message"));

        try (HttpResponse response = HttpRequest.post(URL)
                .header("Authorization", "Bearer " + TestApiKey.API_KEY)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .timeout(60000)
                .execute()) {
            return response.body();
        }
    }

    public static void main(String[] args) {
        String result = callWithMessage();
        System.out.println(JSONUtil.toJsonStr(JSONUtil.parse(result)));
    }
}
