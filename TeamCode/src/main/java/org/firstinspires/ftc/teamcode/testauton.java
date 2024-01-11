package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;



@Autonomous

public class testauton extends driveConstant {






    Pose2d startPose = new Pose2d(14.5,65, Math.toRadians(-90));

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //set starting point
        drive.setPoseEstimate(startPose);

        //init camera






        waitForStart();


        if (opModeIsActive()){
            Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //trajectorys


            TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                    //.splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                    //.strafeTo(new Vector2d(6.7,40))
                    .splineTo(new Vector2d(6.7,38),Math.toRadians(-160))
                    .addDisplacementMarker(()->{
                        //deliverPurple(100,.2);
                        telemetry.addLine("deliver");
                    })
                    .waitSeconds(1)
                    .addDisplacementMarker(()->{
                        //resetIntake();
                        Crane.setTargetPosition(-1000);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(.8);
                        telemetry.addLine("crane up");
                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(51,46))
                    .addDisplacementMarker(()->{
                        Crane.setTargetPosition(-2000);
                        telemetry.addLine("crane up more");
                    })

                    .strafeLeft(16)
                    .waitSeconds(.5)
                    .addDisplacementMarker(()->{
                        drop();
                        telemetry.addLine("drop");
                    })
                    .waitSeconds(.5)
                    .addDisplacementMarker(()->{
                        retract();
                        telemetry.addLine("crane down");
                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(51,58))
                    .back(8)
                    .build();




                drive.followTrajectorySequence(right);
                telemetry.update();



        }
    }

}
