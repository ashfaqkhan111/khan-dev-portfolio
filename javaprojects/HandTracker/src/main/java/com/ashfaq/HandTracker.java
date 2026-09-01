package com.ashfaq;

import org.opencv.core.Core;


import org.opencv.highgui.HighGui;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_highgui;

import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_videoio;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;


public class HandTracker {
    public static void main(String[] args) {

        System.out.println("Hand tracker is starting");

        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()){
            System.out.println("Cloud not start open webcam!");
            return;
        }

        System.out.println("Webcam opened successfully!");

        Mat frame =  new Mat();

        while (true){
            camera.read(frame);

            if (frame.empty()){
                System.out.println("could not read the frame");
                break;
            }
            opencv_highgui.imshow("Hand Tracker", frame);

            int key = opencv_highgui.waitKey(1);

            if(key == 27){
                break;
            }


        }

        camera.release();

        opencv_highgui.destroyAllWindows();
        System.out.println("Program stopped");
        
}
}
