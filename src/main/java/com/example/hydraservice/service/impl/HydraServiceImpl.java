package com.example.hydraservice.service.impl;

import com.example.hydraservice.controller.request.HydraRequest;
import com.example.hydraservice.service.HydraService;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.concurrent.TimeUnit;

@Configuration
public class HydraServiceImpl implements HydraService {
    @Override
    public void callHydra(HydraRequest hydraRequest) throws Exception {

        File location = new File("/home/hoangkm");

        String command = "hydra -v -V -l " + hydraRequest.getUsername() + " -p " + hydraRequest.getPassword() + " -s " + hydraRequest.getPort() + " "
                + hydraRequest.getIpAddress() + " " + hydraRequest.getProtocol() + " " + '"' + hydraRequest.getHttpForm() + '"';

        runCommand(location, command);
    }

    public static void runCommand(File whereToRun, String command) throws Exception {
        System.out.println("Running in: " + whereToRun);
        System.out.println("Command: " + command);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);

//        if (isWindows) {
//        builder.command("cmd.exe", "/c", command);
//        } else {
        builder.command("sh", "-c", command);
//        }

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if (!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }
}
