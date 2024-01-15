package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.openftc.easyopencv.OpenCvCamera;

import java.util.ArrayList;
@TeleOp
@Disabled
public class intakeTest extends OpMode {

    public Servo Intake;
    public CRServo Push;

    public DcMotor Crane;

    public void init() {
       // Intake = hardwareMap.get(Servo.class, "intake");
        Crane = hardwareMap.get(DcMotor.class,"crane");
    }

    @Override
    public void start() {
        super.start();

        mRuntime.reset();
        Crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void loop() {

        boolean IntakeIn;
        boolean IntakeOut;
        boolean Push;
        boolean Pull;
        double Cranepower;


        IntakeIn = gamepad1.right_bumper;
        IntakeOut = gamepad1.left_bumper;

        Cranepower = gamepad1.left_stick_y;

        Push = gamepad1.x;
        Pull = gamepad1.y;

        if(Math.abs(Crane.getCurrentPosition())>4280){
            Crane.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        if (Math.abs(Crane.getCurrentPosition())<5 ){
            Crane.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        Crane.setPower(Cranepower);


        if (IntakeIn) {
            Intake.setPosition(1);
        }
        if (IntakeOut) {
            Intake.setPosition(0);
        }

        if (Pull) {
            Pixelpull();
        }

        if(Push){
            Pixelpush();
        }

        telemetry.addData("encoder", Crane.getCurrentPosition());
        telemetry.update();

    }

    public void Pixelpush() {
        Push.setPower(1);
        mRuntime.reset();
        if(mRuntime.time()>1) {
            Push.setPower(0);
        }

    }

    public void Pixelpull() {
        Push.setPower(-1);
        mRuntime.reset();
        if(mRuntime.time()>1.8) {
            Push.setPower(0);
        }

    }
    public ElapsedTime mRuntime = new ElapsedTime();
}
