package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.SampleMecanumDrive;

/**
 * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */
@TeleOp
public class LocalizationTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        double speed = 0;
        double curentspeed =0;
        ElapsedTime timer = new ElapsedTime();

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(
                            speed*.5,
                            gamepad1.left_stick_x,
                            gamepad1.right_stick_x
                    )
            );

            drive.update();

if (gamepad1.y) {
    //timer.reset();
    curentspeed = timer.seconds();
    speed = 1;
}
if(!gamepad1.y)
    if(timer.seconds()> curentspeed+2){
        speed = 0;
    }

            Pose2d poseEstimate = drive.getPoseEstimate();
            //telemetry.addData("x", poseEstimate.getX());
            //telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.addData("distance", drive.leftFront.getCurrentPosition());
            telemetry.update();
        }
    }
}