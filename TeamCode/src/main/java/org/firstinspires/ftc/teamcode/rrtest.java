package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;
import org.tensorflow.lite.task.vision.detector.Detection;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import java.math.*;




@Autonomous

public class rrtest extends driveConstant {

    double teamElementPos;

    Pose2d startPose = new Pose2d(23,-70, Math.toRadians(90));

    public void runOpMode() {
        initrobot(); //init motors

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap); //init motors

        //init camera
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        Pipeline_red detector = new Pipeline_red(telemetry);

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        //set starting point
        drive.setPoseEstimate(startPose);
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
                Trajectory traj1 = drive.trajectoryBuilder(startPose)
                        .splineTo(new Vector2d(23, -46), Math.toRadians(90))
                        .build();

                //second movement
                Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                        .splineToLinearHeading(new Pose2d(46, -46, Math.toRadians(0)), Math.toRadians(0))
                        .splineTo(new Vector2d(49, -46), Math.toRadians(0))
                        .build();

                drive.followTrajectory(traj1);

                drive.followTrajectory(traj2);

            }
            if (teamElementPos == 1) {

            }
            if (teamElementPos == 3) {


            }
            if (teamElementPos == 4) {


            }
        }
    }

}
