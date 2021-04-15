//package pipeline;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * Title:
// * Desc:
// *
// * @author: linyongchao
// * Date: 2021/4/157:40 PM
// */
//@Slf4j
//@Aspect
//@Component
//public class PipeLineAspect {
//    /**
//     * 定义阀门invoke切点
//     */
//    @Pointcut(value = "this(com.nooice.order.common.pipeline.Valve) " +
//            "&& execution(* invoke(com.nooice.order.common.pipeline.model.PipeLineContext)) && args((pipeLineContext))",
//            argNames = "pipeLineContext")
//    public void valveInvokeCutOffPoint(PipeLineContext pipeLineContext) {
//    }
//
//    @Before(value = "valveInvokeCutOffPoint(pipeLineContext)", argNames = "point,pipeLineContext")
//    public void doBefore(JoinPoint point, PipeLineContext pipeLineContext) {
//        int currentIndex = pipeLineContext.getAndIncrement();
//        String className = point.getTarget().getClass().getName();
//        log.info("管道前置通知-{}号阀门({})进入执行, pipeLineContext={}", currentIndex, className, pipeLineContext.toString());
//    }
//}
