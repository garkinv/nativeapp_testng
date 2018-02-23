package core.data.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.data.models.TestData;

import java.io.IOException;

import static core.constants.Constants.Configuration.TEST_SERVER;
import static core.constants.Constants.DataServers.*;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static org.springframework.util.ResourceUtils.getFile;

public class TestDataReader {
    public TestData testData;

    public TestDataReader() {
        try {
            switch (getProperty(TEST_SERVER).toLowerCase()) {
                case SIT: {
                    testData = new ObjectMapper().readValue(getFile("classpath:data/"
                            + SIT + ".json"), TestData.class);
                    break;
                }
                case SIT_2: {
                    testData = new ObjectMapper().readValue(getFile("classpath:data/"
                            + SIT_2 + ".json"), TestData.class);
                    break;
                }
                case ZONE: {
                    testData = new ObjectMapper().readValue(getFile("classpath:data/"
                            + ZONE + ".json"), TestData.class);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(format("Illegal [%s] property specified.\n" +
                                    "SIT, SIT2 and ZONE only supported, specified platform: [%s]",
                            TEST_SERVER, getProperty(TEST_SERVER)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}