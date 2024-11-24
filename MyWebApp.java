package shadenade62.http.server;

import java.io.IOException;
import java.io.OutputStream;

public interface MyWebApp {
    void execute(Request request, OutputStream output) throws IOException;
}
