package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvViewRenderer;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous

public class blueLong extends driveConstant {

    public OpenCvCamera webcam;
    double teamElementPos;
    double distancex =5;




    Pose2d startPose = new Pose2d(-37.5,65, Math.toRadians(-90));


    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //init camera
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        Pipeline_blue detector = new Pipeline_blue(telemetry);
        webcam.setPipeline(detector);

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 960, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        //set starting point
        drive.setPoseEstimate(startPose);



        waitForStart();


        if (opModeIsActive()){
            //trajectorys
            TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-29, 37.5), Math.toRadians(-20))
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //resetIntake();

                    })
                    //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))//59.5
                    .setReversed(false)
                    .waitSeconds(5)

                    .lineToConstantHeading(new Vector2d(11,62))//59.6

                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                    .lineTo(new Vector2d(51,46))

                    .addTemporalMarker(()->{
                        Crane.setTargetPosition(-1263);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(.8);
                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(3)
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        rightServo.setPosition(.2);
                    })
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        retract();
                    })
                    .waitSeconds(10)

                    .build();

            TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-47, 38), Math.toRadians(-90))
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //resetIntake();

                    })
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))
                    .setReversed(false)
                    .waitSeconds(5)
                    .lineToConstantHeading(new Vector2d(11,62))

                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                    .lineTo(new Vector2d(51,46))

                    .addTemporalMarker(()->{
                        Crane.setTargetPosition(-1263);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(.8);
                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(18)
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        rightServo.setPosition(.2);
                    })
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        retract();

                    })
                    .waitSeconds(10)
                    .build();

            TrajectorySequence center = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-45,27),Math.toRadians(-20))
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);

                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{

                    })
                    //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))//go in front of truss
                    .setReversed(false)
                    .waitSeconds(5)
                    .lineToConstantHeading(new Vector2d(11,62))

                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                    .lineTo(new Vector2d(51,46))

                    .addTemporalMarker(()->{
                        Crane.setTargetPosition(-1263);
                        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        Crane.setPower(.8);
                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(16)
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        rightServo.setPosition(.2);
                    })
                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        retract();
                    })
                    .waitSeconds(10)
                    .build();


            //find game element
            switch (detector.getLocation()) {
                case LEFT:
                    teamElementPos = 1;
                    break;
                case RIGHT:
                    teamElementPos = 2;
                    break;
                case MIDDLE:
                    teamElementPos = 3;
                    break;
                case NOT_FOUND:
                    teamElementPos = 1;//should be 4
                    break;


            }


            if (teamElementPos == 2) {

                drive.followTrajectorySequence(right);


            }
            else if (teamElementPos == 1) {

                drive.followTrajectorySequence(left);

            }
            else if (teamElementPos == 3) {

                drive.followTrajectorySequence(center);

            }

        }
    }

}
