package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;



@Autonomous
public class Ex_auto extends driveConstant {

    public void init() {


        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        Pipeline_red detector = new Pipeline_red(telemetry);
        webcam.setPipeline(detector);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

    }
        public void loop() {
            //switch(position){
             //   case right:
                


         //   }



            stop();
            }

public void Drive (double power, double time){
    frontLeft.setPower(power);
    frontRight.setPower(power);
    backLeft.setPower(power);
    backRight.setPower(power);

    stopmotors();
}
    
public void stopmotors(){
    frontLeft.setPower(0);
    frontRight.setPower(0);
    backLeft.setPower(0);
    backRight.setPower(0);
    }
    public ElapsedTime mRuntime = new ElapsedTime();
    public ElapsedTime timer = new ElapsedTime();
}


