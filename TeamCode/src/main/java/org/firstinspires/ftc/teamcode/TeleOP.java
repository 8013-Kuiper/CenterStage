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

            float pickup;                                   //setting varibles from conteroler imputs
            float dropoff;
            boolean spinpowerup;
            boolean spinpowerdown;
            double crainpower;
            boolean spincenter;
            boolean opspincenter;

            boolean guideUp;
            boolean guideDown;

            //Pole Preset
            boolean smallJunction;
            boolean mediumJunction;
            boolean tallJunction;


            //setting controls on controller
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;

            lightoff = gamepad1.b;
            light = gamepad1.a;

            crainpower = gamepad2.right_stick_y;

            guideDown=gamepad2.x;
            guideUp=gamepad2.y;

            spinpowerup = gamepad2.dpad_right;
            spinpowerdown =gamepad2.dpad_left;
            pickup = gamepad2.left_trigger;
            dropoff = gamepad2.right_trigger;
            //Pole Presets
            smallJunction = gamepad2.x;
            mediumJunction = gamepad2.y;
            tallJunction = gamepad2.b;


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

            if (guideDown){
                Guide.setPosition(0);
            }

            else{
                Guide.setPosition(1);
            }

            if (spinpowerup){
                Spin.setPower(1);
            }
            if (spinpowerdown){
                Spin.setPower(-1);
            }

            if (!spinpowerdown && !spinpowerup ){
                Spin.setPower(0);
            }


            if (pickup>0) {

                Left.setPower(-1);
            }

            if (dropoff>0){

                Left.setPower(1);

            }
            if (dropoff == 0 && pickup == 0){

                Left.setPower(0);

            }

        }
}
