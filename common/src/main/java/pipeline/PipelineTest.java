package pipeline;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/157:44 PM
 */
public class PipelineTest {

//    @Autowired
//    private NormalPipeLine normalPipeLine;
//    @Autowired
//    private Validator validator;
//    @Autowired
//    private Processor processor;


    public static void main(String[] args) {
        NormalPipeLine normalPipeLine = new NormalPipeLine();
        Validator validator = new Validator();

        // 定义上下文
        PipeLineContext pipeLineContext = new PipeLineContext(0);
        pipeLineContext.put("index", "0");
        // 增加阀门
        normalPipeLine.addValve(validator); // 参数校验阀门
//        normalPipeLine.addValve(orderPreviewValidator); // 业务校验阀门
//        normalPipeLine.addValve(processor); // 业务处理阀门
        // 管道执行
        FlowResult flowResult = normalPipeLine.start(pipeLineContext);
        System.out.println(flowResult.toString());
    }
}
