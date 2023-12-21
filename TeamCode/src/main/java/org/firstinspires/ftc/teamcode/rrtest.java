package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.apriltag.AprilTagDetection;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import java.math.*;




@Autonomous

public class rrtest extends driveConstant {

    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

    Pose2d startPose = new Pose2d(23,-70, Math.toRadians(90));


    public void init() {
        //set starting point
        drive.setPoseEstimate(startPose);

        //first movement

    }
        public void start() {
            Trajectory traj1 = drive.trajectoryBuilder(startPose)
                    .splineTo(new Vector2d(23,-46),Math.toRadians(90))
                    .build();

            //second movement
            Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                    .splineToLinearHeading(new Pose2d(46,-46, Math.toRadians(0)), Math.toRadians(0))
                    .splineTo(new Vector2d(49, -46),Math.toRadians(0))
                    .build();

            drive.followTrajectory(traj1);
            drive.followTrajectory(traj2);

        }
        public void loop(){

        }

}
