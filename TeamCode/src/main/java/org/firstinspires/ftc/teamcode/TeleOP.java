package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;                //imports from FIRST
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp
public class TeleOP extends DriveConstants {
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

            boolean light;
            boolean lightoff;

            float intake;                                   //setting varibles from conteroler imputs
            float dropoff;


            double crainpower;




            //setting controls on controller
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;

            lightoff = gamepad1.b;
            light = gamepad1.a;

            crainpower = gamepad2.right_stick_y;

            intake = gamepad2.left_trigger;
            dropoff = gamepad2.right_trigger;

            if (lightoff){
                lights.setPower(0);
            }
            if(light) {
                lights.setPower(.1);
            }

            if (strafeRight) {
                frontLeft.setPower(-.8);
                frontRight.setPower(1);                         //conecting motor varibles to controler inputs
                backLeft.setPower(1);
                backRight.setPower(-1);
            }
            if (strafeLeft) {
                frontLeft.setPower(1);
                frontRight.setPower(-1);
                backLeft.setPower(-.8);
                backRight.setPower(1);
            }


            frontLeft.setPower(throttle*.91);
            frontRight.setPower(throttle);
            backLeft.setPower(throttle*.91);
            backRight.setPower(throttle);

            frontLeft.setPower(-turn);
            frontRight.setPower(turn);
            backLeft.setPower(-turn);
            backRight.setPower(turn);

            Crain.setPower(crainpower);

            if (intake>0) {

                Left.setPower(-1);
            }
            else
                Left.setPower(0);

            if (dropoff>0){

                Left.setPower(1);

            }


        }
}
