package jp.himeji_cs.hello_ap.process_target;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public interface MyNonTarget2 {

    @GET
    Response get();

}
