package pipeline;

/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/157:38 PM
 */
public class NormalValve implements Valve {
    protected Valve next = null;

    @Override
    public Valve getNext() {
        return next;
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }

    @Override
    public FlowResult invoke(PipeLineContext pipeLineContext) {
        return processContinue(pipeLineContext);
    }

    protected FlowResult processContinue(PipeLineContext pipeLineContext) {
        return next == null ? FlowResult.ok() : getNext().invoke(pipeLineContext);
    }
}
