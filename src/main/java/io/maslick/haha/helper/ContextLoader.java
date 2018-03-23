package io.maslick.haha.helper;

import java.io.IOException;
import java.io.InputStream;

public class ContextLoader implements IFileLoader{
    @Override
    public InputStream getStreamFromFile(String filename) throws IOException {
        return ClassLoader.getSystemResourceAsStream(filename);
    }
}
