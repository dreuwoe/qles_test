package com.example.qles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionSocket {

    public void go() {

        try {
            Socket connectionSocket = new Socket("127.0.0.1", 5000);

            InputStreamReader streamReader = new InputStreamReader(connectionSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            PrintWriter writer = new PrintWriter(connectionSocket.getOutputStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
