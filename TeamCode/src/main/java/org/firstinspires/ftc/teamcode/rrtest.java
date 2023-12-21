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




@Autonomous

public class rrtest extends driveConstant {

    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

    Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
            .strafeRight(10)
            .forward(5)
            .build();


    public void init() {

    }
        public void loop() {

            drive.followTrajectory(myTrajectory);

        }

}
