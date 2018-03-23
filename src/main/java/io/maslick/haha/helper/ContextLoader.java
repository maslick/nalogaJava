package io.maslick.haha.helper;

import java.io.InputStream;

public class ContextLoader implements IFileLoader{
    @Override
    public InputStream getStreamFromFile(String filename) {
        return ClassLoader.getSystemResourceAsStream(filename);
    }
}
