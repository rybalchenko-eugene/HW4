package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Counter implements AutoCloseable{
    private static int counter = 0;

    public void add(){
        counter++;
    }


    @Override
    public void close() throws Exception {

    }
}

