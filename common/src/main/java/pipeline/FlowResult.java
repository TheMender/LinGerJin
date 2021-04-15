package pipeline;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/157:40 PM
 */
public class FlowResult {

    String msg = "";
    private static final FlowResult flowResult = new FlowResult();

    public static FlowResult ok() {
        flowResult.msg = flowResult.msg.concat("ok");
        return flowResult;
    }

    public static FlowResult fail(String s) {
        flowResult.msg.concat(s);
        return flowResult;
    }

    @Override
    public String toString() {
        return "FlowResult{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
