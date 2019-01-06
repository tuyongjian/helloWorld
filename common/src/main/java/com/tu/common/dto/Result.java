package com.tu.common.dto;

/**
 * Created by tuyongjian on 2019/1/5.
 * 通用接口请求接口DTO
 */
public class Result {

    /**
     * 是否成功的标志
     */
    private boolean success;

    /**
     * 返回的信息
     */
    private String  message;

    /**
     * 返回的结果
     */
    private String result;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, String result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
