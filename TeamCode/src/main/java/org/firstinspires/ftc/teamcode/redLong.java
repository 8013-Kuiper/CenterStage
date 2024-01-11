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


@Autonomous

public class redLong extends driveConstant {

    public OpenCvCamera webcam;
    double teamElementPos;
    double distancex =5;



    Pose2d startPose = new Pose2d(-37.5,-65, Math.toRadians(90));

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //init camera
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        Pipeline_red detector = new Pipeline_red(telemetry);
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

        //trajectorys
        TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(-29, -37.5), Math.toRadians(20))
                .addDisplacementMarker(()->{
                    //deliverPurple(100,.2);
                })
                .waitSeconds(1)
                .addDisplacementMarker(()->{
                    //resetIntake();

                })
                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                .setReversed(true)
                .splineTo(new Vector2d(-37,-59.5), Math.toRadians(0))
                .setReversed(false)
                .waitSeconds(5)
                .lineToConstantHeading(new Vector2d(11,-59.5))

                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                .lineTo(new Vector2d(51,-46))

                .addDisplacementMarker(()->{

                })
                .strafeRight(3)
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .build();

        TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(-47, -38), Math.toRadians(90))
                .addDisplacementMarker(()->{
                    //deliverPurple(100,.2);
                })
                .waitSeconds(1)
                .addDisplacementMarker(()->{
                    //resetIntake();

                })
                .setReversed(true)
                .splineTo(new Vector2d(-37,-59.5), Math.toRadians(0))
                .setReversed(false)
                .waitSeconds(5)
                .lineToConstantHeading(new Vector2d(11,-59.5))

                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                .lineTo(new Vector2d(51,-46))

                .addDisplacementMarker(()->{

                })
                .strafeRight(16)
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .build();

        TrajectorySequence center = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(-45,27),Math.toRadians(-20))
                .addDisplacementMarker(()->{
                    //deliverPurple(100,.2);
                })
                .waitSeconds(1)
                .addDisplacementMarker(()->{
                    //resetIntake();

                })
                .setReversed(true)
                .splineTo(new Vector2d(-37,59.5), Math.toRadians(0))
                .setReversed(false)
                .waitSeconds(5)
                .lineToConstantHeading(new Vector2d(11,59.5))

                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                .lineTo(new Vector2d(51,46))

                .addDisplacementMarker(()->{

                })
                .strafeLeft(12)
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .waitSeconds(.5)
                .addDisplacementMarker(()->{

                })
                .build();

        waitForStart();


        if (opModeIsActive()){

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
                    teamElementPos = 2;//should be 4
                    break;


            }


            if (teamElementPos == 2) {

                drive.followTrajectorySequence(right);


            }
            if (teamElementPos == 1) {

                //drive.followTrajectorySequence(left);

            }
            if (teamElementPos == 3) {

                //drive.followTrajectorySequence(center);

            }
            if (teamElementPos == 4) {


            }
        }
    }

}
