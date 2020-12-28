package com.ibcs.rm.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Utility {

    public static String getRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getRandomIntNumberForImages() {
        int rand = (new Random().nextInt(9000) + 1000);
        return String.valueOf(rand);

    }

    public String getCurrentDateAndTime() {
        DateFormat df = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }

    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }

    public String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }

    public String getRandomIntNumber() {
        int rand = (new Random().nextInt(900000) + 100000);
        return String.valueOf(rand);

    }

    // compress the image bytes before storing it in the database
    public byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
