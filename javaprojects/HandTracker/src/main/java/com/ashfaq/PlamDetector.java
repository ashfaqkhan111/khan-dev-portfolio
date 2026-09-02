package com.ashfaq;

import ai.onnxruntime.*;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import static org.bytedeco.opencv.global.opencv_imgproc.*;


public class PlamDetector {
    public static void main(String[] args) {
        try{
            System.out.println("Starting plam Detector.......");

            OrtEnvironment env =  OrtEnvironment.getEnvironment();

            OrtSession.SessionOptions options = new OrtSession.SessionOptions();

            OrtSession session =  env.createSession("models/onnx/palm_detector.onnx",options);

            System.out.println("Plam detector loaded");

            VideoCapture camera = new VideoCapture(0);

            if (!camera.isOpened()){
                System.out.println("cloud not open web cam");

                session.close();
                env.close();
                return;
            }
            System.out.println("Webcam opened");

            Mat frame = new Mat();

            Mat resized = new Mat();

            while (true){
                camera.read(frame);
                if (frame.empty()){
                    System.out.println("Could not read frame");
                    break;
                }
                resize(frame,resized,new Size(192, 192));

                System.out.println("Frame resized : "+resized.cols()+ " x "+ resized.rows());
                break;
            }

            camera.release();
            session.close();
            env.close();
            System.out.println("Palm detector test finished.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
