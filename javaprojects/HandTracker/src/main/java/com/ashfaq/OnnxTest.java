package com.ashfaq;

import ai.onnxruntime.*;

public class OnnxTest{

	public static void main (String [] args) throws Exception {

		System.out.println("Strating OnnxRunTime");
		OrtEnvironment env = OrtEnvironment.getEnvironment();

		OrtSession.SessionOptions options = new OrtSession.SessionOptions();

		OrtSession session = env.createSession("models/onnx/palm_detector.onnx",options);

		System.out.println("plam loader loaded successfully!");
		System.out.println("\nModel inputs : ");

		for(NodeInfo input : session.getInputInfo().values()){
			System.out.println(input);
			}

		System.out.println("\nModel outputs: ");
		for(NodeInfo output : session.getOutputInfo().values()){
			System.out.println(output);
			
			}
			
			session.close();
			env.close();
			System.out.println("\nONNX test finished");

	}

}
