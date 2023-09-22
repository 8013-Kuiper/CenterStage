package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
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
public class intakeTest extends OpMode {

    public Servo Intake;
    public CRServo Push;

    public DcMotor Crane;

    public void init() {
        Intake = hardwareMap.get(Servo.class, "intake");
        Push = hardwareMap.get(CRServo.class, "push");
        Crane = hardwareMap.get(DcMotor.class,"crane");
    }

    @Override
    public void start() {
        super.start();

        mRuntime.reset();
    }

    public void loop() {

        Boolean IntakeIn;
        boolean IntakeOut;
        Boolean Push;
        Boolean Pull;
        double Cranepower;


        IntakeIn = gamepad1.right_bumper;
        IntakeOut = gamepad1.left_bumper;

        Cranepower = gamepad1.left_stick_y;

        Push = gamepad1.x;
        Pull = gamepad1.y;

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
