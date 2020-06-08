package functions;

import com.google.cloud.functions.HttpRequest;
import functions.helper.CustomRequest;
import functions.helper.CustomResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class HelloWorldTest {

    @DisplayName("Test hello world functionality")
    @Test
    void testHelloWorld() throws Exception {

        CustomRequest req = new CustomRequest();
        CustomResponse res = new CustomResponse();

        HelloWorld hw = new HelloWorld();
        hw.service(req, res);

    }
}
