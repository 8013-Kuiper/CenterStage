
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
        import com.acmerobotics.roadrunner.geometry.Pose2d;


        import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;
        import org.opencv.features2d.BRISK;

@TeleOp


public class teleOpWithrr extends driveConstant {

    enum State{
        firstPixel,
        backwards,
        dump,
        reset,
        up
    }
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        initrobot();

        State state = State.reset;
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        while (opModeIsActive()) {

            double turn;
            double throttle;
            boolean strafeLeft;
            boolean strafeRight;

            boolean winchUp;                                   //setting varibles from conteroler imputs

            double armpower;

            double plane;

            double Winchpower;

            boolean backwards;

            boolean reset;


            //driving
            drive.setWeightedDrivePower(
                    new Pose2d(
                            gamepad1.left_stick_y*.90,
                            gamepad1.left_stick_x*.90,
                            gamepad1.right_stick_x*.80
                    )
            );


            //setting controls on controller (initializing variables)
            throttle = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            strafeLeft = gamepad1.left_bumper;
            strafeRight = gamepad1.right_bumper;

            armpower = gamepad2.right_stick_y;

            winchUp = gamepad2.y;

            Winchpower = gamepad2.left_stick_y;

            plane = gamepad1.right_trigger;


            backwards = gamepad2.a;

            reset = gamepad2.left_bumper;




            arm.setPower(armpower*.5);

            WinchM.setPower(Winchpower);





            if (plane > 0) {
                Plane.setPosition(.9);
            }

            if (plane <= 0) {
                Plane.setPosition(.5);
            }

            outTake.setPosition(servoPos(arm.getCurrentPosition(),5500));//2200


            switch (state){
                case reset:
                    //leftServo.setPower(0);
                    rightServo.setPower(0);
                    winch.setPosition(1);//
                    if (backwards&&mRuntime.seconds()>1){
                        mRuntime.reset();
                        state = State.backwards;
                        break;
                    }
                    else if (gamepad2.x) {
                        mRuntime.reset();
                        state = State.firstPixel;
                        break;
                    }
                    else if (winchUp&&mRuntime.seconds()>1){
                        mRuntime.reset();
                        state= State.up;
                        break;
                    }
                    break;
                case firstPixel:
                    //leftServo.setPower(-1);
                    rightServo.setPower(1);
                    if (backwards){
                        mRuntime.reset();
                        state = State.backwards;
                        break;
                    }
                    else if(gamepad2.x&&mRuntime.seconds()>1) {
                        mRuntime.reset();
                        winch.setPosition(.86);
                        state = State.dump;
                    }
                    break;
                case dump:
                    if (mRuntime.seconds()>3.5){
                        state = State.reset;
                        break;
                    }
                    break;
                case backwards:
                    //leftServo.setPower(1);
                    rightServo.setPower(-1);
                    if (backwards&&mRuntime.seconds()>1){
                        mRuntime.reset();
                        state = State.reset;
                        break;
                    }
                    break;
                case up:
                    winch.setPosition(.85);
                    if (winchUp&&mRuntime.seconds()>1){
                        mRuntime.reset();
                        state=State.reset;
                    }


                    break;
            }


            if (reset){
                arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }



            //telemetry.addData("fL", frontLeft.getCurrentPosition());
            //telemetry.addData("fR", frontRight.getCurrentPosition());
            //telemetry.addData("bL", backLeft.getCurrentPosition());
            //telemetry.addData("bR", backRight.getCurrentPosition());

            telemetry.addData("arm pos", arm.getCurrentPosition());

            telemetry.addData("state",state);

            telemetry.addData("servo",servoPos(arm.getCurrentPosition(), 5500));

            telemetry.addData("timer", mRuntime.seconds());
            telemetry.update();


        }

    }
    public ElapsedTime mRuntime = new ElapsedTime();

}

