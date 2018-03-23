package io.maslick.haha.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public interface IFileLoader {
    InputStream getStreamFromFile(String filename);

    default List<String> getStringsFromFile(String filename) {
        InputStream inputFS = getStreamFromFile(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        return br.lines().collect(Collectors.toList());
    }
}
