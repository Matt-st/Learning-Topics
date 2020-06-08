package functions.helper;

import com.google.cloud.functions.HttpResponse;

import java.io.*;
import java.util.*;

public class CustomResponse implements HttpResponse {

    public int statusCode = 0;
    public String statusMessage = null;
    public String contentType = null;
    public Map<String, List<String>> headers = null;

    @Override
    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @Override
    public void setStatusCode(int i, String s) {
        this.statusCode = i;
        this.statusMessage = s;
    }

    @Override
    public void setContentType(String s) {
        this.contentType = s;
    }

    @Override
    public Optional<String> getContentType() {
        return Optional.of(this.contentType);
    }

    @Override
    public void appendHeader(String s, String s1) {
        if(this.headers.containsKey(s)){
            List<String> list = this.headers.get(s);
            list.add(s1);
            this.headers.put(s,list);

        }else{
            this.headers.put(s, new ArrayList<>(Collections.singleton(s1)));
        }

    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return new BufferedOutputStream( new ByteArrayOutputStream());
    }

    @Override
    public BufferedWriter getWriter() throws IOException {
        return new BufferedWriter(new CharArrayWriter());
    }
}
