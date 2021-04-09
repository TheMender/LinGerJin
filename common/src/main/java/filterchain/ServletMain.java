package filterchain;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ServletMain {

    public static void main(String[] args) {

        Request request = new Request();
        Response response = new Response();

        Fliterchain fliterchain = new Fliterchain();
        fliterchain.addFilter(new HtmlFilter()).addFilter(new AspFilter()).addFilter(new JavaFilter());
        fliterchain.doFilter(request,response,fliterchain);
        System.out.println("requestID="+request.requestID);
        System.out.println("responseId="+response.responseId);
    }


}

interface Filter {
    public void doFilter(Request request, Response response,Fliterchain fliterchain);

}

class Request {
    String requestID="";

    public void setRequestID(String classNmae) {
        this.requestID = this.requestID.concat("--"+classNmae);
    }
}

class Response {
    String responseId="";

    public void setResponseId(String classNmae) {
        this.responseId = this.responseId.concat("--"+classNmae);
    }
}

class HtmlFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response,Fliterchain fliterchain) {
        request.setRequestID("HtmlFilter");
        fliterchain.doFilter(request,response,fliterchain);
        response.setResponseId("HtmlFilter");
    }
}

class AspFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response,Fliterchain fliterchain) {
        request.setRequestID("AspFilter");
        fliterchain.doFilter(request,response,fliterchain);
        response.setResponseId("AspFilter");
    }
}

class JavaFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response,Fliterchain fliterchain) {
        request.setRequestID("JavaFilter");
        fliterchain.doFilter(request,response,fliterchain);
        response.setResponseId("JavaFilter");
    }
}

class Fliterchain implements Filter {
    private List<Filter> filters=new ArrayList<>();
    private ListIterator<Filter> iter;
    public Fliterchain addFilter(Filter filter) {
        this.filters.add(filter);
        this.iter=this.filters.listIterator();
        return this;
    }

    @Override
    public void doFilter(Request request, Response response,Fliterchain fliterchain) {
        if (!iter.hasNext()) {
            request.setRequestID("request结束");
            response.setResponseId("response结束");
        } else {
            Filter f = iter.next();
            f.doFilter(request, response,fliterchain);
        }
    }
}