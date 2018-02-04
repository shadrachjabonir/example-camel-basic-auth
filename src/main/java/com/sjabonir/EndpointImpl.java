package com.sjabonir;

import sun.misc.BASE64Decoder;

import javax.ws.rs.core.Response;
import java.io.IOException;

public class EndpointImpl implements Endpoint {

    @Override
    public Response getTest(String authString) {
        Response response;

        if (!isUserAuthenticated(authString)) {
            return Response.ok("{\"error\":\"User not authenticated\"}").status(Response.Status.OK).build();
        }
        response = Response.ok("{\"messages\":\"Hello world\"}").status(Response.Status.OK).build();
        return response;
    }

    private boolean isUserAuthenticated(String authString) {
        String decodedAuth = "";
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);

        /**
                  * here you include your logic to validate user authentication.
                  * it can be using ldap, or token exchange mechanism or your
                  * custom authentication mechanism.
                  */
        String[] res = decodedAuth.split(":");
        if(res[0].equals("user") && res[1].equals("password"))
            return true;
        else
            return false;
        // your validation code goes here....
    }
}
