package comn.example.yws.calculator;

import org.litepal.crud.DataSupport;

/**
 * 计算结果类,数据库表
 */

public class Result extends DataSupport{
    //计算结果
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
