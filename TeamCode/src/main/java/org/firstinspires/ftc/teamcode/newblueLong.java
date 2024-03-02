package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


@Autonomous

public class newblueLong extends driveConstant {

    public OpenCvCamera webcam;
    double teamElementPos;




    Pose2d startPose = new Pose2d(-37.5,65, Math.toRadians(-90));


    ElapsedTime time = new ElapsedTime();

    public void runOpMode() {
        initrobot(); //init motors
        servoController = 0;
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


        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();


        if (opModeIsActive()){
            //trajectorys

            TrajectorySequence left = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-29, 37.5), Math.toRadians(-20))
                    .back(5)
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);

                    })
                    //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))//59.5
                    .setReversed(false)
                    .waitSeconds(5)

                    .lineToConstantHeading(new Vector2d(11,62))//59.6

                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                    .lineTo(new Vector2d(50, 46))

                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);

                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(5)
                    /*.back(8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/
                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        outTake.setPosition(.4);
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                    })
                    .waitSeconds(10)

                    .build();

            TrajectorySequence right = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-47, 38), Math.toRadians(-90))
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);

                    })
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))
                    .setReversed(false)
                    .waitSeconds(5)
                    .lineToConstantHeading(new Vector2d(11,62))

                    .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                    .lineTo(new Vector2d(50,46))//46

                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);

                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(20)
                    /*.back(8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        outTake.setPosition(.4);
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);

                    })
                    .waitSeconds(10)
                    .build();

            TrajectorySequence center = drive.trajectorySequenceBuilder(startPose)
                    .splineTo(new Vector2d(-45,27),Math.toRadians(-1))//-20
                    .addTemporalMarker(()->{
                        leftServo.setPower(1);
                        rightServo.setPower(-1);
                    })
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        leftServo.setPower(0);
                        rightServo.setPower(0);
                    })
                    //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                    .setReversed(true)
                    .splineTo(new Vector2d(-37,62), Math.toRadians(0))//go in front of truss
                    .setReversed(false)
                    .waitSeconds(5)
                    .lineToConstantHeading(new Vector2d(11,62))

                    .lineToSplineHeading(new Pose2d(46, 40, Math.toRadians(-180)))//was 46,46

                    .lineTo(new Vector2d(50,46))//was 50,46

                    .addTemporalMarker(()->{
                        moveArm(.5,-5800);

                        telemetry.addLine("crane up");
                    })
                    .strafeLeft(8)
                    /*.back(8,
                            SampleMecanumDrive.getVelocityConstraint(5, DriveConstants.MAX_ANG_VEL,DriveConstants.TRACK_WIDTH),SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))*/

                    .waitSeconds(.5)
                    .forward(1)
                    .waitSeconds(1)
                    .addTemporalMarker(()->{
                        outTake.setPosition(.4);
                    })
                    .waitSeconds(3)
                    .addTemporalMarker(()->{
                        moveArm(.8,0);
                    })
                    .waitSeconds(10)
                    .build();


            //servo stuff
            outTake.setPosition(servoPosAuton(arm.getCurrentPosition(), 5500));

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
                drive.followTrajectorySequence(right);


            }
            else if (teamElementPos == 1) {
                winch.setPosition(1);
                drive.followTrajectorySequence(left);

            }
            else if (teamElementPos == 3) {
                winch.setPosition(1);
                drive.followTrajectorySequence(center);

            }

        }
    }
    public ElapsedTime mRuntime = new ElapsedTime();

}
