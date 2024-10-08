package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.drive.Drive;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
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
@Disabled

public class blueclose extends driveConstant {


    public OpenCvCamera webcam;
    double teamElementPos;
    double distancex =5;



    Pose2d startPose = new Pose2d(14.5,65, Math.toRadians(-90));

    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //set starting point
        drive.setPoseEstimate(startPose);

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





        waitForStart();


        if (opModeIsActive()){

            //trajectorys
            TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);
                        telemetry.addLine("deliver");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //resetIntake();

                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        //Crane.setTargetPosition(-2000);
                    })
                    .strafeLeft(3)
                    .back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();

                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{

                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))
                    .back(8)
                    .waitSeconds(10)
                    .build();

            TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                    //.splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                    //.strafeTo(new Vector2d(6.7,40))
                    .splineTo(new Vector2d(6.7,38),Math.toRadians(-160))
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);
                        telemetry.addLine("deliver");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //resetIntake();

                        telemetry.addLine("crane up");
                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        //Crane.setTargetPosition(-2000);
                        telemetry.addLine("crane up more");
                    })

                    .strafeLeft(19)
                    .back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();


                        telemetry.addLine("drop");
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{

                        telemetry.addLine("crane down");
                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))//58
                    .back(8)
                    .waitSeconds(10)
                    .build();

            TrajectorySequence center = drive.trajectorySequenceBuilder(startPose)
                    //.splineTo(new Vector2d(23, 35), Math.toRadians(-90))
                    //.strafeTo(new Vector2d(10,35))
                    .splineTo(new Vector2d(23,27),Math.toRadians(-179))//-160
                    .addTemporalMarker(()->{
                        //deliverPurple(120,.5);
                        telemetry.addLine("deliver center");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //resetIntake();

                        telemetry.addLine("crane up");
                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        //Crane.setTargetPosition(-2000);
                    })
                    .strafeLeft(9)
                    .back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{

                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))
                    .back(8)
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
