package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;                //imports from FIRST
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp
public class TeleOP extends driveConstant {
        @Override
        public void init() {
            initrobot();
        }
        @Override
        public void loop() {
            double turn;
            double throttle;
            boolean strafeLeft;
            boolean strafeRight;

            boolean retract;
            boolean extend;

            float intake;                                   //setting varibles from conteroler imputs
            float dropoff;


            double cranepower;
            double Intakepower;




            //setting controls on controller (initializing variables)
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;

            cranepower = gamepad2.right_stick_y;

            intake = gamepad2.left_trigger;
            dropoff = gamepad2.right_trigger;

            extend = gamepad2.a;
            retract = gamepad2.b;

            Intakepower = gamepad2.left_stick_y;


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
            frontRight.setPower(throttle*.97);
            backLeft.setPower(throttle);
            backRight.setPower(throttle*.97);

            frontLeft.setPower(-turn);
            frontRight.setPower(turn);
            backLeft.setPower(-turn);
            backRight.setPower(turn);

            if(Math.abs(Crane.getCurrentPosition())>4280){
                Crane.setDirection(DcMotorSimple.Direction.FORWARD);
            }
            if (Math.abs(Crane.getCurrentPosition())<5 ){
                Crane.setDirection(DcMotorSimple.Direction.REVERSE);
            }
            Crane.setPower(cranepower);

            /*if(extend){
                Crane.setPower(1);
                Crane.setTargetPosition(4290);
                Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            if(retract){
                Crane.setPower(1);
                Crane.setTargetPosition(10);
                Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }*/

            Intake.setPower(Intakepower*.60);


            telemetry.addData("fL",frontLeft.getCurrentPosition());
            telemetry.addData("fR",frontRight.getCurrentPosition());
            telemetry.addData("bL",backLeft.getCurrentPosition());
            telemetry.addData("bR",backRight.getCurrentPosition());
            telemetry.update();




        }
}
