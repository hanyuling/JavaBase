package com.hanyuling.algorithm.string;

import sun.misc.Unsafe;

import java.io.*;
import java.nio.ByteBuffer;

public class LineNumberReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/hanyuling/Documents/IdeaProjects/JavaBase/src/main/java/com/hanyuling/algorithm/string/LineNumberReaderTest.java");
        FileReader fr = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fr);
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            int lineNumber = reader.getLineNumber();
            if (lineNumber % 10 == 0) {
                reader.mark(lineNumber - 10);
                reader.reset();
            }
        }
        ByteBuffer.allocateDirect(10);
        Unsafe unsafe = Unsafe.getUnsafe();
    }
}
