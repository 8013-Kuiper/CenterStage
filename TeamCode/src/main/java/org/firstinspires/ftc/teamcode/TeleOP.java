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
        backwards,
        dump,
        reset
    }
        @Override
        public void runOpMode() {
            initrobot();
            initdrivetrain();

            State state = State.firstPixel;
            waitForStart();

            while (opModeIsActive()) {

                double turn;
                double throttle;
                boolean strafeLeft;
                boolean strafeRight;

                double intakeOn;                                   //setting varibles from conteroler imputs

                double armpower;

                double plane;

                boolean backwards;




                //setting controls on controller (initializing variables)
                throttle = gamepad1.left_stick_y;
                turn = gamepad1.right_stick_x;
                strafeLeft = gamepad1.left_bumper;
                strafeRight = gamepad1.right_bumper;

                armpower = gamepad2.right_stick_y;

                intakeOn = gamepad2.right_trigger;


                plane = gamepad1.right_trigger;


                backwards = gamepad2.a;




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

                outTake.setPosition(servoPos(arm.getCurrentPosition(),500));//TODO find range


                switch (state){
                    case reset:
                        leftServo.setPower(0);
                        rightServo.setPower(0);
                        winch.setPosition(0);//TODO what ever down is
                        if (backwards){
                            state = State.backwards;
                            break;
                        }
                        else if (gamepad2.x) {
                            state = State.firstPixel;
                            break;
                        }
                    case firstPixel:
                        leftServo.setPower(1);
                        rightServo.setPower(1);
                        if (backwards){
                            state = State.backwards;
                            break;
                        }
                        else if(gamepad2.x) {
                            mRuntime.reset();
                            winch.setPosition(.5);
                            state = State.dump;
                        }
                        break;
                    case dump:
                        if (mRuntime.seconds()>1){
                            state = State.reset;
                            break;
                        }
                    case backwards:
                        leftServo.setPower(1);
                        rightServo.setPower(1);
                        if (backwards){
                            state = State.reset;
                            break;
                        }
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
