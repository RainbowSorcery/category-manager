package com.lyra.src;

import com.lyra.common.utils.UploadUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OSSTest {
    @Autowired
    private UploadUtils uploadUtils;

    @Test
    public void uploadTest() {
    }
}
