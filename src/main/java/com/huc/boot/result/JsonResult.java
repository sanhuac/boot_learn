package com.huc.boot.result;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/6 09:49
 * @Description:
 */
public class JsonResult {

    private String status = null;

    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
