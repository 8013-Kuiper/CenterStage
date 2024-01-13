package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
@Disabled
public class testTeloOP extends driveConstant {


    double turn;
    double throttle;
    boolean strafeLeft;
    boolean strafeRight;

    boolean retract;
    boolean extend;

    boolean windshieldwiper;

    boolean intakeClose;                                   //setting varibles from conteroler imputs
    boolean intakeOpen;

    double intake2Close;
    double intake2Open;


    double cranepower;
    double Intakepower;

    boolean stopIntakePower;

    boolean endGame;

    boolean ultimate;


    enum State{
        Intake,
        Intake2,
        windshield,
        servoclose,
        liftextend,
        liftretract,
        endGame
    };
    State state = State.Intake;
    @Override
    public void runOpMode() {
        initrobot();
        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();



        while (opModeIsActive()) {
            //setting controls on controller (initializing variables)
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;

            cranepower = gamepad2.right_stick_y;

            intakeClose = gamepad2.right_bumper;
            intakeOpen = gamepad2.left_bumper;

            Intakepower = gamepad2.left_stick_y;

            stopIntakePower = gamepad2.x;

            endGame = gamepad2.a;

            if (gamepad2.left_trigger > 0 && gamepad2.right_trigger > 0)
                ultimate = true;
            if (!(gamepad2.left_trigger > 0 && gamepad2.right_trigger > 0))
                ultimate = false;


            if (strafeRight) {
                frontLeft.setPower(-1);
                frontRight.setPower(1);
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Crane.setPower(1);
            switch (state) {

                case Intake:
                    Crane.setTargetPosition(0);
                    if (endGame) {
                        state = State.endGame;
                    }
                    Intake.setPower(Intakepower * .9);

                    if (stopIntakePower/*x button*/) {
                        Intake.setPower(0);
                        rightServo.setPosition(0);
                        mRuntime.reset();
                        state = State.windshield;
                    }
                    break;
                case windshield:
                    if (mRuntime.seconds() > 2) {
                        rightServo.setPosition(1);
                        Crane.setTargetPosition(-130);
                        state = State.Intake2;
                    }
                    break;
                case Intake2:
                    Intake.setPower(Intakepower * .9);

                    if (stopIntakePower) {
                        Intake.setPower(0);
                        leftServo.setPosition(.5);
                        rightServo.setPosition(.3);
                        mRuntime.reset();
                        state = State.servoclose;
                    }
                    break;
                case servoclose:
                    if (mRuntime.seconds() > 5) {
                        Crane.setTargetPosition(-4000);
                        state = State.liftextend;
                    }
                    break;

                case liftextend:
                    if (Math.abs(Crane.getCurrentPosition() - 4000) < 15) {
                        if (intakeOpen/*left bumper*/) {
                            rightServo.setPosition(0);
                            leftServo.setPosition(0);
                            Crane.setTargetPosition(0);
                            state = State.liftretract;
                        }
                    }
                    break;
                case liftretract:
                    if ((Math.abs(Crane.getCurrentPosition() - 0) < 15)) {
                        state = State.Intake;
                    }
                    break;
                case endGame:
                    Crane.setTargetPosition(3000);
                    if (Math.abs(Crane.getCurrentPosition() - 3000) < 15) {
                        if (endGame) {
                            Winch.setPower(1);
                            Winch.setTargetPosition(1000);//needs to change value
                        }
                    }

            }
            if (ultimate) {
                state = State.Intake;
            }


            telemetry.addData("fL", frontLeft.getCurrentPosition());
            telemetry.addData("fR", frontRight.getCurrentPosition());
            telemetry.addData("bL", backLeft.getCurrentPosition());
            telemetry.addData("bR", backRight.getCurrentPosition());
            telemetry.addData("crane", Crane.getCurrentPosition());
            telemetry.update();


        }
    }
    public ElapsedTime mRuntime = new ElapsedTime();

}
