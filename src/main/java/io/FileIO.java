package io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

public class FileIO {

    @Test
    public void fileDir() {
        File file = new File("/home/ming/Documents/Books");
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/text.txt");
        System.out.println(resourceAsStream);

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().equals("2015131531.txt")) {
                file1.delete();
            }
        }
    }

    @Test
    public void testSwitch(){
    }


}
