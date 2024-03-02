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
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;



@Autonomous

public class newblueClose extends driveConstant {


    public OpenCvCamera webcam;
    double teamElementPos;



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




        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();


        if (opModeIsActive()){

            //trajectorys
            TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)
                    .waitSeconds(1)
                    .splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                        telemetry.addLine("deliver");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);

                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);
                    })
                    .strafeLeft(3)
                    /*.back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();
                        outTake.setPosition(.4);

                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))
                    .back(8)
                    .waitSeconds(10)
                    .build();

            TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                    .waitSeconds(1)
                    //.splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                    //.strafeTo(new Vector2d(6.7,40))
                    .splineTo(new Vector2d(6.7,38),Math.toRadians(-160))
                    .back(5)
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                        telemetry.addLine("deliver");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);
                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);
                        telemetry.addLine("crane up more");
                    })

                    .strafeLeft(19)
                    /*.back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/

                    .waitSeconds(.5)
                    .addTemporalMarker(()->{
                        moveArm(.5,-5500);
                    })
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();
                        outTake.setPosition(.4);
                        telemetry.addLine("drop");
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                        telemetry.addLine("crane down");
                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))//58
                    .back(8)
                    .waitSeconds(10)
                    .build();

            TrajectorySequence center = drive.trajectorySequenceBuilder(startPose)
                    .waitSeconds(1)
                    //.splineTo(new Vector2d(23, 35), Math.toRadians(-90))
                    //.strafeTo(new Vector2d(10,35))
                    .splineTo(new Vector2d(23,27),Math.toRadians(-179))//-160
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                        telemetry.addLine("deliver center");
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);

                        telemetry.addLine("crane up");
                    })
                    //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                    //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                    .lineTo(new Vector2d(50,46))
                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);
                    })
                    .strafeLeft(9)
                    /*.back(4.8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        //drop();
                        outTake.setPosition(.4);
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                    })
                    //.strafeTo(new Vector2d(49,58))
                    .strafeTo(new Vector2d(50,70))
                    .back(8)
                    .waitSeconds(10)
                    .build();

            TrajectorySequence test = drive.trajectorySequenceBuilder(startPose)
                    .forward(.5)
                    .addTemporalMarker(()->{
                        //outTake.setPosition(.9);


                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);
                    })
                    .waitSeconds(1)

                    .addTemporalMarker(()->{
                        outTake.setPosition(.4);
                    })
                    .waitSeconds(2)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                    })

                    .build();


            //servo stuff
            //outTake.setPosition(servoPosAuton(arm.getCurrentPosition(), 5500));


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
                winch.setPosition(1);
                //servoController=2;
                drive.followTrajectorySequence(right);


            }
            else if (teamElementPos == 1 ) {
                winch.setPosition(1);
                drive.followTrajectorySequence(left);

            }
            else if (teamElementPos == 3) {
                winch.setPosition(1);
                drive.followTrajectorySequence(center);

            }

        }
    }

}
