package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore. eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@TeleOp
public class teleOpWithRR extends driveConstant{

    @Override
    public void runOpMode(){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);



        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        initrobot();

        waitForStart();

        while (opModeIsActive()) {
            boolean retract;
            boolean extend;

            boolean windshieldwiper;

            boolean intakeClose;                                   //setting varibles from conteroler imputs
            boolean intakeOpen;

            double intake2Close;
            double intake2Open;

            double Winchpower;


            double cranepower;
            double Intakepower;

            double plane;

            boolean springarm;
            boolean holderActivation;




            //driving
            drive.setWeightedDrivePower(
                    new Pose2d(
                            gamepad1.left_stick_y*.80,
                            gamepad1.left_stick_x*.90,
                            gamepad1.right_stick_x*.80
                    )
            );



            cranepower = gamepad2.right_stick_y;

            Winchpower = gamepad2.left_stick_x;

            intakeClose = gamepad2.right_bumper;
            intakeOpen = gamepad2.left_bumper;

            intake2Close = gamepad2.right_trigger;
            intake2Open = gamepad2.left_trigger;



            extend = gamepad2.a;
            retract = gamepad2.b;

            Intakepower = gamepad2.left_stick_y;

            plane = gamepad1.right_trigger;

            springarm = gamepad2.x;

            holderActivation = gamepad2.y;



            Crane.setPower(cranepower);

            Winch.setPower(Winchpower);


            if (plane > 0 && mRuntime.time(TimeUnit.SECONDS)>90) {
                Plane.setPosition(1);
            }

            if (plane <= 0) {
                Plane.setPosition(.75);
            }

            if (springarm) {
                springArm.setPosition(1);
            }
            if (!springarm) {
                springArm.setPosition(0);
            }



            if (intake2Close > 0) {
                rightServo.setPosition(1);
            }

            if (intake2Open > 0) {
                rightServo.setPosition(.3);
            }


            if (holderActivation) {
                armHolder.setPosition(1);
            }

            if (!holderActivation) {
                armHolder.setPosition(.6);
            }

            /*if (extend) {
                Crane.setPower(-1);
                Crane.setTargetPosition(-2290);
                Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            if (retract) {
                Crane.setPower(1);
                Crane.setTargetPosition(-10);
                Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }*/

            Intake.setPower(Intakepower * .90);


        }
        }
    public ElapsedTime mRuntime = new ElapsedTime();
    }

