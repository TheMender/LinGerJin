package pipeline;

import org.springframework.stereotype.Component;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/157:39 PM
 */
@Component
public class Validator extends NormalValve {
    @Override
    public FlowResult invoke(PipeLineContext pipeLineContext) {
        pipeLineContext.put("param", "1");
        return processContinue(pipeLineContext);
    }
}
