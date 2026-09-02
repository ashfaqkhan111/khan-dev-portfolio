package com.ashfaq;

import ai.onnxruntime.*;
import java.nio.FloatBuffer;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.javacpp.BytePointer;

public class PlamDetector {
    public static void main(String[] args) {
        try{
            System.out.println("Starting palm Detector.......");

            OrtEnvironment env =  OrtEnvironment.getEnvironment();

            OrtSession.SessionOptions options = new OrtSession.SessionOptions();

            OrtSession session =  env.createSession("models/onnx/palm_detector.onnx",options);

            System.out.println("Palm detector loaded");

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
                
                float [][][][] input = new float[1][192][192][3];

                for (int y=0; y<192; y++){
                    for (int x=0; x<192; x++){
                        float[] pixel = resized.ptr(y, x).getFloatPointer().getArray(3);
                        
                        float blue = pixel[0];
                        float green = pixel[1];
                        float red = pixel[2];

                        input[0][y][x][0] = red;
                        input[0][y][x][1] = green;
                        input[0][y][x][2] = blue;
                    }
                }

                System.out.println("Input tensor created");

                OnnxTensor inputTenser = OnnexTenser.createTensor(env, input);

                System.out.println("ONNX tenser created");

                OrtSession.Result result = session.run(java.util.Collection.singletonMap("input_1",inputTenser));

                System.out.println("Palm detector interface completed");

                System.out.println("Number od outputs: "+result.size());

                for(int i=0; i<result.size(); i++){
                    Object output = result.get(1).getValue();

                    System.out.println("Output "+i+ ": "+output.getClass());
                }

            }
            inputTenser.close();
            result.close();

            camera.release();
            session.close();
            env.close();
            System.out.println("Palm detector test finished.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
