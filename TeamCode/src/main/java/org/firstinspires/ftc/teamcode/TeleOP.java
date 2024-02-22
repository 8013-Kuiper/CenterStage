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

@TeleOp


public class TeleOP extends driveConstant {

    enum State{
        firstPixel,
        secondPixel,
        dump,
        reset
    }
        @Override
        public void runOpMode() {
            initrobot();
            initdrivetrain();

            waitForStart();

            while (opModeIsActive()) {

                double turn;
                double throttle;
                boolean strafeLeft;
                boolean strafeRight;

                double intakeOn;                                   //setting varibles from conteroler imputs

                double armpower;

                double plane;

                boolean winchdump;

                boolean winchup;




                //setting controls on controller (initializing variables)
                throttle = gamepad1.left_stick_y;
                turn = gamepad1.right_stick_x;
                strafeLeft = gamepad1.left_bumper;
                strafeRight = gamepad1.right_bumper;

                armpower = gamepad2.right_stick_y;

                intakeOn = gamepad2.right_trigger;


                plane = gamepad1.right_trigger;

                winchdump = gamepad2.x;

                winchup = gamepad2.y;




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


                arm.setPower(armpower);




                if (plane > 0) {
                    Plane.setPosition(.9);
                }

                if (plane <= 0) {
                    Plane.setPosition(.5);
                }


                if (intakeOn>0){
                    leftServo.setPower(1);
                    rightServo.setPower(1);
                }
                if(intakeOn<=0){
                    leftServo.setPower(0);
                    rightServo.setPower(0);
                }

                outTake.setPosition(servoPos(arm.getCurrentPosition(),500));//find range

                if(winchdump){
                    winch.setPosition(.5);


                }

                if (winchup){
                    winch.setPosition(1);
                }



                telemetry.addData("fL", frontLeft.getCurrentPosition());
                telemetry.addData("fR", frontRight.getCurrentPosition());
                telemetry.addData("bL", backLeft.getCurrentPosition());
                telemetry.addData("bR", backRight.getCurrentPosition());

                telemetry.addData("arm pos", arm.getCurrentPosition());

                telemetry.addData("timer", mRuntime.seconds());
                telemetry.update();


            }

        }
    public ElapsedTime mRuntime = new ElapsedTime();

}
