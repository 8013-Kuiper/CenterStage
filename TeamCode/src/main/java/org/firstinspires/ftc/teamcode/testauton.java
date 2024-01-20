package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;



@Autonomous


public class testauton extends driveConstant {



    Pose2d startPose = new Pose2d(-37.5,65, Math.toRadians(-90));

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //set starting point
        drive.setPoseEstimate(startPose);

        //init camera






        waitForStart();


        if (opModeIsActive()){

            //trajectorys
            Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)


                    //.forward(5)
                    .addTemporalMarker(()->{
                        Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                        Crane.setTargetPosition(-2000);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(1);
                        rightServo.setPosition(1);
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        //rightServo.setPosition(1);
                        /*Crane.setTargetPosition(0);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(1);*/
                        rightServo.setPosition(0);
                    })
                    .waitSeconds(10)
                    .build();




                drive.followTrajectorySequence(left);
                rightServo.setPosition(1);
                sleep(2000);
                rightServo.setPosition(0);
                sleep(2000);
                telemetry.update();





        }
    }

}
