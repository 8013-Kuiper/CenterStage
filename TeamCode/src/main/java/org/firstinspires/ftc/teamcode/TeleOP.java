package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;                //imports from FIRST
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;
import org.opencv.features2d.BRISK;

@TeleOp


public class TeleOP extends driveConstant {


    @Override
    public void runOpMode() {
        //initrobot();
        initdrivetrain();

      waitForStart();

        while (opModeIsActive()) {

            double turn;
            double throttle;
            boolean strafeLeft;
            boolean strafeRight;







            //setting controls on controller (initializing variables)
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;





            if (strafeRight) {
                frontLeft.setPower(-1);
                frontRight.setPower(1);                         //conecting motor varibles to controler inputs
                backLeft.setPower(1);
                backRight.setPower(-1);
            }
            if (strafeLeft) {
                frontLeft.setPower(1);
                frontRight.setPower(-1);
                backLeft.setPower(-1);
                backRight.setPower(1);
            }


            frontLeft.setPower(throttle);
            frontRight.setPower(throttle * .97);
            backLeft.setPower(throttle);
            backRight.setPower(throttle * .97);

            frontLeft.setPower(-turn);
            frontRight.setPower(turn);
            backLeft.setPower(-turn);
            backRight.setPower(turn);












            telemetry.addData("fL", frontLeft.getCurrentPosition());
            telemetry.addData("fR", frontRight.getCurrentPosition());
            telemetry.addData("bL", backLeft.getCurrentPosition());
            telemetry.addData("bR", backRight.getCurrentPosition());



            telemetry.addData("timer", mRuntime.seconds());
            telemetry.update();


        }

    }
    public ElapsedTime mRuntime = new ElapsedTime();

}
